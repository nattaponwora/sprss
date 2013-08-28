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
	
	

}
