class Calc {
	int add(int a, int b) {
		
		return a + b;
	}	
	
}

public class Calculation {

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
