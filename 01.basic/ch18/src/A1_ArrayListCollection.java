import java.util.ArrayList;
import java.util.List;

public class A1_ArrayListCollection {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		//�ν��Ͻ� ���� : ���� ����. �ߺ� ���.
		list.add("Toy");
		list.add("box");
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

