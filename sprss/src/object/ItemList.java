package object;

import java.util.ArrayList;

public class ItemList {

	private ArrayList<Item> items;
	
	public ItemList(  ){
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
					return;
				}
				if( i < 0 ){
					items.add(0 , item);
				}
				if( item.compareToStoreType(items.get(i)) > 0 ){
					items.add(i+1, item);
					return;
				}
				if( item.compareToStoreType(items.get(i)) == 0 ){
					if( item.compareToLog(items.get(i)) == 0 ){
						if( item.compareToShelf(items.get(i)) == 0 ){
							if( item.compareToBasket(items.get(i)) == 0 ){
								if( item.compareToBag(items.get(i)) == 0 || item.compareToBag(items.get(i)) < 0 ){
									items.add(i+1 , item);
									return;
								}
								else{
									items.add(i , item);
									return;
								}							
							}
							else if( item.compareToBasket(items.get(i)) < 0 ){
								items.add(i+1 , item);
								return;
							}
							else{
								items.add(i , item);
								return;
							}
						}
						else if( item.compareToShelf(items.get(i)) < 0 ){
							items.add(i+1, item);
							return;
						}
						else{
							items.add(i, item);
							return;
						}
					}
					else if( item.compareToLog(items.get(i)) < 0 ){
						items.add(i+1 , item);
						return;
					}
					else{
						items.add(i, item);
						return;
					}
				}
			}
		}
	}	
	
}