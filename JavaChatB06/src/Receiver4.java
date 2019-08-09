import java.io.*;
import java.net.*;


//서버로 메세지를 전송하는 클래스
public class Receiver4 extends Thread {
	
	Socket socket;
	BufferedReader in = null;
	
	public Receiver4(Socket socket) {
		this.socket = socket;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch(Exception e) {
			System.out.println("예외1 :" + e);
		}
	}
	

	@Override
	public void run() {
		while(in != null) {
			try {
				System.out.println("Thread Receive : " + in.readLine());
			} catch (java.net.SocketException ne) {
				break;
			} catch (Exception e) {
				System.out.println("예외:"+e);
			}
		}
		try {
			in.close();
		} catch (Exception e) {
			System.out.println("예외3 :" + e);
		}
	
	}
}
