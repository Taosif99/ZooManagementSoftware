package com.progex.zoomanagementsoftware.datatypes;
import java.sql.Date;

/**
 * @(#) User.java
 */

public abstract class User
{
	private String username;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String phoneNumber;
	
	private int id;
	
	private Salutation salutation;
	
	private date birthday;
	
	private String hashedPassword;
	
	private Address address;
	
	private date lastLogDate;
	
	public User( int id, String username, String firstname, String lastname, String email, String phoneNumber, String salutation, date birthday, String hashedPassword, Address address )
	{
		
	}
	
	
}
