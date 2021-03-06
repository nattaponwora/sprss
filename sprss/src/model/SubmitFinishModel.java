package model;

import java.sql.SQLException;
import java.sql.Statement;

public class SubmitFinishModel {
	
	public static void updateStatus( int id ) throws SQLException{
		
		Statement stm = StatementManager.getSQLStatement();
		
		String query_selreq = 
				"UPDATE selreq "
				+ "SET status = 'finished' , finish_time = CURRENT_TIMESTAMP "
				+ "WHERE selreq_id = " + id;
		stm.executeUpdate(query_selreq);
		
		String query_req = 
				"UPDATE requisition "
				+ "SET status = 'finished' "
				+ "WHERE selreq_id = " + id;
		stm.executeUpdate(query_req);
		stm.close();
		//System.out.println("finish_update");
	}

}
