class Box8<T> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}

public class B2_PrimitivesAndGeneric {

	public static void main(String[] args) {

		Box8<Integer> iBox = new Box8<Integer>();
		
		iBox.set(125); 			// ���� �ڽ� ����
		int num = iBox.get();	// ���� ��ڽ� ����
		
				
		System.out.println(num);
	}

}


// Ÿ�� ���ڷ� �⺻ �ڷ����� �� �� ����. int (X) : Integer(O)
// ���� Ŭ������ �ʿ��� ����!!!