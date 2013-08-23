package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthenModel {
	
	public String getUser () {
		
		return "";
	}
	
	public boolean register(){
		return true;
	}
	
	public String hashPassword( String password ) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA");
		String nPassword = "";
		return nPassword;
	}
	
}
