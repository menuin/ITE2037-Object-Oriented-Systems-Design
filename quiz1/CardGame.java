package quiz1;

import java.util.Scanner;
public class CardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.printf("Player Name : ");
		String myName = scan.nextLine();
		
		System.out.println("-----");
		Participant participant = new Participant(myName);
		Participant dealer = new Participant("Dealer");
		
		int round=0;
		
		while (round<3) {
			round ++;
			
			System.out.println(dealer.toString());
			System.out.println(participant.toString());
			System.out.println("-----");
			
			if ( Card.compareCard(dealer.getCard(), participant.getCard()) == 1 ) {
				participant.addPoint(1);
			}
			
			participant.setCard(dealer.getCard());
			dealer.changeCard();
		
	}
		System.out.println(participant.getName()+", "+participant.getPoint() +" points");
		

}
}
