package lab0318;

public class EmployeeManger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee James = new Employee("James Wright",42,"Manager",20000);
		Employee Amy = new Employee("Amy Smith",27,"Design Coordinator",8000,15);
		Employee Peter = new Employee("Peter Coolidge",32,"Assistant Manager",12000,7);
		Employee John = new Employee("John Doe",22,"Engineer",10000,10);
		
		System.out.println(James.toString());
		System.out.println(Amy.toString());
		System.out.println(Peter.toString());
		System.out.println(John.toString());
		
		Employee Eunmin = new Employee("김은민",21);
		if (Eunmin.equals(Amy)) {
			System.out.println("같은 직원 입니다.");
		}
		else {
			System.out.println("다른 직원입니다.");
		}
		
		James.vacation(10);
		Peter.vacation(10);
		
		System.out.println(James.toString());
		System.out.println(Amy.toString());
		System.out.println(Peter.toString());
		System.out.println(John.toString());
		System.out.println(Eunmin.toString());
		
		
	}

}
