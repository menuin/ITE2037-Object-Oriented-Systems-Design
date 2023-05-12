package assignment2;

public class InvalidAccessException extends Exception {
	public InvalidAccessException() {
		super("Invalid Access");
	}
	
	public InvalidAccessException(String message) {
		super(message);
	}
}
