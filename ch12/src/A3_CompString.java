
public class A3_CompString {

	public static void main(String[] args) {
		String st1 = "Apple";	//Apple, Apple
		String st2 = "Apple";	//apple, Banana
		int cmp;
		
		//�ν��Ͻ��� ���� ��
		if(st1.contentEquals(st2))
			System.out.println("�� ���ڿ��� �����ϴ�.");
		else
			System.out.println("�� ���ڿ��� �ٸ��ϴ�.");
		
		cmp = st1.compareTo(st2);
		
		if(cmp == 0)
			System.out.println("�� ���ڿ��� ��ġ�մϴ�.");
		else if (cmp < 0)
			System.out.println("������ �տ� ��ġ�ϴ� ����: " + st1);
		else
			System.out.println("������ �տ� ��ġ�ϴ� ����: " + st2);
	
		if(st1.compareToIgnoreCase(st2) == 0)	// ��ҹ��� ���� X
			System.out.println("�� ���ڿ��� �����ϴ�.");
		else
			System.out.println("�� ���ڿ��� �ٸ��ϴ�.");
	
	}
	
	

}
