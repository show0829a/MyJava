package chapter06;

import java.util.Scanner;

public class Quiz0601 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("���� �� ���� �Է��Ͻÿ�");
		System.out.println("ù ��° ���� : ");
		int num1 = sc.nextInt();
		
		System.out.println("�� ��° ���� : ");
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
		//�� ���� ���̴� ����� ������ �� ���� -�̴� �����ϰ� ���� x
		System.out.printf("�� ������ ���̴� %d �Դϴ�.", result);
		// int result2 = (num1 > num2)? num1 -num2 : num2 - num1;
		// int result3 = (result > 0)? result : result*-1;
		sc.close();
	}

}
