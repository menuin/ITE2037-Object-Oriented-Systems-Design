package kr.co.lab05.employee;

public class Employee {
	private String name;
	private double yearlySalary;
	private double monthlySalary;
	private double balance;
	
	// constructor
	public Employee (String name, double yearlySalary) {
		this.name = name;
		this.yearlySalary = yearlySalary;
		this.monthlySalary = yearlySalary / 12;
		this.balance = 0;
	}
	
	// getter
	public double getBalance () {
		return this.balance;
	}
	
	// 연봉 증가 method
	public void increaseYearlySalary (int byPercent) {
		this.yearlySalary = this.yearlySalary * (1+ (double)byPercent/100);
		this.monthlySalary = this.yearlySalary / 12;
	}
	
	// 월급 받는 method
	public void receiveSalary() {
		this.balance += this.monthlySalary;
	}
	
	// toString method
	public String toString() {
		return "이름 : " + this.name + " 연봉 : " + this.yearlySalary + " 월급 : " + this.monthlySalary + " 재산 : " + this.balance;

	}
	
}
