import java.util.Iterator;
import java.util.LinkedList;

public class A7_PrimitiveCollection {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		//���� �������� ���� �ڽ�
		list.add(10);
		list.add(20);
		list.add(30);
		
		int n;
		for(Iterator<Integer> itr = list.iterator(); itr.hasNext();) {
			n = itr.next();		//���� ��ڽ�
			System.out.print(n + "\t");
			
		}
		
		System.out.println();
	}

}
