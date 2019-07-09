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

	//main() 메소드와 같은 오브젝트 내의 메소드에서는 static을 붙인다.
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
