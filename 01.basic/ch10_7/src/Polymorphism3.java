abstract class Human {
	abstract void print();
}

class Man extends Human {
	void print() {
		System.out.println("���� ����");
	}
}

class Woman extends Human{
	void print() {
		System.out.println("���� ����");
	}
}

public class Polymorphism3 {

	public static Human humanCreate(int kind) {
		if (kind == 1) {
			return new Man();
		} else {
			return new Woman();
		}
	}
	
	public static void main(String[] args) {
		// ������ �ְ� �������� �������� �߿����� �ʰ�
		// �� ������ �ΰ� ��ü�� ����Ʈ ��ɸ� �� ���̴�.
		// �����̸� ���ھְ� ���� ����� �� ���̰�,
		// �����̸� ���ھְ� ���� ����� �� ���̴�.
		
		Human h1 = humanCreate(1);
		h1.print();
		
		Human h2 = humanCreate(2);
		h2.print();
		
	}

}

