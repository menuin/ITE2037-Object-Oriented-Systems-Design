import java.util.Scanner;

public class scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		String input = scan.nextLine().replace("ppt","pdf");
		
		
		String [] input_arr = input.split(" ");
		
		int name_length = input_arr.length - 1;
		System.out.printf("Name Length(Korean) : %d\n", name_length);
		
		System.out.printf("%s.%s.%s%s submitted %s%s", 
				input_arr[1].substring(0,1).toUpperCase(), 
				input_arr[2].substring(0,1).toUpperCase(),
				input_arr[0].substring(0,1).toUpperCase(),
				input_arr[0].substring(1,input_arr[0].length()),
				input_arr[name_length].substring(0,1).toUpperCase(),
				input_arr[name_length].substring(1,input_arr[name_length].length()));
		
	}

}
