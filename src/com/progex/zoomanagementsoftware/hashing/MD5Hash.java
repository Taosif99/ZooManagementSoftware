
package com.progex.zoomanagementsoftware.hashing;

import java.security.MessageDigest; //Imported for md5
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter; //We are also using the JAXB API


/**
 *This class provides simple functions to hash a String and to verify
 * the hash of a String using MD5
 * 
 */
public class MD5Hash {
    
    
    /**
	 * Main class for testing purposes
	 * @param args
	 */
	public static void main(String[] args) {
	
	    MD5Hash myHasher = new MD5Hash();
	    //Hashing a password list..., here you can add values
	    String[] passwordList = {"gdrz567","123","0000","progEX"};
	    String[] hashes = myHasher.hashPasswords(passwordList);
	    
	    //Printing all passwords, hashed passwords and check
	    for (int i = 0; i < passwordList.length;i++) { 	
	    	boolean check =  myHasher.checkHash(hashes[i],passwordList[i]);
	    	System.out.println("Password: " + passwordList[i] + " Hash: " + hashes[i] + " Check: " + check);
	    	
	    }
	    
	}
	
	/**
	 * Method which is used to hash a String
	 * @param password
	 * @return The hashed String if successful, else null
	 */
	public String hashString(String password) {
		
		MessageDigest md;
		try {
		md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
                byte[] digest = md.digest();
                String hashedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();
                return hashedPassword;
	    
		} catch (NoSuchAlgorithmException e) {
			
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;	
		}
	}
	
	/**
	 * Method which is used to verify that a password belongs to
	 * a given md5 hash String representation
	 * @param hash
	 * @param password
	 * @return true if given hash belongs to password, false if not
	 */
	public boolean checkHash(String hash, String password) {
		
		String hashPassword = this.hashString(password);
		return hashPassword.equals(hash);
	}
	
	/**
	 * Method which is used to hash a given list passwords
	 * @param passwords
	 * @return the hashed passwords
	 */
	public String[] hashPasswords(String[] passwords) {
		
		String hashes[] = new String[passwords.length];
		for(int i = 0; i < passwords.length; i++) {	
			hashes[i] = this.hashString(passwords[i]);
		}
		return hashes;
	}
}
