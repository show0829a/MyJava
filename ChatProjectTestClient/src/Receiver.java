import java.io.*;
import java.net.*;

public class Receiver extends Thread {
	Socket socket;
	BufferedReader in = null;
	
	//Socket을 매개변수로 받는 생성자
	public Receiver(Socket socket)
	{
		this.socket = socket;
		
		try {
			in = new BufferedReader(new InputStreamReader(
										this.socket.getInputStream() ));
		} catch (Exception e) {
			System.out.println("예외 in : " + e);
			
		}
	}
	
	//run()	메소드 재정의
	public void run() {
		while(in != null) {
			try {
				System.out.println(">>" + URLDecoder.decode(in.readLine(), "UTF-8"));
			} catch (java.net.SocketException ne) {
				break;
			} catch(Exception e) {
				System.out.println("예외 receive thread : " + e);
				e.printStackTrace();
			}
		}
		try {
			in.close();
		} catch(Exception e) {
			System.out.println("예외3 : " + e);
		}
	}
}
