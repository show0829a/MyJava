class Book {
	String title;
	String author;
	int money;
	
}
public class MyBook {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.title = "�ڹ� ���α׷���";
		book1.author = "ȫ�浿";
		book1.money = 15000;
		
		System.out.println(book1.title + " : " + book1.author + " : " + book1.money);

	}

}
