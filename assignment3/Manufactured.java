package assignment3;

public class Manufactured extends Product {
	public String brand;
	
	public Manufactured(String name, int price, String brand, int quantity) {
		super(name, price, quantity);
		this.brand = brand;
	}
	
	public String getBrand() {
		return this.brand;
	}
}
