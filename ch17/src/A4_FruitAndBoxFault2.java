class Apple4 {
	public String toString() {
		return "I am an apple.";
		
	}
}

class Orange4 {
	public String toString() {
		return "I am an orange.";
		
	}
}


class Box4 {
	private Object ob;
	
	public void set(Object o) {
		ob = o;
	}
	
	public Object get() {
		return ob;
	}
}

public class A4_FruitAndBoxFault2 {

	public static void main(String[] args) {
		Box3 aBox = new Box3();
		Box3 oBox = new Box3();
		
		
		//������ �ڽ��� ���� ���ϱ� ?
		aBox.set("Apple");
		oBox.set("Orange");
		
		System.out.println(aBox.get());
		System.out.println(oBox.get());

	}

}
