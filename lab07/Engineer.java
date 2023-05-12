package lab07;

public class Engineer extends Employee {
	private String workZone;
	private String project;
	
	public Engineer(String name, int employeeNum, String workZone, String project) {
		super(name, employeeNum, "Engineering");
		this.workZone = workZone;
		this.project = project;
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Engineer engineer = (Engineer)obj;
			return getName() == engineer.getName()
					&& getEmployeeNum() == engineer.getEmployeeNum()
					&& getDepartment() == engineer.getDepartment()
					&& workZone == engineer.workZone
					&& project == engineer.project;
		}
	}
	
	public String toString() {
		return "Name : " + getName() + "\rEmp# : " + getEmployeeNum() +
				"\rDepartment : " + getDepartment() + "\rZone : " + workZone;
	}
}
