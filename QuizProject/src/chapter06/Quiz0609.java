package chapter06;

import java.util.Scanner;
public class Quiz0609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2~9���� �ϳ��� ������ �Է��Ͻÿ�");
		int i = sc.nextInt();

		for(int j = 9; j > 0; j--) {
			System.out.printf("%d * %d = %d\n",i,j,i*j);
		}
		sc.close();
	}

}
