package object;

public class Item {
	
	private int code;
	private String description;
	private String assetNO; 
	private int amount;
	
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

}
