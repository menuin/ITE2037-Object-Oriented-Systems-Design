package lab10;

public class Dog extends Animal implements Barkable {
	
	public Dog() {
		this.setName("Dog");
	}
	
	public String bark() {
		return "Bowwow";
	}
}
