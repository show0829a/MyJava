package chapter06;

import java.util.Scanner;
public class Quiz0606 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("�Է� Ƚ���� �Է��Ͻÿ�");
		int num = sc.nextInt();
		int inputNum = 0;
		int total = 0;
		
		double dAvr = 0;	//������ double Ÿ���̶�� ���� ������ָ� ����.
		System.out.printf("�Էµ� ���ڴ� %d �Դϴ�\n",num);
	
		
		for(int i = 0; i < num; i++){
			System.out.printf("%d ��° ������ �Է��Ͻÿ�\n",i + 1);
			inputNum = sc.nextInt();
			total += inputNum;
			
		}
		
		dAvr = (double)total/num;
		System.out.printf("�Է¹��� ������ ����� %f �Դϴ�.", dAvr);
		
		sc.close();
	}

}
