abstract class Unit {
	int HP;
	int MP;
	
	abstract void move();
	abstract void attack();
	
}

class Marine extends Unit {
	//�ڱ⸸�� Ư¡�� ���ַ� �����.
	Marine() {
		System.out.println("������ ������� ������");
	}
	void move() {
		System.out.println("�� ĭ �����̱�");	// Unit�� ���� ���
		System.out.println("�� �߷� �ȱ�"); 	// ������� �ٹ� ��
	}
	void attack() {
		System.out.println("��� HP 1 ���ҽ�Ű��");	//Unit�� ���� ���
		System.out.println("������ ���");	 		//������� �ٹ� ��
	}
}

class Zergling extends Unit {
	//�ڱ⸸�� Ư¡�� ���ַ� �����.
	Zergling() {
		System.out.println("���۸� ������");
	}
	void move() {
		System.out.println("�� ĭ �����̱�");	// Unit�� ���� ���
		System.out.println("�� �߷� �ȱ�"); 	// ���۸���� �ٹ� ��
	}
	void attack() {
		System.out.println("��� HP 1 ���ҽ�Ű��");	//Unit�� ���� ���
		System.out.println("�� �߷� ���");	 		//���۸���� �ٹ� ��
	}
}

public class Polymorphism4 {

	public static void main(String[] args) {
		Unit unit1 = new Marine();
		unit1.move();
		unit1.attack();
		
		Unit unit2 = new Zergling();
		unit2.move();
		unit2.attack();
	}

}
