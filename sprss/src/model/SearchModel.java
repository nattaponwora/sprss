package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import object.Item;
import object.PickingRequisition;
import object.Requisition;
import object.RequisitionList;

public class SearchModel {
	public static Requisition searchReq(String req, String plant, String storeroom ) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = 
				  "SELECT r.req_id, resv_eid, resv_name, resv_team , enterdate , plant , storeroom, r.status, r.type  "
				+ "FROM selreq s "
				+ "JOIN requisition r ON s.selreq_id = r.selreq_id "
				+ "WHERE r.req_id = "+ req +" and plant = '"+plant+"' and storeroom = '"+ storeroom +"' ";
		ResultSet rs = stm .executeQuery(query);
				
		RequisitionList selreq = new RequisitionList();
		if ( rs.next() ){
			Requisition r = new Requisition(rs.getInt("req_id"), rs.getInt("resv_eid"), rs.getString("resv_name"), rs.getString("resv_team"), rs.getTimestamp("enterdate"), rs.getString("plant"), rs.getString("storeroom"), rs.getString("status"), rs.getString("type"));
			query =   "SELECT itemusage_id , itemnum, description, binnum, amount, unit, req_id "
					+ "FROM itemusage "
					+ "WHERE req_id="+ rs.getInt("req_id") +" ";
			
			rs = stm.executeQuery( query );
			while( rs.next() ){
				r.addItem( new Item( rs.getInt("req_id"), rs.getInt("itemnum"), rs.getString("description") , rs.getString("binnum"), rs.getInt("amount"), rs.getString("unit"), r.getAuthorID() ) );
			}
			stm.close();
			return r;
		}else{
			System.out.println("not");
			stm.close();
			return null;
		}
		
	}
	
	public static PickingRequisition getSelReq(String req, String plant, String storeroom ) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = 	  
				"SELECT selreq.selreq_id, selreq.begin_time, selreq.finish_time ,user.eid, user.firstname, user.lastname "
				+ "FROM selreq "
				+ "join user on user.uid = selreq.uid "
				+ "join requisition on selreq.selreq_id = requisition.selreq_id "
				+ "WHERE req_id = " + req + " and requisition.plant = '"+ plant +"' and requisition.storeroom = '" + storeroom + "' "
				+ "group by selreq.selreq_id, selreq.begin_time, user.uid, user.firstname, user.lastname";
		ResultSet rs = stm.executeQuery( query );

		if ( rs.next() ){
			PickingRequisition selList = new PickingRequisition( rs.getInt("selreq_id"), rs.getInt("eid") , rs.getString("firstname"), rs.getString("lastname"), rs.getTimestamp("begin_time") , rs.getTimestamp("finish_time")  );
			stm.close();
			return selList;
		}else{
			stm.close();
			return null;
		}
		
	}
}
