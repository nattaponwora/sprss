package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import object.Item;
import object.ItemList;
import object.Requisition;
import object.RequisitionList;

public class MXMSyncModel {
	public static void getDataFromMXM() throws SQLException{
		Statement db2Stm = StatementManager.getDB2Statement();
		Statement sqlStm = StatementManager.getSQLStatement();
		String siteQuery = "SELECT plant, storeroom FROM warehouse";
		ResultSet storeRS = sqlStm.executeQuery(siteQuery);
		String sql =  "SELECT iu.INVUSENUM req_id,il.ITEMNUM, il.DESCRIPTION des, inv.GP_BINNUM bin, il.QUANTITY amount, inv.ISSUEUNIT unit, iu.GP_PDA_USERID resv_id, p.DISPLAYNAME resv_name, iu.GP_PDA_TEAM resv_team, iu.SITEID plant ,iu.FROMSTORELOC storeroom, iu.GP_PDA_UPDATEDDATE enterdate, iu.USETYPE type "
					+ "FROM invuse iu "
					+ "join INVUSELINE il on iu.INVUSENUM = il.INVUSENUM "
					+ "join INVENTORY inv on inv.ITEMNUM = il.ITEMNUM AND inv.SITEID = iu.SITEID AND inv.LOCATION = iu.FROMSTORELOC "
					+ "join PERSON p ON iu.GP_PDA_USERID = p.PERSONID "
					+ "WHERE iu.GP_PDA_USERID is not null AND iu.status = 'ENTERED' AND iu.GP_PDA_UPDATEDDATE > date('2013-09-01')  AND "
					+ "( ";
		boolean first = true;
		while( storeRS.next() ){
			if( ! first ){
				sql += "OR";
			}else{
				first = false;
			}
   			sql += " ( iu.SITEID = '"+ storeRS.getString("plant")  +"' and iu.FROMSTORELOC = '"+ storeRS.getString("storeroom") +"' ) ";
		}
		sql +=  ") "
				+ "ORDER BY iu.INVUSENUM";
		
		ResultSet rs = db2Stm.executeQuery(sql);
		RequisitionList rl = new RequisitionList();

		while( rs.next() ){
			int req_id = rs.getInt("req_id");
			Requisition r;
			if( rl.getByID(req_id) == null ){
				int resv_id = rs.getInt("resv_id");
				String resv_name = rs.getString("resv_name");
				String resv_team = rs.getString("resv_team");
				String plant = rs.getString("plant");
				String storeroom = rs.getString("storeroom");
				Date enterdate = rs.getTimestamp("enterdate");
				String type = rs.getString("type");
				r = new Requisition(req_id, resv_id, resv_name, resv_team, enterdate, plant,storeroom , "entered", type);
				rl.add(r);
			}else{
				r = rl.getByID(req_id);
			}
			int itemnum = rs.getInt("itemnum");
			String description = rs.getString("des");
			String assetNO = rs.getString("bin");
			int amount = rs.getInt("amount");
			String unit = rs.getString("unit");
			int autID = rs.getInt("resv_id");
			Item item = new Item(req_id, itemnum, description, assetNO, amount, unit, autID);
			r.addItem(item);
		}
		
		
		for ( int i=0 ; i<rl.size() ; i++ ){
			Requisition r = rl.get(i);
			String query = "INSERT ignore INTO requisition (req_id, resv_eid, resv_name, resv_team, plant, storeroom, enterdate, itemamount,status,  type) "
					+ "VALUE ( '" + r.getReqID() + "' , '" + r.getAuthorID() + "' , '" + r.getAuthorName() + "' ,  '" + r.getAuthorTeam() + "' ,  '" + r.getPlant() + "' ,  '" + r.getStoreroom() + "' ,  '" + r.getEnteredDate() + "' ,  '" + r.getTotalItem() + "' ,  '"+ r.getStatus() +"'   ,  '" + r.getType() + "' )";
			int num_ins = sqlStm.executeUpdate(query);
			ItemList il = r.getItemList();
			if(num_ins != 0){
				for( int j=0; j<il.size() ; j++  ){
					Item item = il.get(j);
					query = "INSERT INTO itemusage (itemnum, description, binnum, amount, unit, req_id) VALUE ( '"+item.getItemnum()+"' , '"+ item.getDescription() +"' , '" + item.getAssetNO() +"' , '"+item.getAmount()+"' , '"+ item.getUnit() +"' , '"+item.getReqID()+"' ) ";
					sqlStm.executeUpdate(query);
				}
			}
		}
		
		//String s = rs.getString("DISPLAYNAME");
		//stm.close();
		db2Stm.close();
		sqlStm.close();
		//stm = StatementManager.getSQLStatement();
	}
	
	
}
