class Point implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point(int x, int y) {
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

class Rectangle implements Cloneable {
	public Point upperLeft;	// ���� ��� ��ǥ
	public Point lowerRight;	// ���� �ϴ� ��ǥ
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		upperLeft = new Point(x1, y1);
		lowerRight = new Point(x2, y2);
	}
	
	//��ǥ ������ ������
	public void changePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Rectangle copy = (Rectangle)super.clone();
		
		copy.upperLeft = (Point)upperLeft.clone();
		copy.lowerRight = (Point)lowerRight.clone();
		
		return copy;
	
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

public class C3_DeepCopy {

	public static void main(String[] args) {
		Rectangle org = new Rectangle(1, 1, 9, 9);
		Rectangle cpy;
		
		try {
			// �ν��Ͻ� ����
			cpy = (Rectangle)org.clone();
			
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