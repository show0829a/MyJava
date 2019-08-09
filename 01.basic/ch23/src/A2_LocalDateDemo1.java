import java.time.LocalDate;

public class A2_LocalDateDemo1 {

	public static void main(String[] args) {
		//오늘
		LocalDate today = LocalDate.now();
		System.out.println("Today : " + today);
		
		//올 해의 크리스마스
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas : " + xmas);
		
		//올 해의 크리스마스 dlqm
		LocalDate eve = xmas.minusDays(1);
		System.out.println("Xmas Eve : " + eve);
	}

}
