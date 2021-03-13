package net.classes;

import java.io.Serializable;

public class PlanBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private int plan;
	private String sms;
	private String data;
	private String price;
	private String airTime;
			

	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getAirTime() {
		return airTime;
	}
	public void setAirTime(String AirTime) {
		this.airTime = AirTime;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	
}
