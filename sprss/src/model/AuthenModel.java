package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthenModel {
	
	public String checkUser () {
		
		return "";
	}
	
	public String hashPassword( String password ) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA");
		String nPassword = "";
		return nPassword;
	}
	
}
