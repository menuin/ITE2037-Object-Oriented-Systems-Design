package assignment2;

public class ExtremeActivity extends Activity {
	private int minHeight;
	private int minWeight;
	
	
	
	public int getMinHeight() {
		return minHeight;
	}

	public int getMinWeight() {
		return minWeight;
	}


	public ExtremeActivity(String name, String location, int price, int minHeight, int minWeight) {
		super(name, location, price);
		this.minHeight = minHeight;
		this.minWeight = minWeight;
	}
	
	public ExtremeActivity(ExtremeActivity activity) {
		super(activity);
		this.minHeight = activity.minHeight;
		this.minWeight = activity.minWeight;
	}
	
	public int getActualPrice(Person person) {
		if (person.getAge() >= 60)
			return (int)(this.getPrice() * 1.3);
		else
			return this.getPrice();
	}
	
	
}
