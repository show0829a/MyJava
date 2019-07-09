package chapter06;

import java.util.Scanner;
public class Quiz0610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5개의 정수를 입력하시오(1 이상)");
		int num = 0;
		int result = 0;
		
		for(int i = 0; i < 5;) {
			num = sc.nextInt();
			
			if(1 > num) {
				System.out.println("다시 입력해주세요");
			
				
			} else {
				result += num;
				i++;
			}
		}
		System.out.printf("5개 정수의 합은 %d 입니다.",result);
		sc.close();
	}

}
