import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyPhoneBook {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}	
	
	 Scanner sc = new Scanner(System.in);		//한번 불러서 계속 사용 할 것이므로
	
	public static void main(String[] args) {
		MyPhoneBook mpb = new MyPhoneBook();
		mpb.doRun(); 							//객체의 메소드를 부른거라 스태틱 필요없다
	}
	
	public void doRun() {
		
		int choice;
		
		while(true) {
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();		//enter로 scanner 버퍼 비워주기 위해
			
			switch(choice) {
				case 1:
					addNumber();
					break;
				case 2:
					selNumber();
					break;
				case 3:
					delNumber();
					break;
				case 4:
					
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					return;
				default:
					System.out.println("잘못된 입력입니다.");
					break;
					
			}
		}
	}
	
	public void showMenu() {
		System.out.println("[메뉴 선택]");
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 조회");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.프로그램 종료");
		System.out.println("선택 : ");
	}
	
	public void addNumber() {
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.println("email : ");
		String email = sc.nextLine();
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			StringBuffer sb = new StringBuffer();

			sb.append("insert into PhoneInfo ");
			if(email != null)
				sb.append("values ('" + name + "', '" + phoneNumber + "', '" + email + "')");
			else
				sb.append("values ('" + name + "', '" + phoneNumber + "')");
			stmt.executeUpdate(sb.toString());
			sb.setLength(0);
			
			sb.append("select * from phoneInfo ");
			sb.append("where name = '" + name + "'");
			stmt.executeUpdate(sb.toString());
			
			ResultSet rs = stmt.executeQuery(sb.toString());
			while(rs.next()) {
				System.out.println("이름 : " + rs.getString(1));
				System.out.println("전화번호 : " + rs.getString(2));
				if(rs.getString(3) != null)
					System.out.println("이메일 : " + rs.getString(3));
			}
			sb.setLength(0);
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
		
	public void selNumber() {
		System.out.print("조회할 이름 : ");
		String name = sc.nextLine();
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			StringBuffer sb = new StringBuffer();
			
			
			sb.append("select * from PhoneInfo ");
			sb.append("where name = '" + name + "'");
			stmt.executeUpdate(sb.toString());
			
			ResultSet rs = stmt.executeQuery(sb.toString());
			
			
			while(rs.next()) {
				System.out.println("이름 : " + rs.getString(1));
				System.out.println("전화번호 : " + rs.getString(2));
				if(rs.getString(3) != null)
					System.out.println("이메일 : " + rs.getString(3));
			}
						
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}
	
	public void delNumber() {
		System.out.print("삭제할 이름 : ");
		String name = sc.nextLine();
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
			Statement stmt = con.createStatement();
			StringBuffer sb = new StringBuffer();
			
			
			sb.append("delete PhoneInfo ");
			sb.append("where name = '" + name + "'");
			stmt.executeUpdate(sb.toString());
			
			
			stmt.close();
			con.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
	}
	
	
	
	

}
