import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Contact {
	
	private String name;
	private String phNumber;
	private String email;
	
	public Contact (String name, String phNumber){
		this.name = name;
		this.phNumber = phNumber;
		this.email = null;
	}
	
	public Contact (String name, String phNumber, String email){
		this.name = name;
		this.phNumber = phNumber;
		this.email = email;
	}
	
	public void showBook(Contact contact) {
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ��ȣ : " + phNumber);
		System.out.println("e-mail : " + email);
		System.out.println("----------------------------------------------------------------");
	}
}

class Function {
	
	Contact ct;
	HashMap<String, Contact> map = new HashMap<>();
	Set<String> ks = map.keySet();
	
	public void inputData(){
		
		System.out.println("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.println("��ȭ��ȣ : ");
		String phNumber = MenuViewer.sc.nextLine();
		System.out.println("e-mail : ");
		
		String email = MenuViewer.sc.nextLine();
		
		if(email != null)
			ct = new Contact(name, phNumber, email);
		else
			ct = new Contact(name, phNumber);
		
		map.put(name, ct);
		
		ct.showBook(map.get(name));
	}
	
	public void serchData() {
		
		
		System.out.println("�˻��� ��ȣ�� �̸� : ");
		String name = MenuViewer.sc.nextLine();
		try {
			ct.showBook(map.get(name));
		} catch (Exception e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}
	
	public void removeData() {
		System.out.println("������ ��ȣ�� �̸�");
		String name = MenuViewer.sc.nextLine();
		map.remove(name);
	}
}

class MenuViewer{
	public static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("���ϴ� ����� �����ϼ���");
		System.out.println("1. ��ȭ��ȣ ����, 2. ��ȭ��ȣ ��ȸ, 3. ��ȭ��ȣ ����, 4. ����");
		System.out.println("���� : ");
		System.out.println("----------------------------------------------------------------");
	}
}

public class PhoneBook {

	public static void main(String[] args) {
		int selNum;
		Function function = new Function();
		
		while(true) {
			MenuViewer.showMenu();
			selNum = MenuViewer.sc.nextInt();
			MenuViewer.sc.nextLine();
			
			
			switch(selNum) {
			case 1 :
			{
				function.inputData();
				break;
			}
				
			case 2 :
			{
				function.serchData();
				break;
			}
			case 3 :
			{
				function.removeData();
				break;
			}
			case 4 :
			{
				System.out.println("���α׷��� �����մϴ�.");
				MenuViewer.sc.close();
				return;
			}
			default:
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
			}
		}

	}

}
