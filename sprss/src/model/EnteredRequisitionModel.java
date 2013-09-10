package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import object.Item;
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
		return picker;
	}
	
	/**Query ข้อมูลใบเบิกอะไหล่ที่มีสถานะเป็น Entered ทั้งหมด
	 * 
	 * @param plant ==> String ที่ระบุ plant ที่ต้องการหยิบอะไหล่
	 * @param storeroom ==> String ที่ระบุ storeroom ที่ต้องการหยิบอะไหล่ 
	 * @return ข้อมูลใบเบิกอะไหล่ที่ยังไม่ได้หยิบทั้งหมด โดยเป็นข้อมูลชนิด RequisitionList
	 * @author Nattapon Worasakdapisa
	 */
	public static RequisitionList getEnterReqList(String plant){
		RequisitionList reqList = new RequisitionList();
		Item i = new Item(70000, 1, "Item1" , "S12-01-01-02" , 1 , 97912531);
		Item j = new Item(70000, 2, "Item2" , "S12-01-01-03" , 2 , 97912531);
		Item k = new Item(70000, 3, "Item3" , "S12-03-04-03" , 1 , 97912531);
		Requisition r = new Requisition( 97912531, "สามี", "นาศรี", "E1", 70000, "02/09/2013", null ,"0301");
		r.addItem(i);
		r.addItem(j);
		r.addItem(k);
		reqList.add(r);
		i = new Item(70001, 2, "Item2" , "S12-01-01-03" , 1 , 97912532);
		j = new Item(70001, 3, "Item3" , "S12-03-04-03" , 1 , 97912532);
		k = new Item(70001, 4, "Item4" , "S12-04-01-02" , 2 , 97912532);
		r = new Requisition( 97912532, "เนวิน", "ชิดชอบ", "E1", 70001, "02/09/2013", null ,"0301" );
		r.addItem(i);
		r.addItem(j);
		r.addItem(k);
		reqList.add(r);
		i = new Item(70002, 1, "Item1" , "S12-01-01-02" , 4 , 97912534);
		j = new Item(70002, 2, "Item2" , "S12-01-01-03" , 3 , 97912534);
		r = new Requisition( 97912534, "ดนัย", "อุดมโชค", "E1", 70002, "02/09/2013", null ,"0301" );
		r.addItem(i);
		r.addItem(j);
		reqList.add(r);
		return reqList;
	}

}
