package chapter13_1;

import java.util.Scanner;

public class Quiz13_1_01 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� 5���� �Է��Ͻÿ�.");
		
		for(int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = Sum(arr);
		int min = Min(arr);
		int max = Max(arr);
		
		System.out.printf("�迭�� �ִ�, �ּ�, ���� %d, %d, %d �Դϴ�.", max, min, sum);
		sc.close();
	}

	public static int Max (int[] num) {
		int max = 0;
		for(int i = 0; i < 5; i++) {
			if(max < num[i])
				max = num[i];
			
		}	
		return max;			
	}
	
	public static int Min (int[] num) {
		int min = num[0];
		for(int i = 0; i < 5; i++) {
			if(min > num[i])
				min = num[i];
				
		}
		return min;
	}
	public static int Sum (int[] num) {
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			sum = sum + num[i];
		}
		return sum;
	}
}

