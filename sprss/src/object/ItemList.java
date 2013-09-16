/**
 * The class that contain the item to pick.
 * @author POM
 */
package object;

import java.util.ArrayList;

public class ItemList {

	private ArrayList<Item> items;
	
	public ItemList(  ){
		items = new ArrayList<Item>();
	}
	
	public int size(){
		return items.size();
	}
	
	public Item getItem( int i ){
		return items.get(i);
	}
	
	public void add( Item item ){		
		if( items.size() == 0 ){
			items.add(item);
		}
		else{
			for( int i = items.size() - 1 ; i >= 0 ; i-- ){
				if( item.getStoreType().equals("0") ){
					items.add(0, item);
					return;
				}
				if( item.getStoreType().equals("N") ){
					items.add(item);
					return;
				}
				if( item.getAssetNO().equals(items.get(i).getAssetNO()) ){
					items.add(i+1, item);
					return;
				}				
				if( item.compareToStoreType(items.get(i)) > 0 && !(items.get(i).getStoreType().equals("N")) ){
					items.add(i+1, item);
					return;
				}
				if( item.compareToStoreType(items.get(i)) == 0 ){
					if( item.compareToLog(items.get(i)) == 0 ){
						if( item.compareToShelf(items.get(i)) == 0 ){
							if( item.compareToBasket(items.get(i)) == 0 ){
								if( item.compareToBag(items.get(i)) == 0 || item.compareToBag(items.get(i)) < 0 ){
									items.add(i+1, item);
									return;
								}
							}
							if( item.compareToBasket(items.get(i)) < 0 ){
								items.add(i+1, item);
								return;
							}
						}
						if( item.compareToShelf(items.get(i)) < 0 ){
							items.add(i+1 , item);
							return;
						}
					}
					if( item.compareToLog(items.get(i)) < 0 ){
						items.add(i+1, item);
						return;
					}
				}
			}
			items.add(0 , item);
		}
	}	
	
}