package step09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

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
		try(BufferedWriter bw =
				new BufferedWriter(new FileWriter("Phone_Data.csv"))) { 
			
			Set<String> ks = map.keySet();
			
			for(String s : ks) {
				PhoneInfo pInfo = map.get(s);
				String pInfoString;
				
				if(pInfo.email != null) {
					pInfoString = pInfo.name + "," + pInfo.phoneNumber + "," + pInfo.email;
					
				}
				else {
					pInfoString = pInfo.name + "," + pInfo.phoneNumber;
					
				}			
				
				bw.write(pInfoString, 0 , pInfoString.length());
				bw.newLine();
			
			}
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readInfo() {
		try(BufferedReader br = new BufferedReader(new FileReader("Phone_Data.csv"))) {
		String str;
			
			while(true) {
				str = br.readLine();
				
				if(str == null) 
					break;
				
				StringTokenizer st = new StringTokenizer(str, ",");
				
				String name = st.nextToken();
				String phoneNumber = st.nextToken();			
				String email = null;
				
				if(st.hasMoreTokens())
					email = st.nextToken();
				
				PhoneInfo pInfo;
				
				if(email == null)
					pInfo = new PhoneInfo(name, phoneNumber);
				else
					pInfo = new PhoneInfo(name, phoneNumber, email);		
				
				map.put(pInfo.name, pInfo);
				
			}
		}
		
		
		catch(IOException e) {
			//e.printStackTrace();
		}
	}

}
