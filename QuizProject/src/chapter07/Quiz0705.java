package chapter07;

import java.util.Scanner;

public class Quiz0705 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("ù ��° ������ �Է��Ͻÿ�");
			int num1 = sc.nextInt();
			System.out.println("�� ��° ������ �Է��Ͻÿ�");
			int num2 = sc.nextInt();
		
			System.out.println("�Է��� �� ���� ������ ���Ͻÿ�(1 : +, 2 : -, 3 : *, 4 : / )");
			int oPerator = sc.nextInt();
		
			if ((oPerator == 1) || (oPerator == 2) || (oPerator == 3) || (oPerator == 4)) {
				
				System.out.println("���� ����� " + operator(num1,num2,oPerator) + "�Դϴ�.");
				break;
			} else
				System.out.println("���� �ٽ� �Է��ϼ���");
		
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
