import java.util.Random;

// �ν��Ͻ� ������ ���� ���� static ������ �޸� 
// ������ �Ҵ�� �� ������ �ȴ�.
public class StaticEx2 {

		static int num;
		
		// static �ʱ�ȭ ���
		
		static {
			Random rand = new Random();
			num = rand.nextInt(100);
			
		}

		public static void main(String[] args) {
			System.out.println(num);
		}
	

}
