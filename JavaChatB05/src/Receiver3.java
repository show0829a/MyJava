import java.io.*;
import java.net.*;


//서버로 메세지를 전송하는 클래스
public class Receiver3 extends Thread {
	
	Socket socket;
	BufferedReader in = null;
	
	public Receiver3(Socket socket) {
		this.socket = socket;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch(Exception e) {
			System.out.println("예외1 :" + e);
		}
	}
	

	@Override
	public void run() {
		int i = 0;
		while(in != null) {
			try {
				System.out.println("Thread Receive : " + in.readLine());
			} catch (Exception e) {
				System.out.println("예외2 :" + e);
			}
			
			try {
				in.close();
			} catch (Exception e) {
				System.out.println("예외3 :" + e);
			}
		}
	}
}
