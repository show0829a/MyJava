package chapter06;

import java.util.Scanner;
public class Quiz0612 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �ٸ� �� ���� ������ �Է��Ͻÿ�");
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int diff = (((num1-num2)>0)? num1-num2: -(num1-num2));
		int result = 0;
			
		for(int i = 0; i < diff + 1; i++) {
			if(num1 > num2)
				result += (num2 + i);
				
			else
				result += (num1 + i);
		}
		System.out.println("�� ���� ������ ���� ��� ���� ���� "+result+"�Դϴ�.");
		sc.close();
	}
}
