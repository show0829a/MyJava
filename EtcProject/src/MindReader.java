import java.util.Scanner;

public class MindReader {

	public static void main(String[] args) {
		System.out.println("0 ���� 100 ������ �� �߿� �ϳ��� �����ϼ���.");
		System.out.println("��(��)�� ������ ���ڰ� ������ ���ں��� ũ�� h�� �Է��ϼ���.");
		System.out.println("��(��)�� ������ ���ڰ� ������ ���ں��� ������ l�� �Է��ϼ���.");
		System.out.println("��(��)�� ���ڸ� ����ٸ� y�� �Է��� �ּ���.");
		
		Scanner sc = new Scanner(System.in);
		boolean gg = true;
		String key;
		int cNum = 50;
		int hNum = 101;
		int lNum = 0;
		int cnt = 0;
		
		
		
		while(gg) {
			
			System.out.println("����� ������ ���ڴ� " + cNum + "�Դϱ� ?");
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
					System.out.println("�����Դϴ�. [" + cnt + "ȸ��]");
					System.out.println("Good Bye ~");
					gg = false;
					break;
				}
				default :
				{
					System.out.println("�ٽ� �Է����ּ���");
					--cnt;
				}
								
			}
		}
	sc.close();
	}

}
