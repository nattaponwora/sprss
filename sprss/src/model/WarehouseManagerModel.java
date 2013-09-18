package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import object.Warehouse;

public class WarehouseManagerModel {
	public static ArrayList<Warehouse> getWarehouse() throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = "SELECT * FROM warehouse";
		ResultSet rs = stm.executeQuery(query);
		ArrayList<Warehouse> wh = new ArrayList<Warehouse>();
		while ( rs.next() ){
			wh.add( new Warehouse( rs.getInt( "ware_id" ) , rs.getString("ware_des"),  rs.getString("plant"), rs.getString("storeroom") ) );
		}
		
		stm.close();
		return wh;
	}
	
	public static String getWarehouseDescription(String plant, String storeroom) throws SQLException{
		Statement stm = StatementManager.getDB2Statement();
		String query = "SELECT DESCRIPTION des FROM LOCATIONS WHERE SITEID = '" + plant + "' AND LOCATION = '"+ storeroom +"'";
		ResultSet rs = stm.executeQuery(query);
		rs.next();
		return rs.getString("des");
	}
	
	public static void insertWarehouse( Warehouse wh ){
		
	}
}
