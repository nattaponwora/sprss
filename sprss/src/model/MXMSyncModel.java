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
		String sql = "SELECT iu.INVUSENUM req_id, iu.GP_PDA_USERID resv_id, p.DISPLAYNAME resv_name, iu.GP_PDA_TEAM resv_team, iu.SITEID plant ,iu.FROMSTORELOC storeroom, iu.GP_PDA_UPDATEDDATE enterdate, iu.USETYPE type "
				+ "FROM invuse iu join PERSON p ON iu.GP_PDA_USERID = p.PERSONID "
				+ "WHERE iu.GP_PDA_USERID is not null AND iu.status = 'ENTERED' ";
		ResultSet rs = db2Stm.executeQuery(sql);
		RequisitionList rl = new RequisitionList();
		rs.last(); 
		int total = rs.getRow();
		rs.beforeFirst();
		//int reqIDList[] = new int[total];
		while( rs.next() ){
			int req_id = rs.getInt("req_ID");
			int resv_id = rs.getInt("resv_id");
			String resv_name = rs.getString("resv_name");
			String resv_team = rs.getString("resv_team");
			String plant = rs.getString("plant");
			String storeroom = rs.getString("storeroom");
			Date enterdate = rs.getDate("enterdate");
			String type = rs.getString("type");
			Requisition r = new Requisition(req_id, resv_id, resv_name, resv_team, enterdate, plant,storeroom , "entered", type);
			rl.add(r);
		}
		
		sql =     "SELECT "
				+ "FROM  ";
		for ( int i=0 ; i<rl.size() ; i++ ){
			
		}
		
		
		String s = rs.getString("DISPLAYNAME");
		stm.close();
		return s;
		//stm = StatementManager.getSQLStatement();
	}
	
	
}
