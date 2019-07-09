package chapter06;

import java.util.Scanner;

public class Quiz0602 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하시오(정수 입력)");
		int langScore = sc.nextInt();
		System.out.println("영어 점수를 입력하시오(정수 입력)");
		int engScore = sc.nextInt();
		System.out.println("수학 점수를 입력하시오(정수 입력)");
		int mathScore = sc.nextInt();

		int avr = ((langScore + engScore +mathScore)/3);
		
		if(avr >= 90) 
			System.out.println("평균 학점 : A");
		else if(avr >= 80) 
			System.out.println("평균 학점 : B");
		else if(avr >= 70)
			System.out.println("평균 학점 : C");
		else if(avr >= 50)
			System.out.println("평균 학점 : D");
		else
			System.out.println("평균 학점 : F");
		
		sc.close();
	}

}
