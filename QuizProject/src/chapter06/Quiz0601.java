package chapter06;

import java.util.Scanner;

public class Quiz0601 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("정수 두 개를 입력하시오");
		System.out.println("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두 번째 정수 : ");
		int num2 = sc.nextInt();
		/*
		int result;
		
		if(num1 > num2) {
			if(num1-num2 >= 0)
				result = num1-num2;
			else
				result = -(num1-num2);
		} else {
			if(num2-num1 >= 0)
				result = num2-num1;
			else
				result = -(num2-num1);
		}
		*/
		int result = num1-num2;
		if(result <0)
			result = result * -1;
		//두 수의 차이는 양수던 음수던 두 수의 -이다 복잡하게 생각 x
		System.out.printf("두 정수의 차이는 %d 입니다.", result);
		// int result2 = (num1 > num2)? num1 -num2 : num2 - num1;
		// int result3 = (result > 0)? result : result*-1;
		sc.close();
	}

}
