package chapter06;

import java.util.Scanner;
public class Quiz0606 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("입력 횟수를 입력하시오");
		int num = sc.nextInt();
		int inputNum = 0;
		int total = 0;
		
		double dAvr = 0;	//변수명에 double 타입이라는 것을 명시해주면 좋다.
		System.out.printf("입력된 숫자는 %d 입니다\n",num);
	
		
		for(int i = 0; i < num; i++){
			System.out.printf("%d 번째 정수를 입력하시오\n",i + 1);
			inputNum = sc.nextInt();
			total += inputNum;
			
		}
		
		dAvr = (double)total/num;
		System.out.printf("입력받은 숫자의 평균은 %f 입니다.", dAvr);
		
		sc.close();
	}

}
