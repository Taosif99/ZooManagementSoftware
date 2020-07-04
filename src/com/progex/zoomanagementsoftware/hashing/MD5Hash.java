
package com.progex.zoomanagementsoftware.hashing;

import java.security.MessageDigest; //Imported for md5
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter; //We are also using the JAXB API


/**
 *This class provides simple functions to hash a String and to verify
 * the hash of a String using MD5 algorithm.
 * 
 */
public class MD5Hash {
    

	
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
			
			System.err.println("Exception in hashString()");
			System.out.println(e.getMessage());
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
	
}
