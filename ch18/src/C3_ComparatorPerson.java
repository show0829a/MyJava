import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person2 implements Comparable<Person2> {
	private String name;
	int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	@Override
	public String toString() {
		return name + " : " + age;
		
	}
	
	@Override
	public int compareTo(Person2 p) {
		//���̰� ������ �����ʹ� �߰����� �ʴ´�.
		return p.age - this.age; 
	}
}

class PersonComparator implements Comparator<Person2>{
	public int compare(Person2 p1, Person2 p2) {
		return p2.age - p1.age;
	}
}
public class C3_ComparatorPerson {

	public static void main(String[] args) {
		//Set<Person2> tree = new TreeSet<>();
		Set<Person2> tree = new TreeSet<>(new PersonComparator());
		tree.add(new Person2("Yoon", 37));
		tree.add(new Person2("Hong", 53));
		tree.add(new Person2("ȫ�浿", 22));
		tree.add(new Person2("Park", 22));
		
		for(Person2 p : tree)
			System.out.println(p);
	}

}
