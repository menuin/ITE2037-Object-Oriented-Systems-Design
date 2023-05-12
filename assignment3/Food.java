package assignment3;

import java.time.LocalDateTime;

public class Food extends Product {
	private LocalDateTime expirationDateTime;
	
	public boolean isExpired(LocalDateTime present) {
		if (expirationDateTime.compareTo(present) < 0)
			return true;
		else
			return false;
	}
	
	public Food(String name, int price, int year, int month, int day, int hour, int minute, int quantity) {
		super(name, price, quantity);
		this.expirationDateTime = LocalDateTime.of(year,month,day,hour,minute);
	}
	
	public LocalDateTime getExpirationDateTime() {
		return this.expirationDateTime;
	}
	
	public void setExpirationDateTime(LocalDateTime expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}
}
