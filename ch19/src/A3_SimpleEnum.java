enum Scale1 {
	DO, RE, MI, FA, SO, RA, TI
}

public class A3_SimpleEnum {

	public static void main(String[] args) {
		Scale1 sc = Scale1.DO;
		System.out.println(sc);
		
		switch(sc) {
		case DO:
			System.out.println("��~");
			break;
		case RE:
			System.out.println("��~");
			break;
		case MI:
			System.out.println("��~");
			break;
		case FA:
			System.out.println("��~");
			break;
		default:
			System.out.println("��~ ��~ ��~");
			
		}
	}

}
