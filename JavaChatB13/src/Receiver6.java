import java.io.*;
import java.net.*;

//서버로 메시지를 전송하는 클래스
public class Receiver6 extends Thread 
{
	Socket socket;
	BufferedReader in =null;
	
	public Receiver6(Socket socket)
	{
		this.socket = socket;
		
		try {
			in= new BufferedReader(new InputStreamReader(
									this.socket.getInputStream() ));
		
		}catch(IOException e) {
			System.out.println("예외:"+e);
			}
		}
	
	//run()메소드 재정의
	public void run() {
		while (in!=null) {
			try {
				System.out.println(">> " +URLDecoder.decode(in.readLine(),"UTF-8"));
			}catch(java.net.SocketException ne) {
				break;
			}catch (Exception e) {
				System.out.println("예외:"+e);
			}
		}
	}
}





