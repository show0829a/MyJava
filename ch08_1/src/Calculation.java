class Calc {
	int add(int a, int b) {
		return a + b;
	}	
	int add(int a) {
		return a + 1;
	}
	double add(double a, double b) {
		return a + b;
	}
}

public class Calculation {

	//main() �޼ҵ�� ���� ������Ʈ ���� �޼ҵ忡���� static�� ���δ�.
	static void disp() {
		int nRtn;
		Calc calc = new Calc();
		nRtn = calc.add(3, 9);
		
		System.out.println("3 + 9 = " + nRtn);
	}
	
	public static void main(String[] args) {
		disp();
	}

}
