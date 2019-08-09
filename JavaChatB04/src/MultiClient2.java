/*콘솔 멀티채팅 클라이언트 프로그램*/
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultiClient2 {

	public static void main(String[] args)  throws UnknownHostException, IOException 
	{
		System.out.println("이름을 입력해 주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();
		
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			String ServerIP = "localhost";
			Socket socket = new Socket(ServerIP, 9999); //소켓 객체 생성
			System.out.println("서버와 연결이 되었습니다.");
			
			//서버에서 보내는 메세지를 사용자의 콘솔에 출력하는 쓰레드
			Thread receiver = new Receiver3(socket);
			receiver.start();
			
			out.println(s_name);
			
			while (out!=null) {
				try {
					// 출력
					String s2 = s.nextLine();
					if(s2.equals("q") || s2.equals("Q")) {
						out.println(s2);
						break;
					} else {
						out.println(s_name + "=>" + s2);
					}
				} catch (Exception e) {
					System.out.println("예외:" + e);
				}
			}
			out.close();
			
			socket.close();
		
		} catch(Exception e) {
			System.out.println("예외 [MultiClient class]:" + e);
		}
	}
}
