package assignment3;

public class Cash implements Payable {
	private String currency;
	private int amount;
	
	public void pay (int amount) throws NotEnoughBalanceException{

		if ( amount <= this.amount)
			this.amount -= amount;
		else
			throw new NotEnoughBalanceException();
	}
	
	public Cash(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public String toString() {
		return currency + ", " + amount + " won";
	}
	
	public int getAmount() {
		return amount;
	}
	
}
