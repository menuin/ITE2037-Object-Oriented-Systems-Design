package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Mart extends InventoryManager {
	private ArrayList<Product> salesList;
	public static int transactionNum = 1000;
	
	private static Mart uniqueInstance;
	private Mart() {};
	public synchronized static Mart getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Mart();
		return uniqueInstance;
	}
	
	public ArrayList<Product> getSalesList(){
		return salesList;
	}
	public void setSalesList(int numOfProducts) {
		this.salesList = new ArrayList<Product>(numOfProducts);
	}
	
	public void printSalesList() {
		for (int i=0;i<this.salesList.size();i++) {
			Product product = this.salesList.get(i);
			if (product instanceof Food) {
				Food food = (Food)product;
				System.out.println(i+1 + ". (Quantity: " + food.getQuantity() + ") " + food.getName() +", " +
						food.getPrice() + " won, Best before: " + food.getExpirationDateTime());
			}
			else {  // product instanceof Manufactured
				Manufactured manufactured = (Manufactured)product;
				System.out.println(i+1 + ". (Quantity: " + manufactured.getQuantity() + ") " + manufactured.getName() +", " 
						+ manufactured.getPrice() +" won, Brand : " + manufactured.getBrand());
			}
		}
	}
	
	public void addInventory(int product, int quantity) {
		if (this.salesList.get(product-1).getQuantity() == 0) {
			this.salesList.get(product-1).addQuantity(quantity);
			notifyObservers();
		}
		else {
			this.salesList.get(product-1).addQuantity(quantity);
		}
	}
	
	public void printExpired() {
		LocalDateTime currentTime = LocalDateTime.of(2021,5,27,15,0);
		for (int i=0;i<salesList.size();i++) {
			if (salesList.get(i) instanceof Food) {
				Food food = (Food)salesList.get(i);

				if (food.isExpired(currentTime)) {
					System.out.println(i+1 + ". (Quantity: " + food.getQuantity() + ") " + food.getName() +", " +
							food.getPrice() + " won, Best before: " + food.getExpirationDateTime());
				}
			}
		}
	}
	
	public void updateExpired(int daysToAdd) {
		LocalDateTime currentTime = LocalDateTime.of(2021,5,27,15,0);
		for (int i=0;i<salesList.size();i++) {
			if (salesList.get(i) instanceof Food) {
				Food food = (Food)salesList.get(i);
				
				if (food.isExpired(currentTime)) {
					food.setExpirationDateTime(currentTime.plusDays(daysToAdd));
				}
			}
		}
	}
	
	public void makeReceipt(Customer customer, int payment) {
		File file = new File("Receipt" + transactionNum +".txt");
		
		try {
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(file));
			outputStream.println(LocalDateTime.of(2021,5,27,15,0));
			outputStream.printf("%-14s%14s%14s%14s\n","Product Name","Unit Price","Quantity","Amount");
			outputStream.println("-".repeat(60));
			for (int i=0;i<customer.getShoppingCart().size();i++) {
				String name = customer.getShoppingCart().get(i).getName();
				int unitPrice = customer.getShoppingCart().get(i).getPrice();
				int quantity = customer.getShoppingCart().get(i).getQuantity();
				int amount = unitPrice * quantity;
				outputStream.printf("%-14s%14d%14d%14d\n",name, unitPrice, quantity, amount);
			}
			outputStream.println("-".repeat(60));
			outputStream.printf("%s%45d\n", "Total Price",customer.getTotalPrice());
			outputStream.println("-".repeat(60));
			if (customer.getWallet().get(payment) instanceof Credit) {
				Credit credit = (Credit)customer.getWallet().get(payment);
				outputStream.println("Credit, " + credit.getBank());
			}
			else {
				Cash cash = (Cash)customer.getWallet().get(payment);
				outputStream.println("Cash, " + cash.getCurrency());
			}
			outputStream.close();
			transactionNum ++;
			

		} catch (FileNotFoundException e) {
			System.out.println("Receipt file not found");
			System.exit(0);
		}
	}
}
