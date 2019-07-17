class Apple5 {
	public String toString() {
		return "I am an apple.";
		
	}
}

class Orange5 {
	public String toString() {
		return "I am an orange.";
		
	}
}


class Box5<T> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}
public class A5_FruitAndBox2_Generic {

	public static void main(String[] args) {
		Box5<Apple5> aBox = new Box5<Apple5>();
		Box5<Orange5> oBox = new Box5<Orange5>();
		
		//������ �ڽ��� ��´�.
		aBox.set(new Apple5());
		oBox.set(new Orange5());
		//�ڽ����� ������ �����µ� �� ��ȯ ���� �ʴ´�.
		Apple5 ap = (Apple5)aBox.get();
		Orange5 og = (Orange5)oBox.get();
		
		System.out.println(ap);
		System.out.println(og);
	}

}
