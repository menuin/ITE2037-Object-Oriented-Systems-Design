package assignment3;

public class Credit implements Payable {
	private String bank;
	private int limit;
	private int amountUsed;
	
	public void pay (int price) throws NotEnoughBalanceException{
		
		if (price <= limit-amountUsed)
			amountUsed += price;
		else
			throw new NotEnoughBalanceException();

	}
	
	public Credit(String bank, int limit, int amountUsed) {
		this.bank = bank;
		this.limit = limit;
		this.amountUsed = amountUsed;
	}
	
	public String getBank() {
		return bank;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public int getAmountUsed() {
		return amountUsed;
	}
	
	public String toString() {
		return bank + ", Amount used : " + amountUsed + " won (Limit : " + limit + " won)"; 
	}


}
