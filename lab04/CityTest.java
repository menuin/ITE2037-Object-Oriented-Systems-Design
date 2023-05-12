package lab04;

public class CityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		City Seoul = new City ("Seoul",23,45);
		City Paris = new City ("Paris",123,41);
		City RacoonCity = new City ("Racoon City");
		City MegaCity = new City ("Mega City");
		
		System.out.println(Seoul.toString());
		System.out.println(Paris.toString());
		System.out.println(RacoonCity.toString());
		System.out.println(MegaCity.toString());
		
		System.out.println("Seoul-Paris : " + City.distance(Seoul, Paris));
		System.out.println("Seoul-Racoon City : " + City.distance(Seoul, RacoonCity));
		System.out.println("Paris-Mega City : " + City.distance(Paris, MegaCity));
		
	}

}
