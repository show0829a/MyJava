package chapter06;

import java.util.Scanner;

public class Quiz0602 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ������ �Է��Ͻÿ�(���� �Է�)");
		int langScore = sc.nextInt();
		System.out.println("���� ������ �Է��Ͻÿ�(���� �Է�)");
		int engScore = sc.nextInt();
		System.out.println("���� ������ �Է��Ͻÿ�(���� �Է�)");
		int mathScore = sc.nextInt();

		int avr = ((langScore + engScore +mathScore)/3);
		
		if(avr >= 90) 
			System.out.println("��� ���� : A");
		else if(avr >= 80) 
			System.out.println("��� ���� : B");
		else if(avr >= 70)
			System.out.println("��� ���� : C");
		else if(avr >= 50)
			System.out.println("��� ���� : D");
		else
			System.out.println("��� ���� : F");
		
		sc.close();
	}

}
