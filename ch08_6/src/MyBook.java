class Book {
	int price;
	String title;
	
	
	Book(String t, int p){
		title = t;
		price = p;
	}
	
	//���� ������
	Book(Book copy)
	{
		title = copy.title;
		price = copy.price;
	}
	
	void print() {
		System.out.println("��    �� : " + title);
		System.out.println("��    �� : " + price);
	}
}
public class MyBook {

	public static void main(String[] args) {
		Book book1 = new Book("�ڹ� ���α׷���", 10000);
		book1.print();
		
		Book book2 = new Book(book1);
		book2.title = "�ڹ� ����������";
		book2.print();

	}

}