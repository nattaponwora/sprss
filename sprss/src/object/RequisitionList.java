/**
 * The class that store requisition list
 * @author POM
 */
package object;

import java.util.ArrayList;

public class RequisitionList  {
	ArrayList<Requisition> reqList;
	int itemNum;
	
	public RequisitionList(){
		reqList = new ArrayList<Requisition>();
		itemNum = 0;
	}
	
	public int getItemNum(){
		return itemNum;
	}
	
	public void add( Requisition r ){
		reqList.add(r);
		itemNum += r.getTotalItem();
	}
	
	public Requisition get(int i){
		return reqList.get(i);
	}
	
	public int size(){
		return reqList.size();
	}
	
	public Requisition getByID( int reqID ){
		for( int i = 0 ; i < reqList.size() ; i++ ){
			if( reqID == reqList.get(i).getReqID() ){
				return reqList.get(i);
			}
		}
		return null;
	}
	
	public void sort(String key){
		int n = reqList.size();
		for (int i = 1; i < n; i++){
			  int j = i;
			  
			  Requisition r = reqList.get(i);
			  String nowK = getKey( reqList.get(i) , key );
			  String beforeK = getKey( reqList.get(j-1) , key );
			  
			  while ((j > 0) && ( beforeK.compareToIgnoreCase( nowK ) > 0 )){
				  j--;
				  if( j > 0 ){
					  beforeK = getKey( reqList.get(j-1) , key );
				  }
				  
			  }
			  reqList.add(j, reqList.remove(i));
			  }
	}
	
	private String getKey( Requisition r, String key ){
		String tmp;
		switch (key){
			case "reqID" : return r.getReqID() + "";
			case "team" : return r.getAuthorTeam();
			case "eid" : return r.getAuthorID() + "";
			case "item" : return r.size() + "";
			default : return r.getReqID() + "";
		}
	}
}
