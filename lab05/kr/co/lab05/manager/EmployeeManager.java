package kr.co.lab05.manager;

import java.time.LocalDate;
import kr.co.lab05.employee.Employee;
import java.util.Random;

public class EmployeeManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee Kim = new Employee("Kim",4500);
		System.out.println("����� : " + LocalDate.of(2021,4,1));
		System.out.println(Kim.toString());
		
		// �μ�Ƽ�긦 �ο��� ������ ��
		Random rnd = new Random();
		int rndMonth = rnd.nextInt(12) + 1;
		
		// �ٹ���, �ٹ����� �ʱ�ȭ
		int workMonth = 0;
		int workYear = 1;
		
		while (Kim.getBalance() < 20000) {  // ����� 20000�� �Ǳ������� �ݺ�
			workMonth ++;
			if (workMonth <= 12) {  // �ٹ������� 12���� ������ ��� 
				
				Kim.receiveSalary();
				
				// ���� ���� �μ�Ƽ�긦 �޴� ���� ���
				if (workMonth == rndMonth) {
					Kim.receiveSalary();
					System.out.println(workYear + "���� " + workMonth + "���� �μ�Ƽ�긦 �޾ҽ��ϴ�.");	
				}
				
			}
			
			else { // �ٹ����� 12������ ������ ���
				
				workMonth = 0;
				workYear ++;
				
				// ������ ���� �������� ���� ����
				int rndPercent = rnd.nextInt(11);
				Kim.increaseYearlySalary(rndPercent);
				System.out.println(workYear + "���� ������ " + rndPercent +"% �λ�Ǿ����ϴ�.");
				
				// �μ�Ƽ�긦 �ο��� ������ �� �ʱ�ȭ
				rndMonth = rnd.nextInt(12)+1;
				
			}
		}
		
		// ���������� ������ ���� ���� 12���� ��� ��¥�� 1���� ����ؾ��ϹǷ� �� �ʱ�ȭ
		if (workMonth == 12) workMonth=0;
		
		System.out.println("��¥ : " + LocalDate.of(2021+workYear,workMonth+1, 1));
		System.out.println(Kim.toString());
	}

}
