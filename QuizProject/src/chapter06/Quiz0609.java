package chapter06;

import java.util.Scanner;
public class Quiz0609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2~9까지 하나의 정수를 입력하시오");
		int i = sc.nextInt();

		for(int j = 9; j > 0; j--) {
			System.out.printf("%d * %d = %d\n",i,j,i*j);
		}
		sc.close();
	}

}
