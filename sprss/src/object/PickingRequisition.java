package object;

import java.util.Date;

public class PickingRequisition extends RequisitionList {
	
	private int id;
	private int eid;
	private String firstname;
	private String lastname;
	private Date begin;
	private Date finish;
	
	public PickingRequisition( int id , int eid , String firstname , String lastname, Date begin ){
		super();
		this.id = id;
		this.eid = eid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.begin = begin;
	}
	
	public PickingRequisition( int id , int eid , String firstname , String lastname, Date begin, Date finish ){
		super();
		this.id = id;
		this.eid = eid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.begin = begin;
		this.finish = finish;
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
	
	public Date getBegin(){
		return begin;
	}
	
	public Date getFinish(){
		return finish;
	}
	
}
