package chapter02;
import java.util.Scanner;
public class Quiz0205 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int mul = num1 * num2;
		
		int abValue = ((mul >= 0) ? (mul) : (-mul));
		
		System.out.printf("�Էµ� �� ���� ���� ������ %d �Դϴ�. \n", abValue);
		sc.close();

	}

}
