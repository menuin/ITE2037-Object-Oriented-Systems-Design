package quiz2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length;
		
		try {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the length of array :");
		length = scan.nextInt();
		scan.nextLine();
		
		if (length <0)
			throw new BadNumberException();
		}
		catch (BadNumberException e) {
			System.out.println(e.getMessage() +", " + e.getBadNumber() + " cannot be used");
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the length of array :");
			length = scan.nextInt();
		}
		
		
		Card[] array = new Card[length];
		Random rand = new Random();
		
		for (int i=0;i<length;i++) {
			array[i] = new Card(rand.nextInt(4), rand.nextInt(13)+1);
		}
		
		for (int i=0;i<length;i++) {
			System.out.println(array[i].toString());
		}
		
		Arrays.sort(array);
		
		for (int i=0;i<length;i++) {
			System.out.println(array[i].toString());
		}
		
		
		
		
		ArrayList<Card> array2 = new ArrayList<Card>();
		for (Card c : array) {
			array2.add(c);
		}
		
		System.out.print("Enter the number to increase : ");
		Scanner scan = new Scanner(System.in);
		int increase = scan.nextInt();

		
		for (int i=0;i<increase;i++) {
			Card newCard = new Card(rand.nextInt(4), rand.nextInt(13)+1);

			int index=array2.size()-1;
			
			for (Card c : array2) {
				
				if (c.compareTo(newCard) == -1 || c.compareTo(newCard) == 0) {
					if (array2.indexOf(c) == array2.size()-1) {
						break;
					}
					index = array2.indexOf(c)+1;
				}
				else {	
					index = array2.indexOf(c);
				}
				
				
			}
			if (index == array2.size()-1) {
				array2.add(newCard);
			}
			else {
			for (int j=array2.size()-1;j>index;j--) {
				array2.set(j, array2.get(j-1));
			}
			
			array2.set(index, newCard);
			}
			
		}
		
		for (Card c : array2) {
			System.out.println(c.toString());
		}
		
		
	}

}
