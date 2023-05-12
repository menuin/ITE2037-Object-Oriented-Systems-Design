package lab08;

public class Engineer extends Employee {
	private double rate;
	
	public Engineer(String name, int employeeNum) {
		super(name, employeeNum);
		this.setDepartment("Engineering");
		this.rate = 4.0;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else if (getClass() != obj.getClass()) return false;
		else {
			Engineer engineer = (Engineer)obj;
			return super.equals(engineer);
		}
	}
	
	public String toString() {
		return super.toString() + ", " + this.getDepartment();
	}
	
	public double getPaid() {
		double pay = this.getWorkHrs() * rate;
		return pay;
	}
}
