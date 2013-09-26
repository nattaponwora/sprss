package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import object.Requisition;
import object.RequisitionList;

public class MXMSyncModel {
	public static String getDataFromMXM() throws SQLException{
		Statement db2Stm = StatementManager.getDB2Statement();
		Statement sqlStm = StatementManager.getSQLStatement();
		String siteQuery = "SELECT plant, storeroom FROM warehouse";
		ResultSet storeRS = sqlStm.executeQuery(siteQuery);
		String sql =  "SELECT iu.INVUSENUM req_id,il.ITEMNUM, il.DESCRIPTION des, inv.GP_BINNUM, il.QUANTITY amount, iu.GP_PDA_USERID resv_id, p.DISPLAYNAME resv_name, iu.GP_PDA_TEAM resv_team, iu.SITEID plant ,iu.FROMSTORELOC storeroom, iu.GP_PDA_UPDATEDDATE enterdate, iu.USETYPE type "
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
			int req_id = rs.getInt("resv_id");
			Requisition r;
			if( rl.getByID(req_id) == null ){
				int resv_id = rs.getInt("resv_id");
				String resv_name = rs.getString("resv_name");
				String resv_team = rs.getString("resv_team");
				String plant = rs.getString("plant");
				String storeroom = rs.getString("storeroom");
				Date enterdate = rs.getDate("enterdate");
				String type = rs.getString("type");
				r = new Requisition(req_id, resv_id, resv_name, resv_team, enterdate, plant,storeroom , "entered", type);
				rl.add(r);
			}else{
				r = rl.getByID(req_id);
			}
			
		}
		
		sql =     "SELECT "
				+ "FROM  ";
		for ( int i=0 ; i<rl.size() ; i++ ){
			
		}
		
		
		String s = rs.getString("DISPLAYNAME");
		//stm.close();
		*/
		return sql;
		//stm = StatementManager.getSQLStatement();
	}
	
	
}
