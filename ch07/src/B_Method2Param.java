
public class B_Method2Param {

	public static void main(String[] args) {
		double myHeight = 175.9;
		
		hiEveryOne(12,12.5);
		hiEveryOne(13,myHeight);
		
		byEveryOne();
	}
	
	public static void hiEveryOne(int age, double height) {
		System.out.println("�� ���̴� "+ age +"�� �Դϴ�.");
		System.out.println("���� Ű�� "+ height +"cm �Դϴ�.");
	}
	
	public static void byEveryOne() {
		System.out.println("������ �˰ڽ��ϴ�.");
	}
}
