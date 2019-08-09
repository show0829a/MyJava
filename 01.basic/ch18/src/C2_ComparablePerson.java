import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
	private String name;
	private	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	@Override
	public String toString() {
		return name + " : " + age;
		
	}
	
	@Override
	public int compareTo(Person p) {
		//return this.age = p.age;
		return p.age - this.age;
	}
}
public class C2_ComparablePerson {

	public static void main(String[] args) {
		Set<Person> tree = new TreeSet<>();
		tree.add(new Person("Son", 37));
		tree.add(new Person("Hong", 53));
		tree.add(new Person("Jeon", 22));
		
		for(Person p : tree)
			System.out.println(p);
	}

}
