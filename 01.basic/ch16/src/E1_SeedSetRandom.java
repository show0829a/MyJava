import java.util.Random;

public class E1_SeedSetRandom {

	public static void main(String[] args) {
		Random rand = new Random(System.currentTimeMillis());
		
		for(int i= 0; i < 7; i++)
			System.out.println(rand.nextInt(10));
	}

}
// ������ ������ �ٸ� ����� ���δ�.