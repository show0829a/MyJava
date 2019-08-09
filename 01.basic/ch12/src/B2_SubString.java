
public class B2_SubString {

	public static void main(String[] args) {
		String st1 = "홍길동이다";
		
		String st2 = st1.substring(2);
		System.out.println(st2);
		
		String st3 = st1.substring(2,4);	// 2~ 3열까지 출력
		System.out.println(st3);
	}

}
