class MyText2 implements Cloneable {
	private String name;
	
	public MyText2(String name) {
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

class MyBook2 implements Cloneable {
	public MyText2 mt;
	
	public MyBook2(String str) {
		this.mt = new MyText2(str);
	}
	
	// ������ ������
	public void changeText(String str) {
		mt.setName(str);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		//Object Ŭ������ clone �޼ҵ� ȣ�� ����� ����
		MyBook2 copy = (MyBook2)super.clone();
		
		//���� ������ ���·� ���纻�� ����
		copy.mt = (MyText2)mt.clone();
		
		//�ϼ��� ���纻�� ������ ��ȯ
		return copy;
	}
	
	//���� ���
	public void showText() {
		System.out.println(mt.getName());
	}
}

public class C3_DeepCopy2 {

	public static void main(String[] args) {
		MyBook2 org = new MyBook2("ȫ�浿");
		MyBook2 cpy;
		
		try {
			// �ν��Ͻ� ����
			cpy = (MyBook2)org.clone();
			
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
