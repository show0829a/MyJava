import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class B3_ZoneDateTimeDemo1 {

	public static void main(String[] args) {
		//이 곳의 현재 날짜와 시각
		ZonedDateTime here = ZonedDateTime.now();
		System.out.println(here);
		
		//동일한 날짜와 시각의 파리
		ZonedDateTime paris = ZonedDateTime.of(here.toLocalDateTime(), ZoneId.of("Europe/Paris"));
		
		//이곳과 파리의 시차
		Duration diff = Duration.between(here, paris);
		System.out.println(diff);
	}

}
