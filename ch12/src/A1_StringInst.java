
public class A1_StringInst {
	
	public static void showString(String str) {
		System.out.println(str);
		System.out.println(str.length());
	}
	
	public static void main(String[] args) {
		// �� �� String �ν��Ͻ��� �������� �̾�����
		// �� ��� �ν��Ͻ��� ���� ���� ��ȯ�ȴ�.
		// Debug ���� id ���캸��
		String str1 = new String("Simple String");
		String str2 = "The Best String";
		String str3 = "The Best String";
		
		System.out.println(str1);
		System.out.println(str1.length());
		
		System.out.println();	// ���� : �޼ҵ� �����ε�
		
		System.out.println(str2);
		System.out.println(str2.length());
		
		System.out.println();
		
		showString(str3);
	}

}
