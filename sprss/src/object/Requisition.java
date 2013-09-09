/**
 * The class that store the item list
 * @author POM
 */
package object;

import java.util.ArrayList;

public class Requisition {

	private ArrayList<Item> itemList;
	private int authorID;
	private String authorFirstName;
	private String authorLastName;	
	private String authorTeam;	
	private int reqID;
	private String enteredDate;
	private String pickedDate;
	private String plant;
	private String status;
	private String type;
	private int itemNum;
	
	/**
	 * Constructor for Requisition class
	 * @param authorID
	 * @param plant
	 * @param reqID
	 */

	public Requisition( int authorID , String authorFirstName, String authorLastName, String authorTeam, int reqID, String enterDate, String pickedDate, String plant ){
		itemList = new ArrayList<Item>();
		this.authorID = authorID;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.authorTeam = authorTeam;		
		this.reqID = reqID;
		this.enteredDate = enterDate;
		this.pickedDate = pickedDate;
		this.plant = plant;
		itemNum = 0;
	}
	
	public ArrayList<Item> getItemList(){
		return itemList;
	}
	
	public int getAuthorID(){
		return authorID;
	}
	
	public String getAuthorFirstName(){
		return authorFirstName;
	}
	
	public String getAuthorLastName(){
		return authorLastName;
	}
	
	public String getAuthorName(){
		return authorFirstName + " " + authorLastName;
	}
	
	public String getAuthorTeam(){
		return authorTeam;
	}	
	
	public int getReqID(){
		return reqID;
	}
	
	public String getEnteredDate(){
		return enteredDate;
	}
	
	public String getPickedDate(){
		return pickedDate;
	}
	
	public void setPickedDate( String s ){
		this.pickedDate = s;
	}
	
	public String getPlant(){
		return plant;
	}
	
	public void addItem( Item item ){
		itemList.add(item);
		itemNum += item.getAmount();		
	}	
	
	public int size(){
		return itemList.size();
	}
	
	public int getItemNum(){
		return itemNum;
	}	
	
}
