package quiz1;

public class Card {
	
	private int symbol;
	private int number;
	
	public Card(int symbol, int number) {
		this.symbol = symbol;
		this.number = number;
	}
	
	public Card(Card aCard) {
		this.symbol = aCard.symbol;
		this.number = aCard.number;
	}
	
	public int getSymbol() {
		return this.symbol;
	}
	
	public int getNumber() {
		return this.number;
		
	}
	
	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean equals(Card aCard) {
		if (this.symbol == aCard.symbol && this.number == aCard.number)
			return true;
		return false;
	}
	
	public String toString() {
		String symbolName="";
		switch(this.symbol) {
		case 0:
			symbolName="Clubs";
			break;
		case 1:
			symbolName = "Diamonds";
			break;
		case 2:
			symbolName = "Hearts";
			break;
		case 3:
			symbolName = "Spades";
			break;
		}
		
		return symbolName + ", " + this.getNumber();
	}
	
	public static int compareCard(Card cardA, Card cardB) {
		if (cardA.getNumber() > cardB.getNumber()) return -1;
		else if (cardA.getNumber() < cardB.getNumber()) return 1;
		else return 0;
	}
}
