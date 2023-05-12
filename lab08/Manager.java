package lab08;

public class Manager extends Employee {
	private double overtimeRate;
	private double rate;
	private int regularHrs;
	
	public Manager(String name, int employeeNum) {
		super(name, employeeNum);
		this.rate =4.0;
		this.overtimeRate = 8.0;
		this.regularHrs = 40;
		this.setDepartment("Management");
	}
	
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else if (getClass() != obj.getClass()) return false;
		else {
			Manager manager = (Manager)obj;
			return super.equals(manager);
		}
	}
	
	public String toString() {
		return super.toString() + ", " + this.getDepartment();
	}
	
	public double getPaid() {
		int overtimeHrs = this.getWorkHrs() - this.regularHrs;
		double pay;
		
		if (this.getWorkHrs() < 40)
			pay = this.getWorkHrs() * this.rate;
		else
			pay = (this.regularHrs * rate) + (overtimeHrs * this.overtimeRate);
		
		return pay;
	}
}
