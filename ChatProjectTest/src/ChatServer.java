import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer
{
	ServerSocket serverSocket = null;
	Socket socket = null;
	
	
	LinkedList<MultiServerT> RoomList = new LinkedList<MultiServerT>();
	
	Map<String, PrintWriter> clientMap;
	
	//생성자
	public ChatServer() {
		//클라이언트의 출력스트림을 저장할 해쉬맵 생성.
		clientMap = new HashMap<String, PrintWriter>();
		//해쉬맵 동기화 설정.
		Collections.synchronizedMap(clientMap);
	}
	
	public void init()
	{
		try {
			serverSocket = new ServerSocket(9999);	//9999포트로 서버소켓 객체 생성.
			System.out.println("서버가 시작되었습니다.");
			
			while (true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress()+":"+ socket.getPort());
				
				Thread mst = new MultiServerT(socket); //쓰레드 생성
				mst.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//접속자 리스트 보내기
	public void list(PrintWriter out)
	{
		//출력스트림을 순차적으로 얻어와서 해당 메세지를 출력한다.
		Iterator<String> it = clientMap.keySet().iterator();
		String msg = "사용자 리스트 [";
		while(it.hasNext()) {
			msg += (String)it.next() + ",";
		}
		msg = msg.substring(0, msg.length()-1) + "]";
		try {
			out.println(URLEncoder.encode(msg, "UTF-8"));
		} catch (Exception e) {
		}
	}
	
	//접속된 모든 클라이언트들에게 메세지를 전달.
	public void sendAllMsg(String user, String msg)
	{
		//출력스트림을 순차적으로 얻어와서 해당 메세지를 출력한다.
		Iterator<String> it = clientMap.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
				if(user.equals(""))
					it_out.println(URLEncoder.encode(msg, "UTF-8"));
				else
					it_out.println("["+ URLEncoder.encode(user, "UTF-8") +"] "+
									URLEncoder.encode(msg, "UTF-8"));
			} catch(Exception e) {
				System.out.println("예외:" + e);
			}
		}
	}
	
	public static void main(String[] args)
	{
		//서버객체 생성
		ChatServer cs = new ChatServer();
		cs.init();
	}
	
	////////////////////////////////////////////////////////////////////
	// 내부클래스
	// 클라이언트로부터 읽어온 메세지를 다른 클라이언트(socket)에 보내는 역할을 하는 메소드
	
	class MultiServerT extends Thread
	{
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;
		
		//생성자
		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(
												this.socket.getInputStream(), "UTF-8"));
			} catch(Exception e) {
				System.out.println("예외:" + e);
			}
		}
		
		//쓰레드를 사용하기 위해서 run() 메소드 재정의
		@Override
		public void run()
		{
			String name = ""; // 클라이언트로부터 받은 이름을 저장할 변수
			try {
				name = in.readLine(); //클라이언트에서 처음으로 보내는 메세지는
							  		  //클라이언트가 사용할 이름이다.
				name = URLDecoder.decode(name, "UTF-8");
				
				sendAllMsg("", name + "님이 입장하셨습니다.");
				
				//현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트) 들에게 접속을 알림
				clientMap.put(name, out); //해쉬맵에 키를 name으로 출력스트림 객체 저장
				System.out.println("현재 접속자 수는 " +clientMap.size()+"명 입니다.");
				
				//입력스트림이 null이 아니면 반복
				String s = "";
				while (in != null) {
					s = in.readLine();
					s = URLDecoder.decode(s, "UTF-8");
					System.out.println(s);
					
					if(s.equals("/list"))
						list(out);
					else
						sendAllMsg(name, s);
				}
			} catch(Exception e) {
				System.out.println("예외 : " + e);
			} finally {
				clientMap.remove(name);
				sendAllMsg("", name + "님이 퇴장하셨습니다.");
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
				
				try {
					in.close();
					out.close();
					
					socket.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}