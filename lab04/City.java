package lab04;

import java.util.Random;

public class City {
	
	private String name;
	private int locationX;
	private int locationY;
	
	// Constructor
	public City(String name, int locationX, int locationY) {
		this.name = name;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	
	public City(String name) {
		this.name = name;
	
		Random rnd = new Random();
		this.locationX = rnd.nextInt(361);
		this.locationY = rnd.nextInt(361);
	}
	
	// Getter
	public String getName () {
		return this.name;
	}
	public int getLocationX() {
		return this.locationX;
	}
	public int getLocationY() {
		return this.locationY;
	}
	
	// public equals method
	public boolean equals (City anotherCity) {
		if (this.name == anotherCity.name 
				&& this.locationX == anotherCity.locationX
				&& this.locationY == anotherCity.locationY)
			return true;
		return false;
	}
	
	// public toString method
	public String toString () {
		return name + ", " + locationX + ", " + locationY;
	}
	
	// static method distance
	static double distance(City city1, City city2) {
		int distanceX = Math.abs(city1.getLocationX() - city2.getLocationX());
		int distanceY = Math.abs(city1.getLocationY() - city2.getLocationY());
		double distance = Math.sqrt(Math.pow(distanceX,2)+Math.pow(distanceY,2));
		return distance;
		
	}
	
}
