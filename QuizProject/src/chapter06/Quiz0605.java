package chapter06;

import java.util.Scanner;
public class Quiz0605 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = 0;
		int num = 1;
		while(!(num == 0)) {

			if(!(num==0)) {
				System.out.println("정수를 입력하세요");
				num = sc.nextInt();
				total += num;
			}				
		}
		System.out.printf("Total = %d", total);
		sc.close();
	}
}
