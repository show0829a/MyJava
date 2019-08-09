//Ãß»ó Å¬·¡½º
abstract class Animal {
	int age;
	abstract void cry();
}

class Dog extends Animal {
	void cry() {
		System.out.println("¸Û¸Û");
	}
}
//Ãß»ó ¸Þ¼Òµå Overriding

class Cat extends Animal {
	void cry() {
		System.out.println("¾ß¿Ë");
	}

	
}

public class AbstractClassEx {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.cry();
		
		Cat cat = new Cat();
		cat.cry();

	}

}
