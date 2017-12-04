package com.cheng.domain;

import org.springframework.stereotype.Component;

@Component("message")
public class Message {
	private int id;
	private String date; 
	public double high;
	public double weight;
	private double bmi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", date=" + date + ", high=" + high + ", weight=" + weight + ", bmi=" + bmi + "]";
	}

	
	
	
}
