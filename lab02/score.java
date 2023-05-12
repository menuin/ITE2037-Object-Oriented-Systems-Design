import java.util.Scanner;

public class score {
	
	private static String makeOrdinalNumber(int num) {
		switch (num % 10) {
		case 1 :
			return num + "st";
		
		case 2 :
			return num + "nd";
		
		case 3 :
			return num + "rd";
		}
		
		return num + "th";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine().toUpperCase();
		String [] input_arr = input.split(" ");
		
		int numOfStudents = input_arr.length;
		
		int numScore = 0;
		float sum = 0;
		
		for (int i=0;i<numOfStudents;i++) {
			
			switch (input_arr[i]) {
			case "A" :
				numScore = 100;
				break;
			
			case "B" :
				numScore = 90;
				break;
				
			case "C" :
				numScore = 80;
				break;
				
			case "D" :
				numScore = 70;
				break;
				
			case "F" :
				numScore = 0;
			
			}
			
			System.out.printf (makeOrdinalNumber(i+1)+" student's score is %d\n",numScore);
			sum += numScore;
			
		}
		
		float average = sum/numOfStudents;
		String fixedAvg = String.format("%.2f", average);
		
		System.out.println("This class's average = " + fixedAvg );
		
		
		
		
	}

}
