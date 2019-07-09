package chapter07;

import java.util.Scanner;

public class Quiz0705 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("첫 번째 정수를 입력하시오");
			int num1 = sc.nextInt();
			System.out.println("두 번째 정수를 입력하시오");
			int num2 = sc.nextInt();
		
			System.out.println("입력한 두 수의 연산을 정하시오(1 : +, 2 : -, 3 : *, 4 : / )");
			int oPerator = sc.nextInt();
		
			if ((oPerator == 1) || (oPerator == 2) || (oPerator == 3) || (oPerator == 4)) {
				
				System.out.println("연산 결과는 " + operator(num1,num2,oPerator) + "입니다.");
				break;
			} else
				System.out.println("값을 다시 입력하세요");
		
		}
		sc.close();
		
		
	}
	
	public static int operator(int num1, int num2, int num3) {
		int result;
		switch(num3) {
		case 1 :
			result = num1 + num2;
			break;
		case 2 :
			result = num1 - num2;
			break;
		case 3 :
			result = num1 * num2;
			break;
		default :
			result = num1 / num2;
			
		}
		return result;
	}
}
