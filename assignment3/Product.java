package assignment3;

import java.util.ArrayList;

public class Product {
	private String name;
	private int price;
	private int quantity;
	private ArrayList<Customer> waitList = new ArrayList<Customer>();
	
	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	
	public int getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void wait(Customer customer) {
		waitList.add(customer);
	}
	
	public ArrayList<Customer> getWaitList(){
		return waitList;
	}
}
