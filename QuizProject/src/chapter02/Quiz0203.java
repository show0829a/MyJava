package chapter02;
import java.util.Scanner;

public class Quiz0203 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int portion = num1/num2;
		int remainder = num1%num2;
		
		System.out.printf("%d ������ %d �� ���� %d �Դϴ� \n", num1, num2, portion);
		System.out.printf("%d ������ %d �� �������� %d �Դϴ�", num1, num2, remainder);
		
		sc.close();
	}
}
