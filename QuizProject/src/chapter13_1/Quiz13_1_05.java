package chapter13_1;

import java.util.Scanner;

public class Quiz13_1_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		char[] cArr = str.toCharArray();
		int cnt = 0;
		
		for(int i = 0; i < cArr.length/2; i++) {
			if(cArr[i] == cArr[cArr.length-1 - i])
				cnt++;
		}
		
		if(cnt == cArr.length/2)
			System.out.println("회문입니다.");
		else
			System.out.println("회문이 아닙니다.");
		
		sc.close();
	}

}
