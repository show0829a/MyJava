// ����ũ�μ���Ʈ�� : �÷��� �μ⸦ �� ��쿡�� ������ �԰����� ����� �ּ���.
//					  ColorPrintable �� ������ �ּ���
// �Ʒ����ѱ� : ���� ���α׷� : print ȣ��
//				���� ���α׷� : printCMYK ȣ��
//�Ｚ, ���� : ���� ������ : print ����
//			   ���� ������ : printCMYK ����
interface ColorPrintable extends Printable{
	void printCMYK(String doc);
}

class PrnColorDrvSamsumg implements ColorPrintable {
	
	public void print(String doc) {
		System.out.println(doc + "\nFrom Samsung(2) : Black-White Ver");
	}
	
	public void printCMYK(String doc) {
		System.out.println(doc + "\nFrom Samsung(2) : Color Ver");
	}
	
}

class PrnColorDrvEpson implements ColorPrintable {
	
	public void print(String doc) {
		System.out.println(doc + "\nFrom Epson(2) : Black-White Ver");
	}
	
	public void printCMYK(String doc) {
		System.out.println(doc + "\nFrom Epson(2) : Color Ver");
	}
	
}

public class Polymorphism2_2 {

	public static void main(String[] args) {
		String doc = "�����ͷ� ����� �մϴ�.";
		
		Printable prn1 = new PrnDrvSamsung();
		prn1.print(doc);
		
		ColorPrintable prn2 = new PrnColorDrvSamsumg();
		prn2.print(doc);
		prn2.printCMYK(doc);
		
		ColorPrintable prn3 = new PrnColorDrvEpson();
		prn3.print(doc);
		prn3.printCMYK(doc);

	}

}
