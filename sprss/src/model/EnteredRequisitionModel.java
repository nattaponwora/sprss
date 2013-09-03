package model;

import java.util.ArrayList;

import object.Item;
import object.Requisition;
import object.RequisitionList;

public class EnteredRequisitionModel {
	
	/**ใช้สำหรับ Query ข้อมูลผู้ทำการหยิบอะไหล่จากคลังใน plant ที่ต้องการ 
	 * @param String ที่ระบุ plant ที่ต้องการรายชื่อผูู้หยิบอะไหล่ เช่น 0301 
	 * @return ArrayList ที่มีรายชื่อของผู้ที่สามารถหยิบอะหล่จากคลัง ใน plant ที่รับเข้ามาเป็น input
	 * @author Nattapon Worasakdapisan
	 */
	public static ArrayList<String> getPicker( String plant ){
		ArrayList<String> picker = new ArrayList<String>(); 
		picker.add("มานะ  ไปใหน");
		picker.add("โสฬส  เทพพงค์ชัย");
		picker.add("สุริยัน  จันทร์ผ่อง");
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
		Item i = new Item(70000, 1, "Item1" , "S12-01-01-02" , 1);
		Item j = new Item(70000, 2, "Item2" , "S12-01-01-03" , 2);
		Item k = new Item(70000, 3, "Item3" , "S12-03-04-03" , 1);
		Requisition r = new Requisition( 97912531, "0301", 70000 );
		r.addItem(i);
		r.addItem(j);
		r.addItem(k);
		reqList.add(r);
		i = new Item(70001, 2, "Item2" , "S12-01-01-03" , 1);
		j = new Item(70001, 3, "Item3" , "S12-03-04-03" , 1);
		k = new Item(70001, 4, "Item4" , "S12-04-01-02" , 2);
		r = new Requisition( 97912532, "0301", 70001 );
		r.addItem(i);
		r.addItem(j);
		r.addItem(k);
		reqList.add(r);
		i = new Item(70002, 1, "Item1" , "S12-01-01-02" , 4);
		j = new Item(70002, 2, "Item2" , "S12-01-01-03" , 3);
		r = new Requisition( 97912534, "0301", 70002 );
		r.addItem(i);
		r.addItem(j);
		reqList.add(r);
		return reqList;
	}
}
