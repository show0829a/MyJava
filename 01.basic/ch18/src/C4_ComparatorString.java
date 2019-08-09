import java.util.Comparator;
import java.util.TreeSet;

class StringComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
	// ���̰� ������ �����ʹ� �߰����� �ʴ´�.
	return s1.length() - s2.length();
	}
}
public class C4_ComparatorString {

	public static void main(String[] args) {
		//TreeSet<String> tree = new TreeSet<>();
		TreeSet<String> tree = new TreeSet<>(new StringComparator());
		tree.add("Box");
		tree.add("Rabbit");
		tree.add("Robot1");
		tree.add("Robot");
		
		for(String s : tree)
			System.out.print(s.toString() + '\t');
		System.out.println();
	}

}
