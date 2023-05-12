package lab10;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();
		
		Animal[] animals = new Animal[3];
		animals[0] = dog;
		animals[1] = tiger;
		animals[2] = turtle;
		
		Person person = new Person() {
			private int hp = 100;
			
			public void control(Animal animal) {
				if (animal instanceof Tiger)
					hp -= 80;
				else if (animal instanceof Dog)
					hp -= 10;
				else;
				
				System.out.println("You have overpowered the " + animal.getName());
			}
			
			public void showInfo() {
				System.out.println("Person HP: " + this.hp);
			}
			
			
		};
		
		showResult(animals,person);
	
	}
	
	private static void showResult(Animal[] animals, Person p) {
		
		for (int i=1;i<=animals.length;i++) {
			System.out.println("Animal"+i+": "+animals[i-1].getName());

			if (animals[i-1] instanceof Dog) {
				Dog dog2 = (Dog)animals[i-1];
				System.out.println("Animal"+i+" barked "+ dog2.bark());
			}
			else if (animals[i-1] instanceof Tiger) {
				Tiger tiger2 = (Tiger)animals[i-1];
				System.out.println("Animal"+i+" barked "+ tiger2.bark());
			}
			
			p.control(animals[i-1]);
			p.showInfo();
	}
		

}
}
