package object;

public class Warehouse {
	private int id;
	private String des;
	private String plant;
	private String storeroom;
	
	public Warehouse(int id, String des, String plant, String storeroom){
		this.id = id;
		this.des = des;
		this.plant = plant;
		this.storeroom = storeroom;
	}
	
	public int getID(){
		return id;
	}
	
	public String getDescription(){
		return des;
	}
	
	public String getPlant(){
		return plant;
	}
	
	public String getStoreroom(){
		return storeroom;
	}
}
