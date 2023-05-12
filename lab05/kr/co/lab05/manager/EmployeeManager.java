package kr.co.lab05.manager;

import java.time.LocalDate;
import kr.co.lab05.employee.Employee;
import java.util.Random;

public class EmployeeManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee Kim = new Employee("Kim",4500);
		System.out.println("계약일 : " + LocalDate.of(2021,4,1));
		System.out.println(Kim.toString());
		
		// 인센티브를 부여할 랜덤한 월
		Random rnd = new Random();
		int rndMonth = rnd.nextInt(12) + 1;
		
		// 근무년, 근무개월 초기화
		int workMonth = 0;
		int workYear = 1;
		
		while (Kim.getBalance() < 20000) {  // 재산이 20000이 되기전까지 반복
			workMonth ++;
			if (workMonth <= 12) {  // 근무개월이 12개월 이하일 경우 
				
				Kim.receiveSalary();
				
				// 현재 월이 인센티브를 받는 월일 경우
				if (workMonth == rndMonth) {
					Kim.receiveSalary();
					System.out.println(workYear + "년차 " + workMonth + "월에 인센티브를 받았습니다.");	
				}
				
			}
			
			else { // 근무한지 12개월이 지났을 경우
				
				workMonth = 0;
				workYear ++;
				
				// 랜덤한 연봉 증가율로 연봉 증가
				int rndPercent = rnd.nextInt(11);
				Kim.increaseYearlySalary(rndPercent);
				System.out.println(workYear + "년차 연봉이 " + rndPercent +"% 인상되었습니다.");
				
				// 인센티브를 부여할 랜덤한 월 초기화
				rndMonth = rnd.nextInt(12)+1;
				
			}
		}
		
		// 마지막으로 연봉을 받은 월이 12월일 경우 날짜는 1월을 출력해야하므로 월 초기화
		if (workMonth == 12) workMonth=0;
		
		System.out.println("날짜 : " + LocalDate.of(2021+workYear,workMonth+1, 1));
		System.out.println(Kim.toString());
	}

}
