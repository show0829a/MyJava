
public class A4_StringArray {

	public static void main(String[] args) {
		String[] name = new String[7];
		
		name[0] = new String("ȫ�浿");
		name[1] = new String("����ġ");
		name[2] = new String("�տ���");
		name[3] = new String("������");
		name[4] = new String("�̼���");
		name[5] = new String("��������");
		name[6] = new String("�縸��");
	
		int cnum = 0;
		
		for(int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
			cnum += name[i].length();
		}

		System.out.println("�� ������ �� : " + cnum);
	}

}
