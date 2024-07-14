package tech.practice;

public enum Seasons {
	WINTER(5),
    SPRING(15),
    SUMMER(25),
    MONSOON(20);
	
	private int averageTemprature;

	Seasons(int averageTemprature){
		this.setAverageTemprature(averageTemprature);
	}

	public int getAverageTemprature() {
		return averageTemprature;
	}

	public void setAverageTemprature(int averageTemprature) {
		this.averageTemprature = averageTemprature;
	}
	
}
