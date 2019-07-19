import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StrComp implements Comparator<String> {
	
	@Override
	public int compare(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);
	}
}

public class F3_StringComparator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Box");
		list.add("Robot");
		list.add("Apple");
		
		StrComp cmp = new StrComp();	//���İ� Ž���� ����
		
		Collections.sort(list, cmp); 	//����
		int idx = Collections.binarySearch(list, "Robot", cmp);	//Ž��	
		
		System.out.println(list.get(idx)); 		//Ž�� ��� ���
		
		
		
	}
	
}
