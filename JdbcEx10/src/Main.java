import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		try {
			ConnectionPool cp = ConnectionPool.getInstatance(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott","tiger", 5, 10);					
		} catch (Exception sqle) {
			sqle.printStackTrace();
		} 
		
		for(int i = 0; i < 100; i ++) {
			TestThread test = new TestThread(i);
			test.start();
			Thread.sleep(50);
		}

	}
}
