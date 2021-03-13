package net.classes;

import java.io.Serializable;

public class ClientBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private String username;
	private String password;
	private String name;
	private String surname;
	private float afm;
	private int plan;
	private String phoneNumber;
	private String area;
	private String property;
	private int monthBill;
	private String status;
	private int call_id;
	private int call_duration;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}		
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public float getAfm() {
		return afm;
	}
	public void setAfm(float afm) {
		this.afm = afm;
	}
	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public int getMonthBill() {
		return monthBill;
	}
	public void setMonthBill(int monthBill) {
		this.monthBill = monthBill;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public int getCall_id() {
		return call_id;
	}
	public void setCall_id(int call_id) {
		this.call_id = call_id;
	}
	public int getCall_duration() {
		return call_duration;
	}
	public void setCall_duration(int call_duration) {
		this.call_duration = call_duration;
	}
}
