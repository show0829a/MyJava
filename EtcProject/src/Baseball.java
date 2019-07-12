import java.util.Random;
import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		while(true) {
			int cNum1 = rd.nextInt(10);
			int cNum2 = rd.nextInt(10);
			int cNum3 = rd.nextInt(10);
			int cnt = 1;
			
			
			
			if(cNum1 != cNum2 && cNum2 != cNum3 && cNum3 != cNum1) {
				
				System.out.println("정답은 " + cNum1 + cNum2 + cNum3);
				System.out.println("숫자로 하는 야구게임 시작");
				while(true) {
					System.out.println("세자리 숫자를 입력하세요.(" + cnt + "회)");
					int hNum = sc.nextInt();
					int hNum1 = hNum / 100;
					int hNum2 = (hNum/10) % 10;
					int hNum3 = hNum % 10;
					
					System.out.println(hNum1 + ":" + hNum2 + ":" + hNum3);
					
					
					int strike = 0;
					int ball = 0;
												
					if(hNum1 == cNum1) 
						strike = strike + 1;
					 else if(hNum1 == cNum2 || hNum1 == cNum3)
						ball = ball + 1;					
											
					if(hNum2 == cNum2) 
						strike = strike + 1;
					else if(hNum2 == cNum1 || hNum2 == cNum3) 
							ball = ball + 1;
										
					if(hNum3 == cNum3) 
						strike = strike + 1;
					else if(hNum3 == cNum1 || hNum3 == cNum2)
						ball = ball + 1;
					
					System.out.println(strike + " Strike   " + ball + " Ball");
					cnt ++;
					
					if(strike == 3) {
						System.out.println("You Win!!!");
						break;
					} else {
						strike = 0;
						ball = 0;
					}								
					
				}
				break;
			}
			sc.close();
		}
	}

}
