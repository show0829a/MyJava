import java.util.LinkedList;
import java.util.List;

//
//enhanced for ���� ���

public class A3_LinkedListCollection {

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
		for(String s : list)
			System.out.print(s + "\t");
		System.out.println();
	}

}
