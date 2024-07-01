package model;

public class NumberRandom {
	private double stock1;
	private double stock2;
	private double stock3;
	
	public NumberRandom(double stock1, double stock2, double stock3) {
		super();
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
	}

	public double getStock1() {
		return stock1;
	}

	public void setStock1(double stock1) {
		this.stock1 = stock1;
	}

	public double getStock2() {
		return stock2;
	}

	public void setStock2(double stock2) {
		this.stock2 = stock2;
	}

	public double getStock3() {
		return stock3;
	}

	public void setStock3(double stock3) {
		this.stock3 = stock3;
	}
	
	public boolean RandomTF() {
		boolean result = true;
		int num = (int)(Math.random() * 2) + 1;
		
		if(num == 2) {result = false;}
		return result;
	}
	
	public void RDNumber() {
		int stock1_int = (int)(Math.random() * 4) + 1;
		int stock2_int = (int)(Math.random() * 4) + 1;
		int stock3_int = (int)(Math.random() * 4) + 1;
		
		if(RandomTF() == true) {
			this.stock1 += stock1_int;
			if(RandomTF() == true) {this.stock1 += 0.5;}
		}else {
			this.stock1 -= stock1_int;
			if(RandomTF() == true) {this.stock1 -= 0.5;}
		}
		
		if(RandomTF() == true) {
			this.stock2 += stock2_int;
			if(RandomTF() == true) {this.stock2 += 0.5;}
		}else {
			this.stock2 -= stock2_int;
			if(RandomTF() == true) {this.stock2 -= 0.5;}
		}
		
		if(RandomTF() == true) {
			this.stock3 += stock3_int;
			if(RandomTF() == true) {this.stock3 += 0.5;}
		}else {
			this.stock3 -= stock3_int;
			if(RandomTF() == true) {this.stock3 -= 0.5;}
		}
		
		if(getStock1() < 0) {setStock1(0.0);}
		if(getStock2() < 0) {setStock2(0.0);}
		if(getStock3() < 0) {setStock3(0.0);}
	}
}
