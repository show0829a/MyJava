class MyText implements Cloneable {
	private String name;
	
	public MyText(String name) {
		this.name = name;	
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class MyBook implements Cloneable {
	public MyText mt;
	
	public MyBook(String str) {
		this.mt = new MyText(str);
	}
	
	// ������ ������
	public void changeText(String str) {
		mt.setName(str);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//���� ���
	public void showText() {
		System.out.println(mt.getName());
	}
}

public class C2_ShallowCopy2 {

	public static void main(String[] args) {
		MyBook org = new MyBook("ȫ�浿");
		MyBook cpy;
		
		try {
			// �ν��Ͻ� ����
			cpy = (MyBook)org.clone();
			
			// �� �ν��Ͻ��� ��ǥ ������ ����
			org.changeText("����ġ");
			
			// �� ��ü�� ���� ���� ���� �Ǿ����� Ȯ��
			org.showText();
			cpy.showText();
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
