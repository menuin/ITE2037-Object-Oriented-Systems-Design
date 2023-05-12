package lab0318;

public class Employee {
	
	// instance variables
	private String name;
	private int age;
	private String position;
	private int salary;
	private int vacationDays;
	
	// constructor
	public Employee(String name, int age) {
		this.position = "Employee";
		this.salary = 5000;
		this.vacationDays = 20;
		this.name = name;
		this.age = age;
	}
	
	public Employee (String name, int age, String position, int salary) {
		this.vacationDays = 20;
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
	}
	
	public Employee (String name, int age, String position, int salary, int vacationDays) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = vacationDays;
		
	}

	// getter, setter method
	public String getName() {
		return this.name;
	}
	public void setName (String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
	
	// public equals method
	public boolean equals(Employee anotherEmployee) {
		if (this.name == anotherEmployee.name
				&& this.age == anotherEmployee.age
				&& this.position == anotherEmployee.position)
			return true;
		return false;
	
		}
		
	// public toString method
	public String toString () {
		return "Name: " + name +", Age: " +age + ", Position: "+position+", Salary: "+salary+", VacationDays: "+vacationDays;
	}
	
	// public void vacation
	public void vacation (int vacationDays) {
		if (this.vacationDays < vacationDays) {
			System.out.println("남은 휴가 일수가 부족합니다.");
		}
		else {
			this.vacationDays -= vacationDays;
			System.out.printf("휴가를 사용하였습니다. 남은 휴가 일수: %d\n",vacationDays);
		}
	}
}
