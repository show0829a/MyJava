import java.util.Scanner;


public class FindNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str;
		while(true) {
			System.out.println("입력하세요 ");
			str = sc.next();
			
			char[] charAr = str.toCharArray();	//String을 char 단위로 잘라서 배열에 저장.
			int sum = 0;
			
			
			for(int i = 0 ; i < charAr.length; i++) {
				
				if(48 <= Integer.valueOf(charAr[i]) && Integer.valueOf(charAr[i]) <= 57) {
					sum +=( (int)charAr[i] - 48);		//ASCII 코드에서 숫자로 출력
	
				}
				
			}
			System.out.println("입력된 문자열의 숫자 합: "  + sum);
			System.out.println("계속 하려면 아무키나 누르세요. (종료 : Q)");
			
			String key = sc.next();
			
			if(key.equalsIgnoreCase("q"))
				break;
			
		}
	}

}
