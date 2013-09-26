/**
 * The class that create item
 * @author POM
 */

package object;

/**
 * Constroctor
 * @param reqID
 * @param code
 * @param description
 * @param assetNO
 * @param amount
 * @author nattaponwor
 *
 */
public class Item {
	
	private int reqID;
	private int itemnum;
	private String description;
	private String assetNO; 
	private int amount;
	private String unit;
	private int autID;
	
	/**
	 * 
	 * Constructor for Item class
	 * @param reqID
	 * @param code
	 * @param description
	 * @param assetNO
	 * @param amount
	 */
	public Item( int reqID , int itemnum , String description , String assetNO , int amount , String unit, int autID){
		this.reqID = reqID;
		this.itemnum = itemnum;
		this.description = description;
		this.assetNO = assetNO;
		this.amount = amount;
		this.unit = unit;
		this.autID = autID;
	}
	
	public int getReqID(){
		return reqID;
	}
	
	public int getItemnum(){
		return itemnum;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getAssetNO(){
		return assetNO;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public String getUnit(){
		return unit;
	}
	
	public int getAutID(){
		return autID;
	}
	
	public String getStoreType(){
		return getAssetNO().substring(0, 1);
	}
	
	public int getLog(){
		String str = getAssetNO().substring(1);
		String[] temp = str.split("-");
		return Integer.valueOf(temp[0]);
	}
	
	public int getShelf(){
		String str = getAssetNO().substring(1);
		String[] temp = str.split("-");
		if( temp.length == 1 ){
			return 0;
		}
		return Integer.valueOf(temp[1]);
	}
	
	public int getBasket(){
		String str = getAssetNO().substring(1);
		String[] temp = str.split("-");
		if( temp.length == 2 ){
			return 0;
		}
		return Integer.valueOf(temp[2]);
	}
	
	public int getBag(){
		String str = getAssetNO().substring(1);
		String[] temp = str.split("-");
		if( temp.length == 3 ){
			return 0;
		}
		return Integer.valueOf(temp[3]);
	}
	
	public int compareToStoreType(Item other) {
		if ( other == null ) return -1;
        return this.getStoreType().compareTo(other.getStoreType());
    }
	
	public int compareToLog(Item other) {
        if ( other == null ) return -1;
        if ( this.getLog() < other.getLog() ) return -1;
        if ( this.getLog() > other.getLog() ) return +1;
        return 0;
    }
	
	public int compareToShelf(Item other) {
        if ( other == null ) return -1;
        if ( this.getShelf() < other.getShelf() ) return -1;
        if ( this.getShelf() > other.getShelf() ) return +1;
        return 0;
    }
	
	public int compareToBasket(Item other) {
        if ( other == null ) return -1;
        if ( this.getBasket() < other.getBasket() ) return -1;
        if ( this.getBasket() > other.getBasket() ) return +1;
        return 0;
    }
	
	public int compareToBag(Item other) {
        if ( other == null ) return -1;
        if ( this.getBag() < other.getBag() ) return -1;
        if ( this.getBag() > other.getBag() ) return +1;
        return 0;
    }
	
	

}
