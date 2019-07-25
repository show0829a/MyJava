package step01;

public class MyPhoneBook {

	public static void main(String[] args) {
		PhoneInfo pInfo1 = new PhoneInfo("홍길동", "010-1325-1532","testemail");
		PhoneInfo pInfo2 = new PhoneInfo("전우치", "010-1243-1532");
		
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
		

	}

}
