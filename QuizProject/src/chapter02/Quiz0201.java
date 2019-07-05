package chapter02;
import java.util.Scanner;

public class Quiz0201 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 개의 숫자를 입력하셔요.");
		System.out.println("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두 번째 숫자(0 제외) : ");
		int num2 = sc.nextInt();
		
		//int sum = num1 + num2;
		//System.out.printf("%d + %d = %d \n",num1, num2, sum);
		
		System.out.printf("%d + %d = %d\n" , num1, num2, num1 + num2);
		System.out.printf("%d - %d = %d\n" , num1, num2, num1 - num2);
		System.out.printf("%d * %d = %d\n" , num1, num2, num1 * num2);
		System.out.printf("%d / %d = %d\n" , num1, num2, num1 / num2);
		sc.close();
	}

}
