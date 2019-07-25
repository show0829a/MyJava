package step07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MyPhoneBook {

	static Scanner sc = new Scanner(System.in);		//한번 불러서 계속 사용 할 것이므로
	static Map<String, PhoneInfo> map = new HashMap<>();	//한번 불러서 계속 사용 할 것이므로
	
	public static void showMenu() {
		System.out.println("[메뉴 선택]");
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 조회");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.프로그램 종료");
		System.out.println("선택 : ");
	}
	
	public static void addNumber() {
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.println("email : ");
		String email = sc.nextLine();
		
		PhoneInfo pInfo;
		if(email != null) {
			pInfo = new PhoneInfo(name, phoneNumber, email);
		} else {
			pInfo = new PhoneInfo(name, phoneNumber);
		}
		pInfo.showPhoneInfo();
		map.put(name, pInfo);
		//System.out.println("맵의 크기 : " + map.size());		//데이터가 제대로 들어갔는지 확인하기 위해.
	}
		
	public static void selNumber() {
		System.out.print("조회할 이름 : ");
		String name = sc.nextLine();
		
//		Set<String> ks = map.keySet();
//		for(String s : ks)
//			System.out.println(map.get(name));
//		System.out.println("-------------------------------------------");
		
		PhoneInfo pInfo = map.get(name);
		pInfo.showPhoneInfo();
	}
	
	public static void delNumber() {
		System.out.print("삭제할 이름 : ");
		String name = sc.nextLine();
		
		PhoneInfo pInfo = map.remove(name);		//key값에 해당하는 내용이 있으면 map에서 삭제가 이뤄진 후
												//삭제한 내용이 리턴, key값이 없으면 null 리턴
		
		if(pInfo != null) {
			System.out.println("삭제되었습니다.");
			pInfo.showPhoneInfo();
		} else {
			System.out.println("해당 내용이 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		readInfo();
		int choice;
		
		while(true) {
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();		//enter로 scanner 버퍼 비워주기 위해
			
			switch(choice) {
				case 1:
					addNumber();
					break;
				case 2:
					selNumber();
					break;
				case 3:
					delNumber();
					break;
				case 4:
					saveInfo();
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					return;
				default:
					System.out.println("잘못된 입력입니다.");
					break;
					
			}
		}
	}
	
	public static void saveInfo() {
		try(ObjectOutputStream oo = 
				new ObjectOutputStream(new FileOutputStream("Object.bin"))) { 
			
			Set<String> ks = map.keySet();
			
			for(String s : ks) {
				PhoneInfo pInfo = map.get(s);
				oo.writeObject(pInfo);
			}
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readInfo( ) {
		try(ObjectInputStream oi = 
				new ObjectInputStream(new FileInputStream("Object.bin"))) { 
			
			while(true) {
				PhoneInfo pInfo = (PhoneInfo) oi.readObject();
				if(pInfo == null)
					break;
				map.put(pInfo.name, pInfo);
			}
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException e) {
			//e.printStackTrace();
		}
	}

}
