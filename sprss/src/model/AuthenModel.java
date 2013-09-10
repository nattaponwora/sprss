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
	
	public boolean register(){
		return true;
	}
	
	/**
	 * ตรวจสอบว่าชื่อผู้ใช้และรหัสผ่านที่กรอกเข้ามาถูกต้องหรือไม่
	 * @param eid
	 * @param password
	 * @return ถ้าข้อมูล login ถูกต้อง จะส่งค่า Object ข้อมูลผู้ใช้กลับ แต่ถ้าไม่ถูกต้องจะเป็น null 
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
		return null;
	}
	
	/**เข้ารหัส password ด้วย SHA1
	 * 
	 * @param String ของรหัสผ่านที่ต้องการ
	 * @return String ของ password ที่ทำการเข้ารหัสแล้ว
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
