package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import object.Item;
import object.ItemList;
import object.PickingRequisition;
import object.Requisition;

public class ShowFinishModel {
	public static ArrayList<PickingRequisition> getFinish( String plant , String storeroom  ) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();

		String query_selreq = 	  
				"SELECT selreq.selreq_id, selreq.begin_time, selreq.finish_time , user.eid, user.firstname, user.lastname "
				+ "FROM selreq "
				+ "join user on user.uid = selreq.uid "
				+ "join requisition on selreq.selreq_id = requisition.selreq_id "
				+ "WHERE selreq.status = 'finished' and requisition.plant = '"+ plant +"' and requisition.storeroom = '" + storeroom + "' "
				+ "group by selreq.selreq_id, selreq.begin_time, user.uid, user.firstname, user.lastname";
		ResultSet selreq_rs = stm.executeQuery( query_selreq );
		//create selreq List
		ArrayList<PickingRequisition> selList = new ArrayList<PickingRequisition>();
		while ( selreq_rs.next() ){
			selList.add(new PickingRequisition( selreq_rs.getInt("selreq_id"), selreq_rs.getInt("eid") , selreq_rs.getString("firstname"), selreq_rs.getString("lastname"), selreq_rs.getTimestamp("begin_time"), selreq_rs.getTimestamp("finish_time")  ));
		}
		
		String query_item =   
				"SELECT itemusage_id , itemnum, description, binnum, amount, unit ,requisition.req_id, requisition.resv_eid "
				+ "FROM itemusage join requisition on itemusage.req_id = requisition.req_id "
				+ "WHERE requisition.status = 'finished' AND requisition.plant = '"+ plant +"' AND requisition.storeroom = '" + storeroom + "'  "
				+ "ORDER BY req_id asc";
		
		ResultSet item_rs = stm.executeQuery( query_item );
		Map< Integer , ItemList > itemList = new HashMap<Integer, ItemList>();
		while( item_rs.next() ){
			int req_id = item_rs.getInt("req_id");
			Item i = new Item( req_id, item_rs.getInt("itemnum"), item_rs.getString("description") , item_rs.getString("binnum"), item_rs.getInt("amount"),item_rs.getString("unit"), item_rs.getInt("resv_eid") );
			
			ItemList il;
			if( ! itemList.containsKey(req_id) ){
				il = new ItemList();
				itemList.put(req_id, il);
			}else{
				il = itemList.get(req_id);
			}
			il.add(i);
		}
		
		// add Requisition to selreq
		String query_req = 	  "SELECT req_id ,resv_eid, resv_name, resv_team, enterdate, status, type, selreq_id "
				+ "FROM requisition "
				+ "WHERE status = 'finished' AND plant = '"+ plant +"' AND storeroom = '" + storeroom + "' "
				+ "ORDER BY req_id asc";
		ResultSet req_rs = stm.executeQuery( query_req );
		while ( req_rs.next() ){
			for( int i = 0 ; i< selList.size() ; i++ ){
				PickingRequisition p = selList.get(i);
				int selID = req_rs.getInt("selreq_id");
				if(  selID == p.getID() ){
					Requisition r = new Requisition( req_rs.getInt("req_id"), req_rs.getInt("resv_eid") ,  req_rs.getString("resv_name"), req_rs.getString("resv_team") , req_rs.getDate("enterdate") , plant , storeroom ,req_rs.getString("status") , req_rs.getString("type"));
					ItemList il = itemList.get( req_rs.getInt("req_id") );
					for ( int j = 0 ; j < il.size() ; j++ ){
						r.addItem(il.getItem(j));
					}				
					p.add( r );
					break;
				}
			}
		}
		stm.close();
		return selList;
	}
}
