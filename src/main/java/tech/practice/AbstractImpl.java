package tech.practice;



public abstract class AbstractImpl {
	protected String model;
	protected int year;
	public AbstractImpl(String model, int year) {
		this.model = model;
		this.year = year;
	}
	//Abstract method
	public abstract void start();
	public String getModel() {
		return model;
	}
	
	//Getters and Setters
	public int getYear() {
		return year;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
