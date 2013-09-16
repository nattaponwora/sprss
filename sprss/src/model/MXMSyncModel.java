package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MXMSyncModel {
	public static String getDataFromMXM() throws SQLException{
		Statement stm = StatementManager.getDB2Statement();
		String sql = "SELECT DISPLAYNAME from PERSON where DISPLAYNAME like '%¹Ñ°¾Å%' ";
		ResultSet rs = stm.executeQuery(sql);
		rs.next();
		String s = rs.getString("DISPLAYNAME");
		return s;
		//stm = StatementManager.getSQLStatement();
	}
	
	
}
