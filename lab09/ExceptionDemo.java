package lab09;

import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee = new Employee("Kim");
		
		while (true) {
			
			try {
			Scanner scan = new Scanner(System.in);
			System.out.print(employee.getWorkDay() + "일차 근무 시간을 입력하세요 : ");
			int workHr = scan.nextInt();
			
			if (workHr < 0)
				throw new NegativeException();
			
			if (workHr == 0)
				throw new Exception("Program Exit");
			
			if (workHr > 24)
				throw new TooMuchStuffException(workHr);
			
			employee.addWorkHours(workHr);
			employee.addWorkDay();
			System.out.println("이름 : "+employee.getName());
			System.out.println("누적 근무 시간 : "+employee.getWorkHours());
			System.out.println("No exception has been occurred");
			
			}
	
			catch(NegativeException e){
				System.out.println(e.getMessage());
			}
			catch(TooMuchStuffException e) {
				System.out.println(e.getInputNum()+", " + e.getMessage());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			finally {
				System.out.println("End of try-catch statement");
			}
			
		}
	}

}
