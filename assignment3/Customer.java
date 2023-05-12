package assignment3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Observer {
	private String name;
	private ArrayList<Payable> wallet;
	private ArrayList<Product> shoppingCart = new ArrayList<Product>();
	
	public Customer(String name, int numOfWallet) {
		this.name = name;
		this.wallet = new ArrayList<Payable>(numOfWallet);
	}
	
	public ArrayList<Payable> getWallet(){
		return this.wallet;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Product> getShoppingCart(){
		return shoppingCart;
	}
	
	public void update(InventoryManager generator) {
		Mart mart = Mart.getInstance();
		for (int i=0;i<mart.getSalesList().size();i++) {
			Product product = mart.getSalesList().get(i);
			if (product.getQuantity() != 0 && product.getWaitList().contains(this)) {
				System.out.println("-".repeat(20));
				mart.printSalesList();
				System.out.println("-".repeat(20));
				System.out.println(this.getName() + " : 대기자 구매");
				System.out.print("Select product to buy : ");
				Scanner scan = new Scanner(System.in);
				int productToBuy = scan.nextInt();
				scan.nextLine();
				
				System.out.print("Enter quantity to buy : ");
				int quantityToBuy = scan.nextInt();
				scan.nextLine();
				product = mart.getSalesList().get(productToBuy-1);
				try {
					this.purchase(product, quantityToBuy);
					product.getWaitList().remove(this);
				} catch (ExpiredException e) {
					System.out.println(e.getMessage());
				}
				
				

			}
		}
	}
	
	public void purchase(Product product, int quantity) throws ExpiredException {
		
			if (product instanceof Food) {
				Food food = (Food)product;
				LocalDateTime currentTime = LocalDateTime.of(2021,5,27,15,0);
				if (food.isExpired(currentTime)) {
					throw new ExpiredException();
				}
			}
			if (product.getQuantity() == 0) {
				System.out.println("It is out of stock. "
						+ "You are added to the wait list.");
				product.wait(this);
			}
			else if (product.getQuantity() < quantity) { 
				System.out.println("Not enough stock."
						+ " You're added to the wait list for the remaining purchase.");
				shoppingCart.add(new Product(product.getName(),product.getPrice(),product.getQuantity()));
				product.setQuantity(0);

				product.wait(this);
				
			}
			else {
				shoppingCart.add(new Product(product.getName(),product.getPrice(),quantity));
				product.setQuantity(product.getQuantity() - quantity);
			}
	}
	
	public void printShoppingCart() {
		for (int i=0;i<shoppingCart.size();i++)
			System.out.println(i+1 + ") " + shoppingCart.get(i).getName() + ", " + shoppingCart.get(i).getQuantity());
	}
	
	public int getTotalPrice() {
		int totalPrice=0;
		for (int i=0;i<shoppingCart.size();i++) {
			totalPrice += shoppingCart.get(i).getPrice() * shoppingCart.get(i).getQuantity();
		}
		return totalPrice;
	}
	
	public void printWallet() {
		for (int i=0;i<wallet.size();i++) {
			if (wallet.get(i) instanceof Credit) {
				Credit credit = (Credit)wallet.get(i);
				System.out.println(i+1 +". " + credit.toString());
			}
			else {
				Cash cash = (Cash)wallet.get(i);
				System.out.println(i+1 + ". " + cash.toString());
			}
		}
	}
	
	public void pay(int payment) throws NotEnoughBalanceException{
		if (wallet.get(payment) instanceof Cash) {
			wallet.get(payment).pay(this.getTotalPrice());
		}
		else if (wallet.get(payment) instanceof Credit) {
			wallet.get(payment).pay(this.getTotalPrice());
		}
	}	

}
