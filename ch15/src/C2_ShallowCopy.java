class Point2 implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point2(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void showPosition() {
		System.out.printf("[%d, %d]", xPos, yPos);
		System.out.println();
		
	}
	
	public void changePos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
		
	}
}

class Rectangle2 implements Cloneable {
	public Point2 upperLeft;	// ���� ��� ��ǥ
	public Point2 lowerRight;	// ���� �ϴ� ��ǥ
	
	public Rectangle2(int x1, int y1, int x2, int y2) {
		upperLeft = new Point2(x1, y1);
		lowerRight = new Point2(x2, y2);
	}
	
	//��ǥ ������ ������
	public void changePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//���簢�� ��ǥ ���� ���
	public void showPosition() {
		System.out.println("���� ���: ");
		upperLeft.showPosition();
		
		System.out.println("���� �ϴ�: ");
		lowerRight.showPosition();
		System.out.println();
		
	}
	
}

public class C2_ShallowCopy {

	public static void main(String[] args) {
		Rectangle2 org = new Rectangle2(1, 1, 9, 9);
		Rectangle2 cpy;
		
		try {
			// �ν��Ͻ� ����
			cpy = (Rectangle2)org.clone();
			
			// �� �ν��Ͻ��� ��ǥ ������ ����
			org.changePos(2, 2, 7, 7);
			
			org.showPosition();
			cpy.showPosition();
			
			if(org.equals(cpy))
				System.out.println("aaaaa");
			else
				System.out.println("bbbbbb");
			
			if(org.lowerRight.equals(cpy.lowerRight))
				System.out.println("ccccc");
			else
				System.out.println("ddddd");
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
