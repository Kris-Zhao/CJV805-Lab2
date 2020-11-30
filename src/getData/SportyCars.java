package getData;

import java.io.Serializable;
/**
 * @author Yuhang Zhao, student#=150467199
 *
 */
public class SportyCars implements Serializable {
	private int year;
	private String make;
	private String model;
	private double price;
	
	public SportyCars() {
		
	}
	public SportyCars(int year, String make, String model, double price) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.price = price;
	}
	
	//getter methods
	public int getYear() {
		return this.year;
	}
	public String getMake() {
		return this.make;
	}
	public String getModel() {
		return this.model;
	}
	public double getPrice() {
		return this.price;
	}
	
	//setter methods
	public void setYear(int year) {
		this.year = year;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	/*
	 * Displays all the Information of an Student
	 */
	public void display() {
		System.out.println("YEAR: " + this.year + ", Make: " + this.make + ", Model: " + this.model
				+ ", Price: " + this.price);
	}
	
}
