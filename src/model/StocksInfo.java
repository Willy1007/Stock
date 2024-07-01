package model;

import java.io.Serializable;

public class StocksInfo implements Serializable{
	private String username;
	private int stock1;
	private int stock2;
	private int stock3;
	private double stock1_price;
	private double stock2_price;
	private double stock3_price;
	private int total;
	private String date;
	
	public StocksInfo() {
		super();
	}

	public StocksInfo(String username, int stock1, int stock2, int stock3, double stock1_price, double stock2_price,
			double stock3_price, int total, String date) {
		super();
		this.username = username;
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
		this.stock1_price = stock1_price;
		this.stock2_price = stock2_price;
		this.stock3_price = stock3_price;
		this.total = total;
		this.date = date;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStock1() {
		return stock1;
	}

	public void setStock1(int stock1) {
		this.stock1 = stock1;
	}

	public int getStock2() {
		return stock2;
	}

	public void setStock2(int stock2) {
		this.stock2 = stock2;
	}

	public int getStock3() {
		return stock3;
	}

	public void setStock3(int stock3) {
		this.stock3 = stock3;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getStock1_price() {
		return stock1_price;
	}

	public void setStock1_price(double stock1_price) {
		this.stock1_price = stock1_price;
	}

	public double getStock2_price() {
		return stock2_price;
	}

	public void setStock2_price(double stock2_price) {
		this.stock2_price = stock2_price;
	}

	public double getStock3_price() {
		return stock3_price;
	}

	public void setStock3_price(double stock3_price) {
		this.stock3_price = stock3_price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
