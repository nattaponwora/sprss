package model;

import java.sql.*;

public class StatementManager {
	
	private static String sql_url = "jdbc:mysql://cpr-support02.rtl.cp.co.th:3306/sprss";
	private static String sql_user = "sprss_admin";
	private static String sql_pass = "sprss";
	
	private static String db2_url = "jdbc:db2://10.151.22.73:50005/maxdb";
	private static String db2_user = "maximo";
	private static String db2_pass = "maximo";
	
	public static Statement getSQLStatement() throws SQLException{
        Connection con=null;
        if(con==null)
        {
        	
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = (Connection) DriverManager.getConnection( sql_url, sql_user, sql_pass);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        return (Statement) con.createStatement();
    }
	
	public static Statement getDB2Statement() throws SQLException{
        Connection con=null;
        if(con==null)
        {
        	
            try {
                Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
                con = (Connection) DriverManager.getConnection( db2_url, db2_user, db2_pass);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        return (Statement) con.createStatement();
    }

}