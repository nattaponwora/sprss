/**
 * The class that store the information of user
 * @author POM
 */
package object;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private int eid;
	private String email;
	private String tel;
	private int usergroup;
	private String plant;
	private String storeroom;
	
	/**
	 * Constructor ����Ѻ���� User
	 * @param id = ���ʼ����ҹ
	 * @param firstname = ���ͼ����
	 * @param lastname = ���ʡ��ż����
	 * @param eid = ���ʾ�ѡ�ҹ
	 * @param email = �������ͧ�����ҹ
	 * @param tel = �������ѷ��ͧ�����
	 * @param usergroup = ����������
	 * @param plant = Plant �������ӧҹ�ҹ
	 * @param storeroom = ��ѧ�������ӧҹ
	 */
	public User(int id, String firstname, String lastname, int eid, String email, String tel, int usergroup, String plant, String storeroom ){
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
	
	public int getEID(){
		return eid;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getTel(){
		return tel;
	}
	
	public int getUsergroup(){
		return usergroup;
	}
	
	public String getPlant(){
		return plant;
	}
	
	public String getStoreroom(){
		return storeroom;
	}
}
