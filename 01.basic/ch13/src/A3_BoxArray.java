class BoxA3 {
	public String conts;
	BoxA3(String cont) {
		this.conts = cont;
		
	}
//	public String getConts() {
//		return conts;
//		
//	}
	
}
public class A3_BoxArray {

	public static void main(String[] args) {
		int[] ar2 = new int[3];
		ar2[0] = 7;
		ar2[1] = 8;
		ar2[2] = 9;
		System.out.println(ar2[0] + "," + ar2[1] + "," + ar2[2]);
		
		BoxA3[] ar = new BoxA3[3];
		
		//�迭�� �ν��Ͻ� ���� (�ʱ�ȭ)
		ar[0] = new BoxA3("First");
		ar[1] = new BoxA3("Second");
		ar[2] = new BoxA3("Third");
	
		//����� �ν��Ͻ��� ����
		System.out.println(ar[0].conts);
		System.out.println(ar[1].conts);
		System.out.println(ar[2].conts);
	}
	
	

}
