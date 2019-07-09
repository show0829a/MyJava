package chapter06;

import java.util.Scanner;

public class Quiz0603 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("하나의 정수를 입력 : ");
		
		int num = sc.nextInt();
		int fact = 1;
	/*
	 선생님의 풀이
	 	while(num > 0) {
	 		if(num > 0) {
	 			System.out.print(num + " * ");
	 			} else {
	 			System.out.print(num + " = ");
	 			}
	 */ // 보이는 것을 좀 더 규칙적으로 
		while(num>0)
		{
			if(num>1) {
				
				fact = fact*num;
				System.out.printf("%d*",num);	
				
			} else {
				System.out.printf("1 = %d", fact);
				
			}
				
			num--;
		}
		
		sc.close();
	}
}
