package assignment3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Shopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime currentTime = LocalDateTime.of(2021,5,27,15,0);
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Mart mart = Mart.getInstance();
		
		
		Scanner inputStream=null;
		// customerList 초기화
		try {
			inputStream = new Scanner(new FileInputStream("src/assignment3/CustomerWallets.txt"));
			int numOfCustomer = inputStream.nextInt();
			inputStream.nextLine();
			for (int i=0;i<numOfCustomer;i++) {
				String customerInfo = inputStream.nextLine();
				String customerName = customerInfo.split(", ")[0];
				
				int numOfWallet = Integer.parseInt(customerInfo.split(", ")[1]);
				customerList.add(new Customer(customerName,numOfWallet));
				mart.addObserver(customerList.get(i));
				
				for (int j=0;j<numOfWallet;j++) {
					String walletInfo = inputStream.nextLine();
					String walletType = walletInfo.split(", ")[0];
					if (walletType.equals("Credit")) {
						
						String creditBank = walletInfo.split(", ")[1];
						int creditLimit = Integer.parseInt(walletInfo.split(", ")[2]);
						int creditUsed = Integer.parseInt(walletInfo.split(", ")[3]);
						
						customerList.get(i).getWallet().add(new Credit(creditBank,creditLimit,creditUsed));
					}
					else {   // walletType.equals("Cash")
						String cashCurrency = walletInfo.split(", ")[1];
						int cashAmount = Integer.parseInt(walletInfo.split(", ")[2]);
						
						customerList.get(i).getWallet().add(new Cash(cashCurrency, cashAmount));
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("CustomerWallets.txt not found");
			System.exit(0);
		}
		
		// mart 초기화
		try {
			inputStream = new Scanner(new FileInputStream("src/assignment3/Mart.txt"));
			int numOfProducts = inputStream.nextInt();
			inputStream.nextLine();
			mart.setSalesList(numOfProducts);
			for (int i=0;i<numOfProducts;i++) {
				String productInfo = inputStream.nextLine();
				String productType = productInfo.split(", ")[0];
				
				if (productType.equals("Food")) {
					String foodName = productInfo.split(", ")[1];
					int foodPrice = Integer.parseInt(productInfo.split(", ")[2]);
					int year = Integer.parseInt(productInfo.split(", ")[3]);
					int month = Integer.parseInt(productInfo.split(", ")[4]);
					int day = Integer.parseInt(productInfo.split(", ")[5]);
					int hour = Integer.parseInt(productInfo.split(", ")[6]);
					int minute = Integer.parseInt(productInfo.split(", ")[7]);
					int foodQuantity = Integer.parseInt(productInfo.split(", ")[8]);
					
					mart.getSalesList().add(new Food(foodName, foodPrice, year, month, day, hour, minute, foodQuantity));
				}
				else {  // productType.equals("Manufactured")
					String manufacturedName = productInfo.split(", ")[1];
					int manufacturedPrice = Integer.parseInt(productInfo.split(", ")[2]);
					String brand = productInfo.split(", ")[3];
					int manufacturedQuantity = Integer.parseInt(productInfo.split(", ")[4]);
					
					mart.getSalesList().add(new Manufactured(manufacturedName, manufacturedPrice, brand, manufacturedQuantity));	
				}
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Mart.txt not found");
			System.exit(0);
		}
		
		
		
		
		
		
		
		
		while (true) {
			try {
				System.out.println("-".repeat(20));
				System.out.println("1. Manager Mode");
				System.out.println("2. Customer Mode");
				System.out.println("3. End Program");
				System.out.println("-".repeat(20));
				System.out.print("Select menu : ");
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				scan.nextLine();
				
				switch (choice) {
				case 1: // Manager mode
					while (true) {
						try {
							System.out.println("-".repeat(20));
							System.out.println("1. Add Inventory");
							System.out.println("2. Replace Expired");
							System.out.println("-".repeat(20));
							System.out.print("Select menu : ");
							int choice2 = scan.nextInt();
							scan.nextLine();
							
							if (choice2 == 0) break;
							else if (choice2 == 1) {	// Add inventory
								while (true) {
									try {
										mart.printSalesList();
										System.out.print("Select Product : ");
										int productChoice = scan.nextInt();
										scan.nextLine();
										if (productChoice > mart.getSalesList().size())
											throw new InvalidAccessException();
										else if (productChoice == 0) break;
										System.out.print("Enter Quantity : ");
										int productQuantity = scan.nextInt();
										scan.nextLine();
										
										mart.addInventory(productChoice, productQuantity);
										break;
									} catch (InvalidAccessException e) {
										System.out.println(e.getMessage());
										System.out.println("Try again.");
									} catch (InputMismatchException e) {
										System.out.println("Input Mismatch");
										System.out.println("Try again.");
										scan.nextLine();
									}
								}
							}
							else if (choice2 == 2) {    // replace expired
								mart.printExpired();
								System.out.print("Enter days to add : ");
								int daysToAdd = scan.nextInt();
								scan.nextLine();
								mart.updateExpired(daysToAdd);
								
							}	
							else // choice out of given range
								throw new InvalidAccessException();
						}
						catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
							System.out.println("Try again.");
						}
						catch (InputMismatchException e) {
							System.out.println("Input mismatch");
							System.out.println("Try again.");
							scan.nextLine();
						}
						
					}
					break;
					
					
					
					
					
					
				case 2:  // customer mode
					System.out.println("-".repeat(20));
					for (int i=0;i<customerList.size();i++) {
						System.out.println(i+1 +") "+customerList.get(i).getName());
					}
					System.out.println("-".repeat(20));
					System.out.print("Select Customer : ");
					int choice2 = scan.nextInt();
					scan.nextLine();
					
					if (choice2 == 0) break;
					else if (choice2 > customerList.size()) 
						throw new InvalidAccessException();
					else {
						Customer customer = customerList.get(choice2-1);
						
						while (true) {
							try {
								System.out.println("-".repeat(20));
								System.out.println("1. Shopping");
								System.out.println("2. Print Shopping Cart");
								System.out.println("3. Paying");
								System.out.println("4. Print Wallet");
								System.out.println("-".repeat(20));
	
								System.out.print("Select menu : ");
								
								int choice3 = scan.nextInt();
								scan.nextLine();
								
								if (choice3 == 0) break;
								else if (choice3 == 1) {  // shopping
									while(true) {
										try {
											System.out.println("-".repeat(20));
											mart.printSalesList();
											System.out.println("-".repeat(20));
											System.out.print("Select product to buy : ");
											int productToBuy = scan.nextInt();
											scan.nextLine();
											if (productToBuy == 0) break;
											else if (productToBuy > mart.getSalesList().size())
												throw new InvalidAccessException();
											
											System.out.print("Enter quantity to buy : ");
											int quantityToBuy = scan.nextInt();
											scan.nextLine();
											
											
											Product product = mart.getSalesList().get(productToBuy-1);
											try {
												customer.purchase(product, quantityToBuy);
											} catch (ExpiredException e) {
												System.out.println(e.getMessage());
											}
										} catch (InvalidAccessException e) {
											System.out.println(e.getMessage());
											System.out.println("Try again.");
										} catch (InputMismatchException e) {
											System.out.println("Input Mismatch");
											System.out.println("Try again.");
											scan.nextLine();
										}
									}
								}
								else if (choice3 == 2) {  // Print shopping cart
									System.out.println("----Shopping cart----");
									customer.printShoppingCart();
								}
								
								else if (choice3 == 3) {  // Paying
									System.out.println(LocalDateTime.of(2021,5,27,15,0));
									System.out.printf("%-14s%14s%14s%14s\n","Product Name","Unit Price","Quantity","Amount");
									System.out.println("-".repeat(60));
									for (int i=0;i<customer.getShoppingCart().size();i++) {
										String name = customer.getShoppingCart().get(i).getName();
										int unitPrice = customer.getShoppingCart().get(i).getPrice();
										int quantity = customer.getShoppingCart().get(i).getQuantity();
										int amount = unitPrice * quantity;
										System.out.printf("%-14s%14d%14d%14d\n",name, unitPrice, quantity, amount);
									}
									System.out.println("-".repeat(60));
									System.out.printf("%s%45d\n", "Total Price",customer.getTotalPrice());
									System.out.println("-".repeat(60));
									
									while (true) {
										try {
											customer.printWallet();
											System.out.print("Select payment method : ");
											int payment = scan.nextInt();
											scan.nextLine();
											if (payment > customer.getWallet().size())
												throw new InvalidAccessException();
											else if (payment == 0) break;
											
											try {
												customer.pay(payment-1);
												mart.makeReceipt(customer, payment-1);
												customer.getShoppingCart().clear();
												break;
												
											} catch (NotEnoughBalanceException e) {
												int diff;
												if (customer.getWallet().get(payment-1) instanceof Cash) {
													Cash cash = (Cash)customer.getWallet().get(payment-1);
													diff = customer.getTotalPrice() - cash.getAmount();
												}
												else {
													Credit credit = (Credit)customer.getWallet().get(payment-1);
													diff = customer.getTotalPrice() - (credit.getLimit() - credit.getAmountUsed());
												}
												System.out.println(diff + " won is not enough.");

											}
										} catch (InvalidAccessException e) {
											System.out.println(e.getMessage());
											System.out.println("Try again.");
										} catch (InputMismatchException e) {
											System.out.println("Input Mismatch");
											System.out.println("Try again.");
											scan.nextLine();
										}
									}
								}
								else if (choice3 == 4) {  // Print Wallet
									System.out.println("---- Wallet ----");
									customer.printWallet();
								}
								
								else    // choice out of given range
									throw new InvalidAccessException();
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
								System.out.println("Try again.");
							} catch (InputMismatchException e) {
								System.out.println("Input Mismatch");
								System.out.println("Try again.");
								scan.nextLine();
							}
						}
					}
					break;
					
					
					
					
					
				case 3: // End Program
					System.out.println("End Program");
					System.exit(0);
					
				default:
					throw new InvalidAccessException();
				}
				
				
					
			}
			catch (InvalidAccessException e) {
				System.out.println(e.getMessage());
				System.out.println("Try again.");
			} catch (InputMismatchException e) {
				System.out.println("Input Mismatch");
				System.out.println("Try again.");
			}
				
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
