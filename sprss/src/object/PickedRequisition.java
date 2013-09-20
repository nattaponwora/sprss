package object;

public class PickedRequisition extends RequisitionList {
	
	private int id;
	private int eid;
	private String firstname;
	private String lastname;
	
	public PickedRequisition( int id , int eid , String firstname , String lastname ){
		super();
		this.id = id;
		this.eid = eid;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public int getID(){
		return id;
	}
	
	public int getEid(){
		return eid;
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
	
}
