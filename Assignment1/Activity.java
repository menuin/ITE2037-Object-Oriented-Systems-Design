package assignment1;


public class Activity {
	
	private String name;
	private String location;
	private int price;
	
	// constructor
	public Activity(String name, String location, int price) {
		this.name = name;
		this.location = location;
		this.price = price;
	}
	
	// copy constructor
	public Activity(Activity activity) {
		this.name = activity.name;
		this.location = activity.location;
		this.price = activity.price;
	}
	
	// getter, setter 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// toString method
	public String toString() {
		return name + "(" + location + ", " + price + " won)";
	}
	
	// equals method
	public Boolean equals(Activity activity) {
		if (activity == null) return false;
		return name == activity.name
				&& location == activity.location
				&& price == activity.price;
	}
}	

