package chapter13_1;

import java.util.Scanner;

public class Quiz13_1_01 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 5개를 입력하시오.");
		
		for(int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = Sum(arr);
		int min = Min(arr);
		int max = Max(arr);
		
		System.out.printf("배열의 최대, 최소, 합은 %d, %d, %d 입니다.", max, min, sum);
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

