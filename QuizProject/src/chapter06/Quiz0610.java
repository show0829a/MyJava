package chapter06;

import java.util.Scanner;
public class Quiz0610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5���� ������ �Է��Ͻÿ�(1 �̻�)");
		int num = 0;
		int result = 0;
		
		for(int i = 0; i < 5;) {
			num = sc.nextInt();
			
			if(1 > num) {
				System.out.println("�ٽ� �Է����ּ���");
			
				
			} else {
				result += num;
				i++;
			}
		}
		System.out.printf("5�� ������ ���� %d �Դϴ�.",result);
		sc.close();
	}

}
