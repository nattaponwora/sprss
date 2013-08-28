package model;

import java.util.ArrayList;

public class EnteredRequisitionModel {
	
	/**ใช้สำหรับ Query ข้อมูลผู้ทำการหยิบอะไหล่จากคลังใน plant ที่ต้องการ 
	 * @param String ที่ระบุ plant ที่ต้องการรายชื่อผูู้หยิบอะไหล่ เช่น 0301 
	 * @return ArrayList ที่มีรายชื่อของผู้ที่สามารถหยิบอะหล่จากคลัง ใน plant ที่รับเข้ามาเป็น input
	 */
	public static ArrayList<String> getPicker( String plant ){
		ArrayList<String> picker = new ArrayList<String>(); 
		picker.add("มานะ  ไปใหน");
		picker.add("โสฬส  เทพพงค์ชัย");
		picker.add("สุริยัน  จันทร์ผ่อง");
		return picker;
	}
}
