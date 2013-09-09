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
}
