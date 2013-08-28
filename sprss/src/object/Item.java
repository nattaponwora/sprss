package object;

public class Item {
	
	private int code;
	private String description;
	private String assetNO; 
	private int amount;
	
	/**
	 * 
	 * Constructor for Item class
	 * @param code
	 * @param description
	 * @param assetNO
	 * @param amount
	 */
	public Item( int code , String description , String assetNO , int amount){
		this.code = code;
		this.description = description;
		this.assetNO = assetNO;
		this.amount = amount;
	}
	
	public int getCode(){
		return code;
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
		return Integer.valueOf(temp[1]);
	}
	
	public int getBasket(){
		String str = getAssetNO().substring(1);
		String[] temp = str.split("-");
		return Integer.valueOf(temp[2]);
	}
	
	public int getBag(){
		String str = getAssetNO().substring(1);
		String[] temp = str.split("-");
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
