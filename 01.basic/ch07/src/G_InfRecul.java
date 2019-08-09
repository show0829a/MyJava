
public class G_InfRecul {

	public static void main(String[] args) {
		showHi(3);
	}
	
	public static void showHi(int cnt) {
		System.out.println("Hi~ " + cnt);
		
		if(cnt == 1)
			return;
		//showHi(cnt--);	//무한 호출, cnt에 후위연산자를 쓰기 때문에 cnt 값이 변하지 않고 값을 리턴 후 감소
		showHi(--cnt);
	}
}
