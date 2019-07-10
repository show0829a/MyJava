import java.util.Scanner;
import java.util.Random;

public class HighLow {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		while(true) {
			System.out.println("나는 지금 0 부터 100 사이의 값 중에 하나를 생각하겠습니다.");	
			System.out.println("당신은 그 숫자를 6회 안에 맞추시면 됩니다.");
			
			int cNum;
			int cnt;
			int hNum;
		
			
			cNum = r.nextInt(101);
			cnt = 5;
				
				while(true) {
					
					System.out.println("몇이라고 생각합니까?<0 to 100> ");
					hNum = s.nextInt();
					
					if(hNum == cNum || cnt == 0) {
						if(hNum == cNum) {
							System.out.println(hNum + " 는 정답입니다.");
							cnt = 0;
						} else 
							System.out.println("틀렸습니다.");
						break;
					} else if(hNum > cNum) {
						System.out.println(hNum + " 는 제가 정한 숫자보다 큽니다.");						
						System.out.printf("[ %d ]의 기회가 남았습니다.\n", cnt );
						cnt--;
					} else {
						System.out.println(hNum + " 는 제가 정한 숫자보다 작습니다.");						
						System.out.printf("[ %d ]의 기회가 남았습니다.\n", cnt );
						cnt--;
						
						
					}
				}	
			if(cnt == 0) {
				System.out.println("게임을 더 진행하시겠습니까 ? (y/n)");
				String str = s.next();
				if(!str.equalsIgnoreCase("y")) {
					System.out.println("Good bye ~");
					break;
				}
				
			}
	
		}
	s.close();
	}
}
		



