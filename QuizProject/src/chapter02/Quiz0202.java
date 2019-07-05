package chapter02;
import java.util.Scanner;

public class Quiz0202 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int sqr = num * num;
		
		System.out.printf("%d ÀÇ Á¦°ö = %d \n", num, sqr);
		
		sc.close();
		
	}
}
