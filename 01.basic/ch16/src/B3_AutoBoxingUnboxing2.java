
public class B3_AutoBoxingUnboxing2 {

	public static void main(String[] args) {
		Integer num = 10;
		
		num++;		// new Integer(num.intValue() + 1);
					// <-- ���� �ڽ̰� ���� ��ڽ� ���ÿ� ����.\
		System.out.println(num);
		
		num += 3;	// new Integer(num.intValue() + 3);
		System.out.println(num);
		
		int r = num + 5;			// ���� ��ڽ� ����
		Integer rObj = num - 5;		// ���� ��ڽ� ����
		
		System.out.println(r);
		System.out.println(rObj);
	}

}
