package lab07;

public class Manager extends Employee {
	private int officeNum;
	private String team;
	
	public Manager(String name, int employeeNum, int officeNum, String team) {
		super(name,employeeNum,"Management");
		this.officeNum = officeNum;
		this.team = team;
	}
	
	public String toString() {
		return "Name : " + this.getName() + "\rEmp# : " + this.getEmployeeNum()
		+ "\rDepartment : " + this.getDepartment() + "\rOffice# : " + officeNum
		+ "\rTeam : " + team;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Manager manager = (Manager)obj;
			return getName() == manager.getName() 
					&& getEmployeeNum() == manager.getEmployeeNum()
					&& getDepartment() == manager.getDepartment()
					&& officeNum == manager.officeNum
					&& team == manager.team;
		}
	}
	
	
	
}
