package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import object.User;

public class AuthenModel {
	
	public String getUser () {
		
		return "";
	}
	
	public static boolean register( String fname, String lname, int eid, String tel, String email, int usergroup, String plant, String storeroom ,String hpass) throws SQLException{
		Statement stm =  StatementManager.getSQLStatement();
		if( checkUser( eid ) == false  ){
			return false;
		}
		String query = "INSERT INTO user (password, firstname, lastname, eid , email, tel, usergroup";
		if( usergroup != 1 ){
			query += ", plant, storeroom";
		}
		query += ") VALUE ('"+ hpass +"' ,'"+ fname +"' , '"+ lname +"' ,'"+ eid +"' ,'"+ email +"' ,'"+ tel +"' , '"+ usergroup +"'";
		if( usergroup != 1 ){
			query += " ,'"+ plant +"' ,'"+ storeroom +"'";
		}
		query += ")";
		int r = stm.executeUpdate( query);
		stm.close();
		if ( r>0 ){
			return true;
		}else{
			return false;
			
		}
	}
	
	private static boolean checkUser(int eid) throws SQLException{
		Statement stm =  StatementManager.getSQLStatement();
		String query = "SELECT * FROM user WHERE eid=" + eid;
		ResultSet rs = stm.executeQuery(query);
		if( rs.next() ){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * ��Ǩ�ͺ��Ҫ��ͼ����������ʼ�ҹ����͡����Ҷ١��ͧ�������
	 * @param eid
	 * @param password
	 * @return ��Ң����� login �١��ͧ ���觤�� Object �����ż�����Ѻ �������١��ͧ���� null 
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException\
	 * @author Nattapon Worasakdapisan 
	 * @throws SQLException 
	 */
	public static User checkAuthen( String eid , String password) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException{
		String npass = hashPassword( password ) ;
		Statement stm = StatementManager.getSQLStatement();
		String sql = "SELECT * FROM user WHERE eid = '" + eid + "' ";
		ResultSet rs = stm.executeQuery(sql);
		
		while ( rs.next() ){
			if( npass.equals( rs.getString("password") ) ){
				int id = rs.getInt("uid");
				String firstname = rs.getString("firstname") ;
				String lastname = rs.getString("lastname") ;
				int empID = rs.getInt("eid") ;
				String email = rs.getString("email") ;
				String tel = rs.getString("tel") ;
				int usergroup = rs.getInt("usergroup") ;
				String plant = rs.getString("plant") ;
				String storeroom = rs.getString("storeroom") ;
				User uData = new User( id, firstname, lastname, empID, email, tel, usergroup, plant, storeroom );
				return uData;
			}else{
				return null;
			}
		}
		stm.close();
		return null;
	}
	
	/**������� password ���� SHA1
	 * 
	 * @param String �ͧ���ʼ�ҹ����ͧ���
	 * @return String �ͧ password ���ӡ�������������
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @author Nattapon Worasakdapisan
	 */
	public static String hashPassword( String password ) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String nPassword = "";

		MessageDigest md = MessageDigest.getInstance("SHA");
		byte[] hash = md.digest(password.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder(2*hash.length);
		for(byte b : hash)
		{ 
			sb.append(String.format("%02x", b&0xff)); 
		} 
		nPassword = sb.toString();
		return nPassword;
	}
	
}
