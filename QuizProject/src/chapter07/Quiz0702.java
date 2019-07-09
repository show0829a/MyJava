package chapter07;

public class Quiz0702 {

	public static void main(String[] args) {
		System.out.println(maximum(1,3,5));
		System.out.println(maximum(5,3,1));
		
	}
	public static int maximum(int num1, int num2, int num3) {
		if(num1 > num2) {
			if(num1 > num3)
				return num1;
			else
				return num3;
		} else {
			if(num2 > num3)
				return num2;
			else
				return num3;
		}
	}
}
