package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exception.DuplicateDataException;
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
	
	public static ArrayList<Warehouse> getWarehouse(String plant, String storeroom) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = "SELECT * FROM warehouse WHERE plant='" + plant + "' AND storeroom ='" + storeroom + "' ";
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
		String result = rs.getString("des");
		rs.close();
		return result;
	}
	
	public static void insertWarehouse( String plant , String storeroom ) throws SQLException, DuplicateDataException{
		Statement mxmStm = StatementManager.getDB2Statement();
		String query = "SELECT DESCRIPTION des FROM LOCATIONS WHERE SITEID = '"+ plant +"' AND LOCATION = '"+ storeroom +"'";
		ResultSet rs = mxmStm.executeQuery(query);
		rs.next();
		String des = rs.getString("des");
		mxmStm.close();
		
		
		Statement sqlStm = StatementManager.getSQLStatement();
		query = "SELECT * FROM warehouse WHERE plant = '"+ plant +"' AND storeroom = '"+ storeroom +"'";
		ResultSet checkWare = sqlStm.executeQuery(query);
		if( checkWare.next() ){
			throw new DuplicateDataException();
		}
		
		query = "INSERT INTO warehouse ( ware_des, plant, storeroom  ) VALUE ( '" + des+ "' , '"+plant+"' , '"+storeroom+"')";
		sqlStm.executeUpdate(query);
		sqlStm.close();
	}
	public static Warehouse getWarehouseByID( int wid ) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = "SELECT * FROM warehouse WHERE ware_id=" + wid;
		ResultSet rs = stm.executeQuery(query);
		Warehouse wh = null;
		while ( rs.next() ){
			wh = new Warehouse( rs.getInt("ware_id") , rs.getString("ware_des"), rs.getString("plant"), rs.getString("storeroom"));
		}
		
		stm.close();
		return wh;
	}
}
