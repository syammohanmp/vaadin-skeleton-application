package com.example.yaa.data;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName = "";
	private String lastName = "";
 
	private String email = "";
 
	private String phoneNumber = "";
 
	private String streetAddress = "";
 
	private Integer postalCode = null;
	 
	private String city = "";
	
	// + setters and getters for all fields

	public void setFirstName(String string) {
		// TODO Auto-generated method stub
		firstName = string;
		
	}
	
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	

	public void setLastName(String string) {
		// TODO Auto-generated method stub
		 lastName = string;
		
	}
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}
	public void setEmail(String string) {
		// TODO Auto-generated method stub
		email = string;
		
	}
	public String  getEmail(){
		return email;
	}
	public void setPhoneNumber(String string) {
		// TODO Auto-generated method stub
		phoneNumber = string;
	}
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return phoneNumber ;
	}
	public void setPostalCode(int n) {
		// TODO Auto-generated method stub
		postalCode = n;
		
	}
	public int getPostalCode() {
		// TODO Auto-generated method stub
		return postalCode  ;
		
	}
	public void setStreetAddress(String string) {
		// TODO Auto-generated method stub
		streetAddress = string;
		
	}
	public String getStreetAddress() {
		// TODO Auto-generated method stub
		return streetAddress ;
		
	}
	public void setCity(String string) {
		// TODO Auto-generated method stub
		city = string;
		
	}
	public String getCity() {
		// TODO Auto-generated method stub
		return city ;
		
	}
}
