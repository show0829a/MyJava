package chapter13_1;

import java.util.Scanner;

public class Quiz13_1_03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int[] arr = new int[10];

		int[] odd = new int[10];
		int[] even = new int[10];
		
		int oddIdx = 0;
		int evenIdx = 0;
		
		
		for(int i = 0; i<10; i++) {
			arr[i] = sc.nextInt();	
			if(arr[i]%2 == 1) {
				odd[oddIdx] = arr[i];
				oddIdx++;
			} else {
				even[evenIdx] = arr[i];
				evenIdx++;
			}
		}
		System.out.print("È¦¼ö : ");
		for(int i = 0; i < oddIdx; i++)
			if(i < oddIdx-1)
				System.out.print(odd[i] + ", ");
			else
				System.out.print(odd[i]);
	
		System.out.println();
		
		System.out.print("Â¦¼ö : ");
		for(int i = 0; i < evenIdx; i++)
			if(i < evenIdx-1)
				System.out.print(even[i] + ", ");
			else
				System.out.print(even[i]);
		
		sc.close();
	}

}

