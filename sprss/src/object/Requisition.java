package object;

public class Requisition {

	private Item item;
	private int authorID;
	private String plant;
	private int reqID;
	
	private Requisition( Item i , int authorID , String plant , int reqID ){
		item = i;
		this.authorID = authorID;
		this.plant = plant;
		this.reqID = reqID;
	}
	
	public Item getItem(){
		return item;
	}
	
	public int getAuthorID(){
		return authorID;
	}
	
	public String getPlant(){
		return plant;
	}
	
	public int getReqID(){
		return reqID;
	}
	
}
