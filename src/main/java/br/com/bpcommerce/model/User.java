package br.com.bpcommerce.model;

import javax.persistence.Entity;


public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String address_num;
	private String country;
	private String postalCode;
	private String city;
	private String bdayDate;
	private String creatDate;
	private String statusUser;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_num() {
		return address_num;
	}
	public void setAddress_num(String address_num) {
		this.address_num = address_num;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBdayDate() {
		return bdayDate;
	}
	public void setBdayDate(String bdayDate) {
		this.bdayDate = bdayDate;
	}
	public String getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	
	public String getStatusUser() {
		return statusUser;
	}
	public void setStatusUser(String statusUser) {
		this.statusUser = statusUser;
	}
		
	@Override
	  public String toString() {
	    return String.format(
	        "{id='%s', Nome='%s', lastName='%s',bdayDate='%s', email='%s', phone='%s',address='%s',address_num='%s',country='%s',postalCode='%s',city='%s',creatDate='%s',statusUser='%s'}",
	        id, firstName, lastName, bdayDate, email, phone, address, address_num, country, postalCode, city,creatDate, statusUser);
	  }

}
