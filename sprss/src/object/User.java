package object;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String eid;
	private String email;
	private String position;
	private String plant;
	private String storeroom;
	
	/**
	 * Constructor ����Ѻ���� User
	 * @param id = ���ʼ����ҹ
	 * @param firstname = ���ͼ����
	 * @param lastname = ���ʡ��ż����
	 * @param eid = ���ʾ�ѡ�ҹ
	 * @param email = �������ͧ�����ҹ
	 * @param position = �Է��
	 * @param plant = Plant �������ӧҹ�ҹ
	 * @param storeroom = ��ѧ�������ӧҹ
	 */
	public User(int id, String firstname, String lastname, String eid, String email, String position, String plant, String storeroom ){
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.eid = eid;
		this.email = email;
		this.position = position;
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
	
	public String getEID(){
		return eid;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPosition(){
		return position;
	}
	
	public String getPlant(){
		return plant;
	}
	
	public String getStoreroom(){
		return storeroom;
	}
}
