import java.util.Scanner;


public class FindNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str;
		while(true) {
			System.out.println("�Է��ϼ��� ");
			str = sc.next();
			
			char[] charAr = str.toCharArray();	//String�� char ������ �߶� �迭�� ����.
			int sum = 0;
			
			
			for(int i = 0 ; i < charAr.length; i++) {
				
				if(48 <= Integer.valueOf(charAr[i]) && Integer.valueOf(charAr[i]) <= 57) {
					sum +=( (int)charAr[i] - 48);		//ASCII �ڵ忡�� ���ڷ� ���
	
				}
				
			}
			System.out.println("�Էµ� ���ڿ��� ���� ��: "  + sum);
			System.out.println("��� �Ϸ��� �ƹ�Ű�� ��������. (���� : Q)");
			
			String key = sc.next();
			
			if(key.equalsIgnoreCase("q"))
				break;
			
		}
	}

}
