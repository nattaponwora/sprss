/**
 * The class that contain the item to pick.
 * @author POM
 */
package object;

import java.util.ArrayList;

public class ItemList {

	private ArrayList<Item> items;
	/*private ArrayList<Item> s;
	private ArrayList<Item> f;
	private ArrayList<Item> r;
	private ArrayList<Item> n;
	private ArrayList<Item> o;*/
	
	public ItemList(  ){
		items = new ArrayList<Item>();
		/*s = new ArrayList<Item>();
		f = new ArrayList<Item>();
		r = new ArrayList<Item>();
		n = new ArrayList<Item>();
		o = new ArrayList<Item>();*/
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
					items.add(0 , item);
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
			return;
		}
			
	}
	
	public void sort(){
		ArrayList<Item> s = new ArrayList<Item>();
		ArrayList<Item> f = new ArrayList<Item>();
		ArrayList<Item> r = new ArrayList<Item>();
		ArrayList<Item> n = new ArrayList<Item>();
		ArrayList<Item> o = new ArrayList<Item>();
		for( int i = 0 ; i < items.size() ; i++ ){
			if( items.get(i).getStoreType().equals("S") ){
				s.add(items.get(i));
			}
			else if( items.get(i).getStoreType().equals("F")){
				f.add(items.get(i));
			}
			else if( items.get(i).getStoreType().equals("R") ){
				r.add(items.get(i));
			}
			else if( items.get(i).getStoreType().equals("N") ){
				if( n.size() == 0 ){
					n.add(items.get(i));
				}
				else{
					for( int j = 0 ; j < n.size() ; j++ ){
						int temp = Integer.valueOf(n.get(j).getAssetNO().substring(n.get(j).getAssetNO().length()-2));
						int temp2 = Integer.valueOf(items.get(i).getAssetNO().substring(items.get(i).getAssetNO().length()-2));
						if( temp2 >= temp ){
							n.add(j, items.get(i));
						}
						else{
							if( j == n.size()-1 ){
								n.add(items.get(i));
							}
						}
					}
					
				}
			}
			else{
				o.add(items.get(i));
			}
		}
		items.clear();
		items.addAll(s);
		items.addAll(f);
		items.addAll(r);
		items.addAll(n);
		items.addAll(o);			
	}
	
	/*public void add( Item item ){
	if( item.getStoreType().equals("S") ){
		if( s.size() == 0 ){
			s.add(item);
		}
		else{
			for( int i = s.size()-1 ; i >= 0 ; i-- ){
				if( item.compareToLog(s.get(i)) == 0 ){
					if( item.compareToShelf(s.get(i)) == 0 ){
						if( item.compareToBasket(s.get(i)) == 0 ){
							if( item.compareToBag(s.get(i)) == 0 || item.compareToBag(s.get(i)) < 0 ){
								s.add(i+1, item);
							}
							else{
								if( i == 0 ){
									s.add(i, item);
								}
							}
						}
						else if( item.compareToBasket(s.get(i)) < 0 ){
							s.add(i+1, item);
						}
						else{
							if( i == 0 ){
								s.add(i, item);
							}
						}
					}
					else if( item.compareToShelf(s.get(i)) < 0 ){
						s.add(i+1 , item);
					}
					else{
						if( i == 0 ){
							s.add(i, item);
						}
					}
				}
				else if( item.compareToLog(s.get(i)) < 0 ){
					s.add(i+1, item);
				}
				else{
					if( i == 0 ){
						s.add(i, item);
					}
				}
			}
		}
	}		
	else if( item.getStoreType().equals("F") ){
		if( f.size() == 0 ){
			f.add(item);
		}
		else{
			for( int i = f.size()-1 ; i >= 0 ; i-- ){
				if( item.compareToLog(f.get(i)) == 0 ){
					if( item.compareToShelf(f.get(i)) == 0 ){
						if( item.compareToBasket(f.get(i)) == 0 ){
							if( item.compareToBag(f.get(i)) == 0 || item.compareToBag(f.get(i)) < 0 ){
								f.add(i+1, item);
							}
							else{
								if( i == 0 ){
									f.add(i, item);
								}
							}
						}
						else if( item.compareToBasket(f.get(i)) < 0 ){
							f.add(i+1, item);
						}
						else{
							if( i == 0 ){
								f.add(i, item);
							}
						}
					}
					else if( item.compareToShelf(f.get(i)) < 0 ){
						f.add(i+1 , item);
					}
					else{
						if( i == 0 ){
							f.add(i, item);
						}
					}
				}
				else if( item.compareToLog(f.get(i)) < 0 ){
					f.add(i+1, item);
				}
				else{
					if( i == 0 ){
						f.add(i, item);
					}
				}
			}
		}
	}
	else if( item.getStoreType().equals("R") ){
		if( r.size() == 0 ){
			r.add(item);
		}
		else{
			for( int i = r.size()-1 ; i >= 0 ; i-- ){
				if( item.compareToLog(r.get(i)) == 0 ){
					if( item.compareToShelf(r.get(i)) == 0 ){
						if( item.compareToBasket(r.get(i)) == 0 ){
							if( item.compareToBag(r.get(i)) == 0 || item.compareToBag(r.get(i)) < 0 ){
								r.add(i+1, item);
							}
							else{
								if( i == 0 ){
									r.add(i, item);
								}
							}
						}
						else if( item.compareToBasket(r.get(i)) < 0 ){
							r.add(i+1, item);
						}
						else{
							if( i == 0 ){
								r.add(i, item);
							}
						}
					}
					else if( item.compareToShelf(r.get(i)) < 0 ){
						r.add(i+1 , item);
					}
					else{
						if( i == 0 ){
							r.add(i, item);
						}
					}
				}
				else if( item.compareToLog(r.get(i)) < 0 ){
					r.add(i+1, item);
				}
				else{
					if( i == 0 ){
						r.add(i, item);
					}
				}
			}
		}
	}
	if( item.getStoreType().equals("S") ){
		if( s.size() == 0 ){
			s.add(item);
		}
		else{
			for( int i = s.size()-1 ; i >= 0 ; i-- ){
				if( item.compareToLog(s.get(i)) == 0 ){
					if( item.compareToShelf(s.get(i)) == 0 ){
						if( item.compareToBasket(s.get(i)) == 0 ){
							if( item.compareToBag(s.get(i)) == 0 || item.compareToBag(s.get(i)) < 0 ){
								s.add(i+1, item);
							}
							else{
								if( i == 0 ){
									s.add(i, item);
								}
							}
						}
						else if( item.compareToBasket(s.get(i)) < 0 ){
							s.add(i+1, item);
						}
						else{
							if( i == 0 ){
								s.add(i, item);
							}
						}
					}
					else if( item.compareToShelf(s.get(i)) < 0 ){
						s.add(i+1 , item);
					}
					else{
						if( i == 0 ){
							s.add(i, item);
						}
					}
				}
				else if( item.compareToLog(s.get(i)) < 0 ){
					s.add(i+1, item);
				}
				else{
					if( i == 0 ){
						s.add(i, item);
					}
				}
			}
		}
	}
	else if( item.getStoreType().equals("N") ){
		if( n.size() == 0 ){
			n.add(item);
		}
		else{
			for( int j = 0 ; j < n.size() ; j++ ){
				int temp = Integer.valueOf(n.get(j).getAssetNO().substring(n.get(j).getAssetNO().length()-2));
				int temp2 = Integer.valueOf(item.getAssetNO().substring(item.getAssetNO().length()-2));
				if( temp2 >= temp ){
					n.add(j, item);
				}
				else{
					if( j == n.size()-1 ){
						n.add(item);
					}
				}
			}
			
		}
	}
	else{
		o.add(item);
	}
	items.clear();
	items.addAll(s);
	items.addAll(f);
	items.addAll(r);
	items.addAll(n);
	items.addAll(o);
	
}*/
	
}