package quiz1;

import java.util.Random;

public class Participant {
	private String name;
	private Card card;
	private int point;
	
	
	public Participant(String name) {
		this.name = name;
		
		Random rnd = new Random();
		
		int rndSymbol = rnd.nextInt(4);
		int rndNumber = rnd.nextInt(13)+1;
		
		this.card= new Card(rndSymbol,rndNumber);
		this.point =0;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Card getCard() {
		return new Card(this.card);
	}


	public void setCard(Card card) {
		this.card = new Card(card);
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
	
	public void addPoint(int point) {
		this.point += point;
	}
	
	public void changeCard() {
		Random rnd = new Random();
		int rndSymbol = rnd.nextInt(4);
		int rndNumber = rnd.nextInt(13)+1;
		
		this.card = new Card(rndSymbol,rndNumber);
		
	}
	
	public String toString() {
		
		return this.name + " has " +this.card.toString()+"(point: "+this.point+")";
	}
}
