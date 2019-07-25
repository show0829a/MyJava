import java.time.LocalDateTime;


public class A6_LocalDateTimeDemo1 {

	public static void main(String[] args) {
		//현재시각
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		//영국 바이어와 22시간 35분 뒤 화상 미팅예정
		LocalDateTime mt = dt.plusHours(22);	
		mt = mt.plusMinutes(35);
		
		//화상 미팅 시각
		System.out.println("화상 미팅 시각: " + mt);
	}

}
