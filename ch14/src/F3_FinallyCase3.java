import java.util.Scanner;

public class F3_FinallyCase3 {

	public static void main(String[] args) {
	
		int num = 0;
		Scanner s = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		
		try {
			a = s.nextInt();
			b = s.nextInt();
			num = a / b;
		} catch(Exception e) {
			//e.printStackTrace();
		} finally {
			//�����ͺ��̽� ���� ���� �� ������ �ؾ� �� ��
			num = num + 1;
		}
		
		System.out.println(num);
	}

}
