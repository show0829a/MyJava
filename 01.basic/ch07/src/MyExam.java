
public class MyExam {

	public static void main(String[] args) {
		//parameter x, return x Method
		Hello();
		
		//parameter O, return x Method
		MyAdd(1, 2);
		
		//parameter x, return O Method
		int temper = Temper();
		System.out.println(temper);
		System.out.println(Temper());
		
		int sum = TwoNumAdd(1, 2);
		System.out.println("гую╨ " + sum);
		

	}
	
	public static int TwoNumAdd(int num1, int num2) {
		return num1 + num2;
		
	}
	
	public static int Temper() {
		return 16;
	}
	
	public static void MyAdd(int num1, int num2) {
		int nResult = num1 + num2;
		System.out.println(nResult);
	}
	public static void Hello() {
		System.out.println("Hello");
	}

}
