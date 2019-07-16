class Person {
	String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("destroyed: " + name);
	}
}
public class A_ObjectFinalize {

	public static void main(String[] args) {
		Person p1 = new Person("����ġ");
		Person p2 = new Person("ȫ�浿");
		Person p3 = new Person("�Ӳ���");
		
		p1 = null;	// ���� ����� ������ �÷����� ������� ����
		p2 = null;
		p3 = null;
		
		System.gc();
		System.runFinalization();
		
		System.out.println("end of program");
		
	}

}
