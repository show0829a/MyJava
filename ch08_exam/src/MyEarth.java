class ��� {
	
	String �̸�;
	int ����;
	int Ű;
	
//	���(){}; ������
	void �λ�() {
		System.out.println("�ȳ��ϼ���");
	}
}

public class MyEarth {

	public static void main(String[] args) {
		// '���'�̶� ���赵(class)�� �̿��� ���(��ü) �����
		// ����� --> ��ü�� �޸𸮿� ����
		// ��� --> ������ ���~
		��� man1 = new ���(); 
		man1.�̸� = "ȫ�浿";
		man1.���� = 20;
		man1.Ű = 170;
		
		System.out.println(man1.�̸�);
		man1.�λ�();
		
	}

}
