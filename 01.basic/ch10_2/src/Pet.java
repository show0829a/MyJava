class Animal
{
	String name;
	int age;
	
	void printPet() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		
	}
}

class Cat extends Animal {
	String variety;
	
	void printPet() {
		super.printPet();
		System.out.println("���� : " + variety);
	}
	
}
class Pet {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.name = "�����";
		cat.age = 5;
		cat.variety = "�丣�þ�";
		cat.printPet();

	}

}
