package chapter06;


public class Quiz0604 {
	public static void main(String[] args) {
		int i = 1;
		int result = 0;
		do{
			if(i<1000) {
				result += i;
				System.out.printf("%d+",i);
				
			}
			else {
				System.out.printf("%d = %d",i,result + i);
				
			}
		i++;
		}while(i < 1001);
		

	}
}
