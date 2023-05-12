package assignment3;

public class NotEnoughBalanceException extends Exception {
	public NotEnoughBalanceException() {
		super("not enough balance");
	}
	
	public NotEnoughBalanceException(String message) {
		super(message);
	}
	

	
}
