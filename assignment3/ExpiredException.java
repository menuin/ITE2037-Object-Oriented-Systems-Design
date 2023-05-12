package assignment3;

public class ExpiredException extends Exception {
	public ExpiredException() {
		super("date expired food");
	}
	
	public ExpiredException(String message) {
		super(message);
	}
}
