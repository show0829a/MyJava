package chapter13_1;

import java.util.Scanner;

public class Quiz13_1_04 {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int[] arr = new int[10];
		
		int oddIdx = 0;
		int evenIdx = 9;
		int[] oddEvenArr = new int[10];
		
		for(int i = 0; i<10; i++) {
			arr[i] = sc.nextInt();	
			if(arr[i]%2 == 1) {
				oddEvenArr[oddIdx] = arr[i];
				oddIdx++;
			} else {
				oddEvenArr[evenIdx] = arr[i];
				evenIdx--;
			}
		}
		
		for(int i = 0; i<10; i++) {
			System.out.print(oddEvenArr[i] + " ");
		}
	
		sc.close();
	}
}
