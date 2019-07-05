package chapter02;
import java.util.Scanner;
public class Quiz0205 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int mul = num1 * num2;
		
		int abValue = ((mul >= 0) ? (mul) : (-mul));
		
		System.out.printf("입력된 두 수의 곱의 절댓값은 %d 입니다. \n", abValue);
		sc.close();

	}

}
