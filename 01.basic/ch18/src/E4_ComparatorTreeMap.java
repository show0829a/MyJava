import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

class AgeComparator implements Comparator<Integer> {
	public int compare(Integer n1, Integer n2) {
		return n2.intValue() - n1.intValue();
	}
}

 class E4_ComparatorTreeMap {
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>(new AgeComparator());
		
		// Key-Value ��� ������ ����
		map.put(45, "Brown");
		map.put(37, "James");
		map.put(23, "Martin");
		
		// Key�� ��� �ִ� �÷��� �ν��Ͻ� ����
		Set<Integer> ks = map.keySet();
		
		// ��ü Key ���(for- each�� ���)	
		for(Integer n : ks)
			System.out.println(n.toString() + '\t');
		System.out.println();
		
		// ��ü Value ���(for- each�� ���)	
		for(Integer n : ks)
			System.out.println(map.get(n).toString() + '\t');
		System.out.println();
		
		// ��ü Value ���(�ݺ��� ���)	
				for(Iterator<Integer> itr = ks.iterator(); itr.hasNext();)
					System.out.println(map.get(itr.next()) + '\t');
				System.out.println();	
		
	}

}
