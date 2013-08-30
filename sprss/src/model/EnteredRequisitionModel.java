package model;

import java.util.ArrayList;

import object.Item;
import object.Requisition;

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
	 * @return ข้อมูลใบเบิกอะไหล่ที่ยังไม่ได้หยิบทั้งหมด โดยเป็นข้อมูลชนิด ArrayList<Requisition>
	 * @author Nattapon Worasakdapisan
	 */
	public static ArrayList<Requisition> getEnterReqList(String plant){
		ArrayList<Requisition> reqList = new ArrayList<Requisition>();
		Item i = new Item(1, "Item1" , "S12-01-01-02" , 1);
		Item j = new Item(2, "Item2" , "S12-01-01-03" , 2);
		Item k = new Item(2, "Item3" , "S12-03-04-03" , 1);
		//reqList.add();
		Requisition r = new Requisition(null, 0, null, 0);
		return reqList;
	}
}
