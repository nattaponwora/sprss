package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import object.Item;
import object.PickedRequisition;
import object.PickingRequisition;
import object.Requisition;
import object.RequisitionList;

public class ShowPickModel {
	public static PickedRequisition getPicking( String plant , String storeroom  ) throws SQLException{
		Statement stm = StatementManager.getSQLStatement();
		String query = 	  "SELECT req_id ,resv_eid, resv_name, resv_team, enterdate, status, type "
						+ "FROM requisition "
						+ "WHERE status = 'entered' AND plant = '"+ plant +"' AND storeroom = '" + storeroom + "' "
						+ "AND status = 'pick' "
						+ "ORDER BY req_id asc";
		ResultSet rs = stm.executeQuery( query );
		rs.last(); 
		int total = rs.getRow();
		rs.beforeFirst();
		int reqNumList[] = new int[ total ];
		
		PickingRequisition reqList = new PickingRequisition();
		
		int i=0;
		while ( rs.next() ){
			reqList.add( new Requisition( rs.getInt("req_id"), rs.getInt("resv_eid") ,  rs.getString("resv_name"), rs.getString("resv_team") , rs.getDate("enterdate") , plant , storeroom ,rs.getString("status") , rs.getString("type")) );
			reqNumList[i] = rs.getInt("req_id");
			i++;
		}
		
		query =   "SELECT itemusage_id , itemnum, description, binnum, amount, requisition.req_id "
				+ "FROM itemusage join requisition on itemusage.req_id = requisition.req_id "
				+ "WHERE requisition.status = 'pick' AND requisition.plant = '"+ plant +"' AND requisition.storeroom = '" + storeroom + "'  "
				+ "ORDER BY req_id asc";
		
		rs = stm.executeQuery( query );
		while( rs.next() ){
			int req = rs.getInt("req_id");
			Requisition r =  reqList.getByID( req );
			r.addItem( new Item( req, rs.getInt("itemnum"), rs.getString("description") , rs.getString("binnum"), rs.getInt("amount"), r.getAuthorID() ) );
		}
		
		stm.close();
		return null;
	}
}
