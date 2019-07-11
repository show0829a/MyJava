import java.util.Scanner;

public class MindReader {

	public static void main(String[] args) {
		System.out.println("0 부터 100 사이의 값 중에 하나를 생각하세요.");
		System.out.println("제(컴)가 제시한 숫자가 생각한 수자보다 크면 h를 입력하세요.");
		System.out.println("제(컴)가 제시한 숫자가 생각한 수자보다 작으면 l를 입력하세요.");
		System.out.println("제(컴)가 숫자를 맞췄다면 y를 입력해 주세요.");
		
		Scanner sc = new Scanner(System.in);
		boolean gg = true;
		String key;
		int cNum = 50;
		int hNum = 101;
		int lNum = 0;
		int cnt = 0;
		
		
		
		while(gg) {
			
			System.out.println("당신이 선택한 숫자는 " + cNum + "입니까 ?");
			++cnt;
			key = sc.next();
			
			switch(key) {
				case "H":	
				case "h":
				{	
					hNum = cNum;
					cNum = (hNum+lNum)/2;
					break;
				}
				case "L":
				case "l":
				{
					lNum = cNum;
					cNum = (lNum+hNum)/2;
					break;
				} 
				case "Y":
				case "y":
				{
					System.out.println("정답입니다. [" + cnt + "회차]");
					System.out.println("Good Bye ~");
					gg = false;
					break;
				}
				default :
				{
					System.out.println("다시 입력해주세요");
					--cnt;
				}
								
			}
		}
	sc.close();
	}

}
