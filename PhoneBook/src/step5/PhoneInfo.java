package step5;

public class PhoneInfo {
	String name;
	String phoneNumber;
	String email;
	
	

	public PhoneInfo(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneInfo(String name, String phoneNumber, String email) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	//생성자를 다르게 해서 email이 null일 경우 출력안하는 것을 여기서 처리
	public void showPhoneInfo() {
		System.out.println("Name : " + name);
		System.out.println("PhoneNumber : " + phoneNumber);
		if(email != null)
			System.out.println("EMail : " + email);
		System.out.println("------------------------------------------");
	}
}
