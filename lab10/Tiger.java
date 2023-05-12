package lab10;

public class Tiger extends Animal implements Barkable {
	public Tiger() {
		this.setName("Tiger");
	}
	
	public String bark() {
		return "Growl";
	}
}
