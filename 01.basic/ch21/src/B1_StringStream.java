import java.util.Arrays;
import java.util.stream.Stream;

public class B1_StringStream {

	public static void main(String[] args) {
		String[] names = {"YOON", "LEE", "PARK"};
		
		// ��Ʈ�� ����
		Stream<String> stm = Arrays.stream(names);
		
		// ���� ���� ����
		stm.forEach(s -> System.out.println(s));
	}

}
