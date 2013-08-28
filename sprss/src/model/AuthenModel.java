package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import object.User;

public class AuthenModel {
	
	public String getUser () {
		
		return "";
	}
	
	public boolean register(){
		return true;
	}
	
	/**
	 * ��Ǩ�ͺ��Ҫ��ͼ����������ʼ�ҹ����͡����Ҷ١��ͧ�������
	 * @param eid
	 * @param password
	 * @return ��Ң����� login �١��ͧ ���觤�� Object �����ż�����Ѻ �������١��ͧ���� null 
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static User checkAuthen( String eid , String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String npass = hashPassword( password ) ;
		System.out.println(npass);
		if( eid.equals("9999") && password.equals("1234") ){
			int id = 1;
			String firstname = "�Ѱ��" ;
			String lastname = "���ѡ�Ҿ����";
			String empID = "97912531";
			String email = "nattapon_wora@hotmail.com";
			String position = "admin";
			String plant = "0301";
			String storeroom = "S001";
			User uData = new User( id, firstname, lastname, empID, email, position, plant, storeroom );
			return uData;
		}
		else{
			return null;
		}
	}
	
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
