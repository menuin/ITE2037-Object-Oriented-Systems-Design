package assignment2;

public class ArrayFullException extends Exception {
	public ArrayFullException() {
		super("Schedule list is full");
	}
	
	public ArrayFullException(String message) {
		super(message);
	}
}
