package chapter06;

public class Quiz0608 {
	public static void main(String[] args) {
		for(int i = 2; i < 10;i=i+2) {
			System.out.println("---------------------------");
			for(int j = 2; j <= i; j=j+2) {
				System.out.printf("%d * %d = %d\n", i,j,i*j);
			}
		}
	}
}
