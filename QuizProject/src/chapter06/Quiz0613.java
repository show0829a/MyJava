package chapter06;

public class Quiz0613 {

	public static void main(String[] args) {
		System.out.println("����");
		for(int i = 1; i < 10; i++) {
	
			for(int j = 2; j <10; j++) {
				System.out.printf("%d * %d = %d   ",j,i,i*j);
				if((i*j)<10)
					System.out.print(" ");
			}
		System.out.printf("\n");
		}
		
		System.out.printf("\n");
		
		System.out.println("����");
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d*%d =%d  ", i,j,i*j);
				if((i*j)<10)
					System.out.print(" ");
			}
			System.out.println(" \n");
			
		}
	}

}
