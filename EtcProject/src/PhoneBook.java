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
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phNumber);
		System.out.println("e-mail : " + email);
		System.out.println("----------------------------------------------------------------");
	}
}

class Function {
	
	Contact ct;
	HashMap<String, Contact> map = new HashMap<>();
	Set<String> ks = map.keySet();
	
	public void inputData(){
		
		System.out.println("이름 : ");
		String name = MenuViewer.sc.nextLine();
		System.out.println("전화번호 : ");
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
		
		
		System.out.println("검색할 번호의 이름 : ");
		String name = MenuViewer.sc.nextLine();
		try {
			ct.showBook(map.get(name));
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
		}
	}
	
	public void removeData() {
		System.out.println("삭제할 번호의 이름");
		String name = MenuViewer.sc.nextLine();
		map.remove(name);
	}
}

class MenuViewer{
	public static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("원하는 기능을 선택하세요");
		System.out.println("1. 전화번호 저장, 2. 전화번호 조회, 3. 전화번호 삭제, 4. 종료");
		System.out.println("선택 : ");
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
				System.out.println("프로그램을 종료합니다.");
				MenuViewer.sc.close();
				return;
			}
			default:
				System.out.println("잘못 입력 하셨습니다.");
			}
		}

	}

}
