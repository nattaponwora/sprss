package object;

import java.util.ArrayList;

public class SelectItemList {

	private ArrayList<Requisition> req;
	
	public SelectItemList(  ){
		req = new ArrayList<Requisition>();
	}
	
	public void addRequisition( Requisition r ){
		req.add(r);
	}
	
	public ArrayList<Item> getRequisition(){
		ArrayList<Item> requisition = new ArrayList<Item>();
		for( int i = 0 ; i < req.size() ; i++ ){
			for( int j = 0 ; j < req.get(i).size() ; j++ ){
				if( requisition.size() == 0 ){
					requisition.add( req.get(i).getItem().get(j) );
				}
				else{
					for( int k = 0 ; k < requisition.size() ; k++ ){
						
					}
				}
			}
		}
		return requisition;
	}
}