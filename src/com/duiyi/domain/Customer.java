package com.duiyi.domain;

import java.io.Serializable;
import java.util.Map;

public class Customer implements Serializable {
	private int id;
	
	private String name;
	
	private String gender;
	
	private String birthday;
	
	private String cellphone;
	
	private String email;
	
	private String preference;
	
	private String type;
	
	private String description;
	
	public Customer() {
	}
	
	public Customer(Map<String, String[]> map) {
		this.name = map.get("name")[0];
		this.gender = map.get("gender")[0];
		this.birthday = map.get("birthday")[0];
		this.cellphone = map.get("cellphone")[0];
		this.email = map.get("email")[0];
		this.preference = map.get("preference")[0];
		this.type = map.get("type")[0];
		this.description = map.get("description")[0];
	}

	@Override
	public String toString() {
		return "\'id\':\'" + id
				+ "\',\'name\':\'" + name
				+ "\',\'gender\':\'" + gender
				+ "\',\'birthday\':\'" + birthday
				+ "\',\'cellphone\':\'" + cellphone
				+ "\',\'email\':\'" + email
				+ "\',\'preference\':\'" + preference
				+ "\',\'type\':\'" + type
				+ "\',\'description\':\'" + description + "\'";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
