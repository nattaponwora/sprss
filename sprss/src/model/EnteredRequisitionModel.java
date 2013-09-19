package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import object.Item;
import object.ItemList;
import object.Requisition;
import object.RequisitionList;
import object.User;

public class EnteredRequisitionModel {
	
	/**������Ѻ Query �����ż��ӡ����Ժ������ҡ��ѧ� plant ����ͧ��� 
	 * @param String ����к� plant ����ͧ�����ª��ͼ�����Ժ������ �� 0301 
	 * @return ArrayList �������ª��ͧ͢���������ö��Ժ�����ҡ��ѧ � plant ����Ѻ������� input
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
	
	/**Query ��������ԡ����������ʶҹ��� Entered ������
	 * 
	 * @param plant ==> String ����к� plant ����ͧ�����Ժ������
	 * @param storeroom ==> String ����к� storeroom ����ͧ�����Ժ������ 
	 * @return ��������ԡ���������ѧ�������Ժ������ ���繢����Ū�Դ RequisitionList
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
			reqList.add( new Requisition( rs.getInt("req_id"), rs.getInt("resv_eid") ,  rs.getString("resv_name"), rs.getString("resv_team") , rs.getDate("enterdate") , plant , storeroom ,rs.getString("status") , rs.getString("type")) );
			reqNumList[i] = rs.getInt("req_id");
			i++;
		}
		
		query =   "SELECT itemusage_id , itemnum, description, binnum, amount, requisition.req_id "
				+ "FROM itemusage join requisition on itemusage.req_id = requisition.req_id "
				+ "WHERE requisition.status = 'entered' AND requisition.plant = '"+ plant +"' AND requisition.storeroom = '" + storeroom + "'  "
				+ "ORDER BY req_id asc";
		
		rs = stm.executeQuery( query );
		while( rs.next() ){
			int req = rs.getInt("req_id");
			Requisition r =  reqList.getByID( req );
			r.addItem( new Item( req, rs.getInt("itemnum"), rs.getString("description") , rs.getString("binnum"), rs.getInt("amount"), r.getAuthorID() ) );
		}
		
		stm.close();
		return reqList;
	}
	
	public static int insertSelectRequisition( User u, RequisitionList rl, ItemList il) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		int sid = createSelReqID( u.getID() , stm );
		updatePickingData(rl , il , sid,  stm);
		return sid;
		
		//String query = "UPDATE"
	}
	
	private static int createSelReqID( int id, Statement stm ) throws SQLException{
		String query = "INSERT INTO selreq ( uid ) VALUE ( '" + id + "' )";
		stm.execute(query , Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stm.getGeneratedKeys();
		int selreq_id = 0;
		if( rs.next() ){
			selreq_id = rs.getInt(1);
		}
		return selreq_id;
	}
	
	private static void updatePickingData(RequisitionList rl, ItemList il , int sid, Statement stm) throws SQLException{
		String query = "UPDATE requisition SET status = 'picked' , selreq_id = '"+ sid +"' WHERE req_id IN (";
				query+= "'"+ rl.get(0).getReqID() + "'";
				for(int i=1 ; i< rl.size(); i++){
					query += ",'" + rl.get(i).getReqID() + "'";
				}
				
		query += ")";
		stm.executeUpdate(query);
	}

}
