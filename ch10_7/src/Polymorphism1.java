abstract class Calc
{
	int a = 5;
	int b = 6;
	
	abstract int Plus();
}

class MyCalc extends Calc
{
	int Plus()	{ return (a + b); }
	int Minus()	{ return (a - b); }
}
public class Polymorphism1 {

	public static void main(String[] args) {
		MyCalc myCalc1 = new MyCalc();
		myCalc1.Plus();
		myCalc1.Minus();
		
		// ����Ŭ���� ��ü�� ���� Ŭ���� ��ü�� ����
		Calc myCalc2 = new MyCalc();
		myCalc2.Plus();
		// ���� �޼ҵ�� ���赵�� ����. ��� X
		//myCalc2.Minus();

	}

}
