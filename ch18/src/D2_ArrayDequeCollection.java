import java.util.ArrayDeque;
import java.util.Deque;

public class D2_ArrayDequeCollection {

	public static void main(String[] args) {
		Deque<String> deq = new ArrayDeque<>();
		
		//������ �ְ�
		deq.offerFirst("1.Box");
		deq.offerFirst("2.Toy");
		deq.offerFirst("3.Robot");
		
		//�տ��� ������
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		
		//�ڷ� �ְ�
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
		
		//�ڿ��� ������
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		
		//�ڷ� �ְ�
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
		
		//�տ��� ������
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
	}

}
