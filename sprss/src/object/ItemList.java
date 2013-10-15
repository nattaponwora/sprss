/**
 * The class that contain the item to pick.
 * @author POM
 */
package object;

import java.util.ArrayList;

public class ItemList {

	private ArrayList<Item> items;
	private final String storeTypeCode[] = {"S" , "F" , "R"};
	/*private ArrayList<Item> s;
	private ArrayList<Item> f;
	private ArrayList<Item> r;
	private ArrayList<Item> n;
	private ArrayList<Item> o;*/
	
	public ItemList(  ){
		items = new ArrayList<Item>();
	}
	
	public int size(){
		return items.size();
	}
	
	public Item getItem( int i ){
		return items.get(i);
	}
	
	/**
	 * Compare Store Type
	 * @return  1 if i greater than j
	 * 			0 if equal
	 * 		   -1 if i less than j
	 * 
	 * @author Nattapon Worasakdapisan 
	 */
	private int storeTypeCompare( Item i , Item j ){
		String iCode = i.getStoreType();
		String jCode = j.getStoreType();
		int iPriority = Integer.MAX_VALUE, jPriority = Integer.MAX_VALUE;
		for(int index = 0 ; index < storeTypeCode.length ; index++){
			if( iCode.equalsIgnoreCase(storeTypeCode[index]) ){
				iPriority = index;
			}
			
			if( jCode.equalsIgnoreCase(storeTypeCode[index]) ){
				jPriority = index;
			}
		}
		if( iPriority == Integer.MAX_VALUE ){
			return -1;
		}
		if( iPriority < jPriority ){
			return 1;
		}else if ( iPriority > jPriority ){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * Compare 2 item 
	 * @param i first item
	 * @param j second item
	 * @return  1 if i greater than j
	 * 			0 if equal
	 * 		   -1 if i less than j
	 * @author Nattapon Worasakdapisan
	 */
	private int itemCompare( Item i , Item j ){
		int rsStoreComp = storeTypeCompare( i , j );
		if( rsStoreComp == 0 ){
			if( i.compareToLog(j) == 0 ){
				if( i.compareToShelf(j) == 0 ){
					if( i.compareToBasket(j) == 0 ){
						return i.compareToBag(j);
					}else{
						return i.compareToBasket(j);
					}
				}else{
					return i.compareToShelf(j);
				}
			}else{
				return i.compareToLog(j);
			}
		}else{
			return rsStoreComp;
		}
		
	}
	
	public void add( Item nItem ){
		if( items.size() == 0 ){
			items.add(nItem);
		}else{
			for( int i = items.size() - 1 ; i >= 0 ; i-- ){
				if( itemCompare( nItem , items.get(i) ) != 1 ){
					items.add( i+1, nItem );
					return;
				}
			}
			items.add( 0, nItem );
		}
	}
	
	public Item get(int i){
		return items.get(i);
	}
	
}