package object;

import java.util.ArrayList;

public class SelectItemList {

	private ArrayList<Item> items;
	
	public SelectItemList(  ){
		items = new ArrayList<Item>();
	}
	
	public void add( Item item ){
		if( items.size() == 0 ){
			items.add(item);
		}
		else{
			for( int i = items.size() - 1 ; i >= 0 ; i-- ){
				if( item.getAssetNO() == items.get(i).getAssetNO() ){
					items.add(i+1, item);
					break;
				}
				else if( item.compareToStoreType(items.get(i)) > 0 ){
					items.add(i+1, item);
					break;
				}
				else if( item.compareToStoreType(items.get(i)) == 0 ){
					if( item.compareToLog(items.get(i)) == 0 ){
						if( item.compareToShelf(items.get(i)) == 0 ){
							if( item.compareToBasket(items.get(i)) == 0 ){
								if( item.compareToBag(items.get(i)) == 0 || item.compareToBag(items.get(i)) < 0 ){
									items.add(i+1 , item);
									break;
								}
								else{
									items.add(i , item);
									break;
								}							
							}
							if( item.compareToBasket(items.get(i)) < 0 ){
								items.add(i+1 , item);
							}							
						}
					}
				}
			}
		}
	}	
	
}