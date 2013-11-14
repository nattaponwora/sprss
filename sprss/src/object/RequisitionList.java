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
	
	private void sortByInt( String row ){
		int n = reqList.size();
		for (int i = 1; i < n; i++){
			int j = i;  
			int nowK = getKey( reqList.get(i) , row );
			int beforeK = getKey( reqList.get(j-1) , row );
			  
			while ((j > 0) && ( beforeK > nowK )){
				j--;
				if( j > 0 ){
					beforeK = getKey( reqList.get(j-1) , row );
				}
				  
			}
			reqList.add(j, reqList.remove(i));
		}
	}
	
	private void sortByString( String row ){
		int n = reqList.size();
		for (int i = 1; i < n; i++){
			int j = i;  
			String nowK = reqList.get(i).getAuthorTeam();
			String beforeK = reqList.get(j-1).getAuthorTeam() ;
			  
			while ((j > 0) && ( beforeK.compareToIgnoreCase( nowK ) > 0 )){
				j--;
				if( j > 0 ){
					beforeK = reqList.get(j-1).getAuthorTeam() ;
				}
				  
			}
			reqList.add(j, reqList.remove(i));
		}
	}
	
	public void sort(String row){
		if( row.equals("team") ){
			sortByString( row );
		}else{
			sortByInt( row );
		}
		
	}
	
	public boolean isContain( int id ){
		for( int i = 0 ; i < reqList.size() ; i++ ){
			if( reqList.get(i).getReqID() == id ){
				return true;
			}
		}
		return false;
	}
	
	private int getKey( Requisition r, String row ){
		switch (row){
			case "reqID" : return r.getReqID();
			case "eid" : return r.getAuthorID();
			case "item" : return r.size();
			default : return r.getReqID();
		}
	}
}
