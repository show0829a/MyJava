
public class QuizAZ {

	public static void main(String[] args) {
		int num1;
		int num2;
		
		
		for(int A = 0; A < 9; A++) {
			for(int Z = 0; Z < 9; Z++) {
				num1 = A * 10 + Z;
				num2 = Z * 10 + A;
				
				if(A!=Z) {		
						if (A + Z == 9)
							System.out.println(num1 + ", " +num2);
					}
				}
			}
		
		}

}
