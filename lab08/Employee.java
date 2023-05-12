package lab08;

public abstract class Employee {
	private String name;
	private int employeeNum;
	private String department;
	private int workHrs;
	private double salary;
	
	
	
	public Employee(String name, int employeeNum) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.workHrs = 0;
		this.salary = 0;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getWorkHrs() {
		return workHrs;
	}
	public double getSalary() {
		return salary;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Employee employee = (Employee)obj;
			return this.name == employee.name 
					&& this.employeeNum == employee.employeeNum;
		}
	}
	
	public String toString() {
		return name + ", " + employeeNum;
	}
	
	public void doWork(int hrs) {
		workHrs += hrs;
		this.salary = getPaid();
	}
	
	public abstract double getPaid();
	
	
}
