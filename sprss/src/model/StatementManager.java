package model;

import java.sql.*;

public class StatementManager {
	
	private static String status = "production";//test or production
	
	private static String sql_url = "jdbc:mysql://localhost:3306/sprss?&useUnicode=true&characterEncoding=UTF-8";
	private static String sql_user = "root";
	private static String sql_pass = "";
	
	private static String sql_test_url = "jdbc:mysql://localhost:3306/maximo?&useUnicode=true&characterEncoding=UTF-8";

	
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
            	if( status == "test" ){
            		Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = (Connection) DriverManager.getConnection( sql_test_url, sql_user, sql_pass);
            	}else{
            		Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
                    con = (Connection) DriverManager.getConnection( db2_url, db2_user, db2_pass);
            	}
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        return (Statement) con.createStatement();
    }

}