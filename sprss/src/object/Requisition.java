/**
 * The class that store the item list
 * @author POM
 */
package object;

import java.util.ArrayList;
import java.util.Date;

public class Requisition {

	private ArrayList<Item> itemList;
	private int authorID;
	private String authorName;
	private String authorTeam;	
	private int reqID;
	private Date enteredDate;
	private Date pickedDate;	
	private String plant;
	private String storeroom;
	private String status;
	private String type;
	private int totalItem;
	
	/**
	 * Constructor for Requisition class
	 * @param authorID
	 * @param plant
	 * @param reqID
	 */

	public Requisition(int reqID, int authorID , String authorName, String authorTeam, Date enterDate, String plant, String storeroom, String status , String type ){
		itemList = new ArrayList<Item>();
		this.authorID = authorID;
		this.authorName = authorName;
		this.authorTeam = authorTeam;		
		this.reqID = reqID;
		this.enteredDate = enterDate;
		this.pickedDate = null;
		this.plant = plant;
		this.storeroom = storeroom;
		this.status = status;
		this.type = type;
		totalItem = 0;
	}
	
	public ArrayList<Item> getItemList(){
		return itemList;
	}
	
	public int getAuthorID(){
		return authorID;
	}
	
	public String getAuthorName(){
		return authorName;
	}
	
	public String getAuthorTeam(){
		return authorTeam;
	}	
	
	public int getReqID(){
		return reqID;
	}
	
	public Date getEnteredDate(){
		return enteredDate;
	}
	
	public Date getPickedDate(){
		return pickedDate;
	}
	
	public void setPickedDate( Date d ){
		this.pickedDate = d;
	}
	
	public String getPlant(){
		return plant;
	}
	
	public String getStoreroom(){
		return storeroom;
	}
	
	public String getStatus(){
		return status;
	}
	
	public String getType(){
		return type;
	}
	
	public void addItem( Item item ){
		itemList.add(item);
		totalItem += item.getAmount();		
	}	
	
	public int size(){
		return itemList.size();
	}
	
	public int getTotalItem(){
		return totalItem;
	}	
	
}
