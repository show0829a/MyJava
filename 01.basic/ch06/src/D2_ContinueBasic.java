
public class D2_ContinueBasic {
	public static void main(String[] args) {
		int num = 0;
		int count = 0;
		
		while((num++) < 100) {
			if(((num % 5) != 0) || ((num %7) != 0))
				continue;	// 5�� 7�� ��� �ƴ϶�� ������ �ǳʶ�� ���� �̵�
			
			count++;					//5�� 7�� ����� ��쿡�� ����
			System.out.println(num);	//5�� 7�� ����� ��쿡�� ����
		}
		System.out.println("count: " + count);
	}
}
