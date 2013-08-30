package object;

import java.util.ArrayList;

public class Requisition {

	private ArrayList<Item> itemList;
	private int authorID;
	private String plant;
	private int reqID;
	
	/**
	 * Constructor for Requisition class
	 * @param i
	 * @param authorID
	 * @param plant
	 * @param reqID
	 */
	public Requisition( Item i , int authorID , String plant , int reqID ){
		itemList = new ArrayList<Item>();
		this.authorID = authorID;
		this.plant = plant;
		this.reqID = reqID;
	}
	
	public ArrayList<Item> getItem(){
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
	}	
	
}
