import java.util.Random;

public class E3_RandomNumberGenerator {

	public static void main(String[] args) {
		Random rand = new Random();
		
		for(int i= 0; i < 7; i++)
			System.out.print(rand.nextInt(10));
	}

}

// 실행할때마다 다른결과를 보인다.