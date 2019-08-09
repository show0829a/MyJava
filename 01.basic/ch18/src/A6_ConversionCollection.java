import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A6_ConversionCollection {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
		list = new ArrayList<>(list);
		// ArrayList<E> �ν��Ͻ��� ��ȯ
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)
			System.out.println(itr.next() + '\t');
		System.out.println();
		
		// ArrayList<E>�� LinkedList<E>�� ��ȯ
		list = new LinkedList<>(list);
		
		// LinkedList<E> �ν��Ͻ��� ��ȯ
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)
			System.out.println(itr.next() + '\t');
		System.out.println();
	}

}
