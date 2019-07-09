package chapter07;

public class Quiz0703 {

	public static void main(String[] args) {

			System.out.println(minimum(1,3,5));
			System.out.println(minimum(5,3,1));
			
		}
		public static int minimum(int num1, int num2, int num3) {
			if(num1 < num2) {
				if(num1 < num3)
					return num1;
				else
					return num3;
			} else {
				if(num2 < num3)
					return num2;
				else
					return num3;
			}
		}
	

}
