package lab11;

import java.util.ArrayList;

public class Management {
	public static <T extends Employee> void moveDepartment(T t, String department) {
		t.setDepartment(department);
	}
	
	public static <T extends Employee> void raiseSalary(T t, double rate) {
		t.setSalary(t.getSalary() * rate);
	}
	
	public static <T extends Employee> int findIndexByEmpNum(ArrayList<T>tList, int employeeNum) {
		for (T t:tList) {
			if (t.getEmployeeNum() == employeeNum) 
				return tList.indexOf(t);
		}
		return -1;
	}
	
	public static <T extends Employee> void raiseAllSalary(ArrayList<T> tList, double rate) {
		for (T t:tList) {
			t.setSalary(t.getSalary() * rate);
		}
	}
}
