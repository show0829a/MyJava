import java.util.LinkedList;
import java.util.List;

public class A2_LinkedListCollection {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		
		//�ν��Ͻ� ���� : ���� ����. �ߺ� ���.
		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		
		//�ν��Ͻ� ����
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + "\t");
		System.out.println();
		
		//ù��° �ν��Ͻ� ����
		list.remove(0);
		
		//���� �� �ν��Ͻ� ����
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + "\t");
		System.out.println();
	}

}
