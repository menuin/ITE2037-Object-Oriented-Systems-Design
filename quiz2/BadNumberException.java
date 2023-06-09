package quiz2;

public class BadNumberException extends Exception {
	private int badNumber;
	
	public BadNumberException() {
		super("Bad Number");
	}
	
	public BadNumberException(String message) {
		super(message);
	}
	
	public BadNumberException(int num) {
		super("Bad Number");
		badNumber = num;
	}
	
	public int getBadNumber() {
		return badNumber;
	}
}
