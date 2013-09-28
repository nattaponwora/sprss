package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import object.Item;
import object.ItemList;
import object.PickingRequisition;
import object.Requisition;
import object.RequisitionList;
import object.User;

public class EnteredRequisitionModel {
	
	/**ใช้สำหรับ Query ข้อมูลผู้ทำการหยิบอะไหล่จากคลังใน plant ที่ต้องการ 
	 * @param String ที่ระบุ plant ที่ต้องการรายชื่อผูู้หยิบอะไหล่ เช่น 0301 
	 * @return ArrayList ที่มีรายชื่อของผู้ที่สามารถหยิบอะหล่จากคลัง ใน plant ที่รับเข้ามาเป็น input
	 * @author Nattapon Worasakdapisan
	 * @throws SQLException 
	 */
	public static ArrayList<User> getPicker( String plant, String storeroom) throws SQLException{
		ArrayList<User> picker = new ArrayList<User>();
		Statement stm = StatementManager.getSQLStatement();
		String query = "SELECT uid, firstname, lastname, eid, email, tel, usergroup FROM user WHERE plant='" + plant + "' AND storeroom = '" + storeroom + "' AND usergroup > '1' ";		
		ResultSet rs = stm.executeQuery(query);
		while ( rs.next() ){
			int id = rs.getInt("uid");
			String firstname = rs.getString( "firstname" );
			String lastname = rs.getString( "lastname" );
			int eid = rs.getInt( "eid" );
			String email = rs.getString( "email" );
			String tel = rs.getString( "tel" );
			int usergroup = rs.getInt( "usergroup" );
			picker.add( new User( id, firstname, lastname, eid, tel, email, usergroup, plant, storeroom ) ) ;
		}
		stm.close();
		return picker;
	}
	
	/**Query ข้อมูลใบเบิกอะไหล่ที่มีสถานะเป็น Entered ทั้งหมด
	 * 
	 * @param plant ==> String ที่ระบุ plant ที่ต้องการหยิบอะไหล่
	 * @param storeroom ==> String ที่ระบุ storeroom ที่ต้องการหยิบอะไหล่ 
	 * @return ข้อมูลใบเบิกอะไหล่ที่ยังไม่ได้หยิบทั้งหมด โดยเป็นข้อมูลชนิด RequisitionList
	 * @author Nattapon Worasakdapisa
	 * @throws SQLException 
	 */
	public static RequisitionList getEnterReqList(String plant, String storeroom) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = 	  "SELECT req_id ,resv_eid, resv_name, resv_team, enterdate, status, type "
						+ "FROM requisition "
						+ "WHERE status = 'entered' AND plant = '"+ plant +"' AND storeroom = '" + storeroom + "'  "
						+ "ORDER BY req_id asc";
		ResultSet rs = stm.executeQuery( query );
		rs.last(); 
		int total = rs.getRow();
		rs.beforeFirst();
		int reqNumList[] = new int[ total ];
		RequisitionList reqList = new RequisitionList();
		
		int i=0;
		while ( rs.next() ){
			reqList.add( new Requisition( rs.getInt("req_id"), rs.getInt("resv_eid") ,  rs.getString("resv_name"), rs.getString("resv_team") , rs.getTimestamp("enterdate") , plant , storeroom ,rs.getString("status") , rs.getString("type")) );
			reqNumList[i] = rs.getInt("req_id");
			i++;
		}
		
		query =   "SELECT itemusage_id , itemnum, description, binnum, amount, unit, requisition.req_id "
				+ "FROM itemusage join requisition on itemusage.req_id = requisition.req_id "
				+ "WHERE requisition.status = 'entered' AND requisition.plant = '"+ plant +"' AND requisition.storeroom = '" + storeroom + "'  "
				+ "ORDER BY req_id asc";
		
		rs = stm.executeQuery( query );
		while( rs.next() ){
			int req = rs.getInt("req_id");
			Requisition r =  reqList.getByID( req );
			r.addItem( new Item( req, rs.getInt("itemnum"), rs.getString("description") , rs.getString("binnum"), rs.getInt("amount"), rs.getString("unit"), r.getAuthorID() ) );
		}
		
		stm.close();
		return reqList;
	}
	
	public static int insertSelectRequisition( User u, RequisitionList rl, ItemList il) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		int sid = createSelReqID( u.getID() , stm );
		updatePickingData(rl , il , sid,  stm);
		stm.close();
		return sid;
		
		//String query = "UPDATE"
	}
	
	private static int createSelReqID( int id, Statement stm ) throws SQLException{
		String query = "INSERT INTO selreq ( uid , status ) VALUE ( '" + id + "' , 'pick' )";
		stm.execute(query , Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stm.getGeneratedKeys();
		int selreq_id = 0;
		if( rs.next() ){
			selreq_id = rs.getInt(1);
		}
		stm.close();
		return selreq_id;
	}
	
	private static void updatePickingData(RequisitionList rl, ItemList il , int sid, Statement stm) throws SQLException{
		String query = "UPDATE requisition SET status = 'pick' , selreq_id = '"+ sid +"' WHERE req_id IN (";
				query+= "'"+ rl.get(0).getReqID() + "'";
				for(int i=1 ; i< rl.size(); i++){
					query += ",'" + rl.get(i).getReqID() + "'";
				}
				
		query += ")";
		stm.executeUpdate(query);
		stm.close();
	}
	
	public static RequisitionList getSelectRequisition( int id ) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = 
				  "SELECT r.req_id, resv_eid, resv_name, resv_team , enterdate , plant , storeroom, r.status, r.type  "
				+ "FROM selreq s "
				+ "JOIN requisition r ON s.selreq_id = r.selreq_id "
				+ "WHERE s.selreq_id = " + id;
		ResultSet rs = stm .executeQuery(query);
		
		
		
		RequisitionList selreq = new RequisitionList();
		while ( rs.next() ){
			Requisition r = new Requisition(rs.getInt("req_id"), rs.getInt("resv_eid"), rs.getString("resv_name"), rs.getString("resv_team"), rs.getTimestamp("enterdate"), rs.getString("plant"), rs.getString("storeroom"), rs.getString("status"), rs.getString("type"));
			selreq.add(r);
		}
		stm.close();
		return selreq;
	}
	
	public static ItemList getItemListBySelID( int id ) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = 
				  "SELECT r.req_id, i.itemnum, i.description, i.binnum, i.amount, i.unit , r.resv_eid "
				+ "FROM itemusage i join requisition r on i.req_id = r.req_id "
				+ "WHERE r.selreq_id = " + id ;
		ResultSet rs = stm .executeQuery(query);
		ItemList list = new ItemList();
		while ( rs.next() ){
			Item item = new Item(rs.getInt("req_id"), rs.getInt("itemnum"), rs.getString("description"), rs.getString("binnum"), rs.getInt("amount"),rs.getString("unit"), rs.getInt("resv_eid"));
			list.add(item);
		}
		stm.close();
		return list;
	}
	
	public static User getSelPicker( int id ) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = 
				"SELECT u.uid , firstname, lastname, eid, email, tel, usergroup, plant, storeroom "
				+ "FROM user u join selreq s on u.uid = s.uid "
				+ "WHERE s.selreq_id = "+id;
		ResultSet rs = stm .executeQuery(query);
		rs.next();
		stm.close();
		return new User(rs.getInt("uid"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("eid"), rs.getString("eid"), rs.getString("tel"), rs.getInt("usergroup"), rs.getString("plant"), rs.getString("storeroom"));
	}

}