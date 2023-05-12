package assignment2;

public class InsufficientConditionException extends Exception {
	
	public InsufficientConditionException() {
		super("Insufficient Condition");
	}
	
	public InsufficientConditionException(String message) {
		super(message);
	}
}
