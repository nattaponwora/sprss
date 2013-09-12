/**
 * The class that store the item list
 * @author POM
 */
package object;

import java.sql.Date;
import java.util.ArrayList;

public class Requisition {

	private ArrayList<Item> itemList;
	private int authorID;
	private String authorName;
	private String authorTeam;	
	private int reqID;
	private Date enteredDate;
	private String pickedDate;
	private String plant;
	private int totalItem;
	
	/**
	 * Constructor for Requisition class
	 * @param authorID
	 * @param plant
	 * @param reqID
	 */

	public Requisition(int reqID, int authorID , String authorName, String authorTeam, Date enterDate, String pickedDate, String plant ){
		itemList = new ArrayList<Item>();
		this.authorID = authorID;
		this.authorName = authorName;
		this.authorTeam = authorTeam;		
		this.reqID = reqID;
		this.enteredDate = enterDate;
		this.pickedDate = pickedDate;
		this.plant = plant;
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
		totalItem += item.getAmount();		
	}	
	
	public int size(){
		return itemList.size();
	}
	
	public int getTotalItem(){
		return totalItem;
	}	
	
}
