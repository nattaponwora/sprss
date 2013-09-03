package object;

import java.util.ArrayList;

public class Requisition {

	private ArrayList<Item> itemList;
	private int authorID;
	private String plant;
	private int reqID;
	private int itemNum;
	
	/**
	 * Constructor for Requisition class
	 * @param authorID
	 * @param plant
	 * @param reqID
	 */

	public Requisition( int authorID , String plant , int reqID ){
		itemList = new ArrayList<Item>();
		this.authorID = authorID;
		this.plant = plant;
		this.reqID = reqID;
		itemNum = 0;
	}
	
	public ArrayList<Item> getItemList(){
		return itemList;
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