package assignment2;

public class ShowActivity extends Activity {
	private int minAge;
	
	public int getMinAge() {
		return minAge;
	}
	
	public ShowActivity(String name, String location, int price, int minAge) {
		super(name, location, price);
		this.minAge = minAge;
	}
	
	public ShowActivity(ShowActivity activity) {
		super(activity);
		this.minAge = activity.minAge;
	}
	
	public int getActualPrice(Person person) {
		if (person.getAge() <= 19)
			return (int)(this.getPrice() * 0.8);
		else
			return this.getPrice();
	}
}
