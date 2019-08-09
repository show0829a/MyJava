class Outer2 {
	private int num = 0;
	
	class Member {
	
			void add(int n) { num += n;}
			int get() { return num; }
		
	}
}

public class B1_MemberIner {

	public static void main(String[] args) {
		Outer2 o1 = new Outer2();
		Outer2 o2 = new Outer2();
		
		//o1 ������� �� �ν��Ͻ� ����
		Outer2.Member o1m1 = o1.new Member();
		Outer2.Member o1m2 = o1.new Member();
		
		//o2 ������� �� �ν��Ͻ� ����
		Outer2.Member o2m1 = o1.new Member();
		Outer2.Member o2m2 = o1.new Member();
		
		//o1 ������� ������ �� �ν��Ͻ��� �޼ҵ� ȣ��
		o1m1.add(5);
		System.out.println(o1m2.get());
		
		//o2 ������� ������ �� �ν��Ͻ��� �޼ҵ� ȣ��
		o2m1.add(7);
		System.out.println(o2m2.get());
	}

}
