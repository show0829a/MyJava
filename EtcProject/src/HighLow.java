import java.util.Scanner;
import java.util.Random;

public class HighLow {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		while(true) {
			System.out.println("���� ���� 0 ���� 100 ������ �� �߿� �ϳ��� �����ϰڽ��ϴ�.");	
			System.out.println("����� �� ���ڸ� 6ȸ �ȿ� ���߽ø� �˴ϴ�.");
			
			int cNum;
			int cnt;
			int hNum;
		
			
			cNum = r.nextInt(101);
			cnt = 5;
				
				while(true) {
					
					System.out.println("���̶�� �����մϱ�?<0 to 100> ");
					hNum = s.nextInt();
					
					if(hNum == cNum || cnt == 0) {
						if(hNum == cNum) {
							System.out.println(hNum + " �� �����Դϴ�.");
							cnt = 0;
						} else 
							System.out.println("Ʋ�Ƚ��ϴ�.");
						break;
					} else if(hNum > cNum) {
						System.out.println(hNum + " �� ���� ���� ���ں��� Ů�ϴ�.");						
						System.out.printf("[ %d ]�� ��ȸ�� ���ҽ��ϴ�.\n", cnt );
						cnt--;
					} else {
						System.out.println(hNum + " �� ���� ���� ���ں��� �۽��ϴ�.");						
						System.out.printf("[ %d ]�� ��ȸ�� ���ҽ��ϴ�.\n", cnt );
						cnt--;
						
						
					}
				}	
			if(cnt == 0) {
				System.out.println("������ �� �����Ͻðڽ��ϱ� ? (y/n)");
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
		



