package chapter06;

import java.util.Scanner;
public class Quiz0606 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("�Է� Ƚ���� �Է��Ͻÿ�");
		int num = sc.nextInt();
		int inputNum = 0;
		int total = 0;
		
		double avr = 0;
		System.out.printf("�Էµ� ���ڴ� %d �Դϴ�\n",num);
	
		
		for(int i = 0; i < num; i++){
			System.out.printf("%d ��° ������ �Է��Ͻÿ�\n",i + 1);
			inputNum = sc.nextInt();
			total += inputNum;
			
		}
		
		avr = (double)total/num;
		System.out.printf("�Է¹��� ������ ����� %f �Դϴ�.", avr);
		
		sc.close();
	}

}
