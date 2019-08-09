import java.sql.*;
import java.util.Scanner;

public class InitMenu {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}	
	
	Connection con;
	PreparedStatement pstmt1;
	PreparedStatement pstmt2;
	
	 Scanner sc = new Scanner(System.in);	
	
	public static void main(String[] args) {
			InitMenu im = new InitMenu();
			im.doLoginJoin(); 							
	}
	
	public void doLoginJoin() {
		int choice;
		connectDatabase();
		
		while(true) {
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
				{
					Join();
					break;
				}
				case 2:
				{
					Login();
					break;
				}
				case 3:
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}
	}
	
	public void Login() {
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("패스워드 : ");
		String pwd = sc.nextLine();
		
		String sql = "select * from member where id = ? and pwd = ?";
		try {
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, id);
			pstmt2.setString(2, pwd);
			pstmt2.executeUpdate();
			
			ResultSet rs = pstmt2.executeQuery();
			
			if(rs.next()) {
				System.out.println("id : " + rs.getString(1));
				System.out.println("pwd : " + rs.getString(2));
			} else {
				System.out.println("잘못된 입력입니다.");
			}
			
			if(rs != null) rs.close();
		} catch (Exception e) {
			System.out.println("알 수 없는 에러가 발생했습니다." + e);
		} 
	}
	
	public void Join() {
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("패스워드 : ");
		String pwd = sc.nextLine();
		
		String sql = "insert into member(id, pwd) values(?, ?)";
		try {
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1, id);
			pstmt1.setString(2, pwd);
			
			pstmt1.executeUpdate();
			
			System.out.println("가입 되셨습니다.");
		} catch (SQLIntegrityConstraintViolationException e) {
			if(e.getErrorCode() == 1400)
				System.out.println("공백입니다.");
			if(e.getErrorCode() == 1)
				System.out.println("중복된 아이디 입니다.");
		} catch (Exception e) {
			System.out.println("알 수 없는 에러 입니다.");
		}
	}
	
	public void showMenu() {
		System.out.println("환영합니다.");
		System.out.println("1. 가입, 2. 접속");
	}
	
	public void connectDatabase() {
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
