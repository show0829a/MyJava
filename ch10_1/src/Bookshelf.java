// Bookshelf
class Book {
	String title;
	String genre;
	
	void printBook() {
		System.out.println("��  �� : " + title);
		System.out.println("��  �� : " + genre);
	}
}

class Novel extends Book {
	String writer;
	
	void pringNov() {
		printBook();
		System.out.println("��  �� : " + writer);
	}
}

class Magazine extends Book { 
	int day;
	
	void printMag() {
		printBook();
		System.out.println("�߸��� : " + day + "��");
	}
}
class Bookshelf {

	public static void main(String[] args) {
		Novel nov = new Novel();
		nov.title = "�����";
		nov.genre = "��������";
		nov.writer = "�踸��";
		
		Magazine mag = new Magazine();
		mag.title = "���� �ڹ� �׸�å";
		mag.genre = "��ǻ��";
		mag.day = 20;
		
		nov.pringNov();
		System.out.println();
		mag.printMag();
	}

}
