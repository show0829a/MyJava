import java.util.Random;

public class QuizRandom {

	public static void main(String[] args) {
		Random random = new Random();
		for(int i = 0; i < 100; i++) {
		while(true) {
			int n = random.nextInt(1000);
			
			int n_h = n/100;
			int n_t = (n/10)%10;
			int n_u = n%10;
			
			if(n > 99) {
				if((n_h != n_t) && (n_t != n_u) && (n_h != n_u)) {
					System.out.println("임의의 숫자 : " + n);
					break;
				} else
					System.out.println("겹치는 숫자가 있습니다. :" + n);
				}
			}
		}
	}

}
