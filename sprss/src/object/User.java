/**
 * The class that store the information of user
 * @author POM
 */
package object;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String eid;
	private String email;
	private String tel;
	private String usergroup;
	private String plant;
	private String storeroom;
	
	/**
	 * Constructor สำหรับคลาส User
	 * @param id = รหัสผู้ใช้งาน
	 * @param firstname = ชื่อผู้ใช้
	 * @param lastname = นามสกุุลผู้ใช้
	 * @param eid = รหัสพนักงาน
	 * @param email = อีเมลล์ของผู้ใช้งาน
	 * @param tel = เบอร์โทรศัทพ์ของผู้ใช้
	 * @param usergroup = กลุ่มผู้ใช้
	 * @param plant = Plant ที่ผู้ใช้ทำงานงาน
	 * @param storeroom = คลังที่ผู้ใช้ทำงาน
	 */
	public User(int id, String firstname, String lastname, String eid, String email, String tel, String usergroup, String plant, String storeroom ){
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.eid = eid;
		this.email = email;
		this.tel = tel;
		this.usergroup = usergroup;
		this.plant = plant;
		this.storeroom = storeroom;
	}
	
	public int getID(){
		return id;
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	public String getName(){
		return firstname + " " + lastname;
	}
	
	public String getEID(){
		return eid;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getTel(){
		return tel;
	}
	
	public String getUsergroup(){
		return usergroup;
	}
	
	public String getPlant(){
		return plant;
	}
	
	public String getStoreroom(){
		return storeroom;
	}
}
