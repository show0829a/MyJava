import java.util.LinkedList;
import java.util.Queue;

public class D1_LinkedListQueue {

	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		
		//������ ����
		que.offer("Box");
		que.offer("Toy");
		que.offer("Robot");
		
		//������ ������ ������ Ȯ��
		System.out.println("next : " + que.peek());
		
		//ù ��°, �ι�° �ν��Ͻ� ������
		System.out.println(que.poll());
		System.out.println(que.poll());
		
		//������ ������ ������ Ȯ��
		System.out.println("next : " + que.peek());
		
		//������ �ν��Ͻ� ������
		System.out.println(que.poll());
	}

}
