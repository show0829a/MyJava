package step2;

import java.util.Scanner;

public class MyPhoneBook {

	static Scanner sc = new Scanner(System.in);		//한번 불러서 계속 사용 할 것이므로
	
	public static void showMenu() {
		System.out.println("[메뉴 선택]");
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 조회");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.프로그램 종료");
		System.out.println("선택 : ");
	}
		
	public static void addNumber() {
			
	}
		
	public static void selNumber() {
			
	}
	
	public static void delNumber() {
		
	}
	
	public static void main(String[] args) {
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
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못된 입력입니다.");
					break;
					
			}
		}
	}

}
