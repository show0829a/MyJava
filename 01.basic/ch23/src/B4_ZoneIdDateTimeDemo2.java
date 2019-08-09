import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class B4_ZoneIdDateTimeDemo2 {

	public static void main(String[] args) {
		// 한국 출발 2017-09-09 14:30
		ZonedDateTime daparture = ZonedDateTime.of(
				LocalDateTime.of(2017, 7, 9, 14, 30), ZoneId.of("Asia/Seoul"));
		
		System.out.println("Departure : " + daparture); 
		
		// 파리 도착 2017-09-09 17:25
		ZonedDateTime arrival = ZonedDateTime.of(
				LocalDateTime.of(2017, 7, 9, 17, 25), ZoneId.of("Europe/Paris"));
				
		System.out.println("arrival : " + arrival); 
				
		// 비행시간
		System.out.println("Flight Time : " + Duration.between(daparture, arrival));
	}

}
