
public class Polymorphism2_3 {

	public static void main(String[] args) {
			String doc = "�����ͷ� ����� �մϴ�.";
			
			ColorPrintable prn1 = new PrnColorDrvSamsumg();
			prn1.print(doc);
			prn1.printCMYK(doc);
			
			ColorPrintable prn2 = new PrnColorDrvSamsumg();
			prn2.print(doc);
			prn2.printCMYK(doc);
			
			// �ڽ��� �θ𿡰� ���� ���� ������, ���� ������ Ŭ������ ���� ���� ����.
			//PrnColorDrvSamsung prn3 = new PrnColorDrvEpson();
			
	}

}
