interface Calculate4 {
	int cal(int a, int b); 	// �Ű����� ��, ��ȯ�� int
}
public class E3_TwoParamAndReturn {

	public static void main(String[] args) {
		Calculate4 c;
		
		c = (a, b) -> { return a + b;};
		//int num = c.cal(4,3); 	//�̿� ���� ���� ����� ���´�.
		System.out.println(c.cal(4, 3));

		c = (a, b) -> a + b;
		System.out.println(c.cal(4, 3));
	}

}
