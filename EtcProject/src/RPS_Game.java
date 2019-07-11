import java.util.Random;
import java.util.Scanner;

public class RPS_Game {

	static int gameResult = 1;
	
	public static void main(String[] args) {
		
		int hNum;
		int cNum;
		
		
		Scanner sc = new Scanner(System.in);
		
		Random computer = new Random();
		
		while(gameResult != 0) {
			System.out.println("무엇을 내겠습니까 ? (1:가위 2:바위 3:보 0:종료)");
			hNum = sc.nextInt();
			cNum = computer.nextInt(3) + 1;
			RPS(hNum,cNum);
			
			
		}
		sc.close();
	}
	
	static void RPS(int num1, int num2) {
		switch(num1) {
			case 0 :
			{
				System.out.println("게임을 종료하겠습니다.");
				gameResult = 0;			
				break;
			}
			case 1 : 
			{
				if(num2 == 1) {
					System.out.println("사용자: " + "바위" + "컴퓨터: " + "바위" );
					System.out.println("비겼습니다");
				} else if (num2 == 2) {
					System.out.println("사용자: " + "바위" + "컴퓨터: " + "가위" );
					System.out.println("이겼습니다");				
				}else {
					System.out.println("사용자: " + "바위" + "컴퓨터: " + "보" );
					System.out.println("졌습니다");
				}
				break;
			} 
			case 2 : 
			{
				if(num2 == 1) {
					System.out.println("사용자: " + "가위" + "컴퓨터: " + "바위" );
					System.out.println("졌습니다");
				} else if (num2 == 2) {
					System.out.println("사용자: " + "가위" + "컴퓨터: " + "가위" );
					System.out.println("비겼습니다");
				}
				else {
					System.out.println("사용자: " + "가위" + "컴퓨터: " + "보" );
					System.out.println("이겼습니다");
				}
				break;
			} 
			case 3 : 
			{
				if(num2 == 1) {
					System.out.println("사용자: " + "보" + "컴퓨터: " + "바위" );
					System.out.println("이겼습니다");
				}
					else if (num2 == 2) {
					System.out.println("사용자: " + "보" + "컴퓨터: " + "가위" );
					System.out.println("졌습니다");
				} else {
					System.out.println("사용자: " + "보" + "컴퓨터: " + "보" );
					System.out.println("비겼습니다");
				}
				break;
			} 
			default : 		
				System.out.println("다시 입력하세요");
		}	
	}

}
//RPS 부분 로직을 표현할때 절대값이나 + 로 비교해서 할수 있다. 해보기
