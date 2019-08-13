import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;
import java.util.concurrent.Semaphore;

public class ChatServer
{
	ServerSocket serverSocket = null;
	Socket socket = null;

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
	 
	Map<String, PrintWriter> clientMap;
	Map<String, RoomInfo> roomList;
	Map<String, User> userMap;
	
	class LoginStatus{
		String name;
		boolean login = false;
	}
	
	class CmdAndContent{
		String cmd;
		String content;
		
		//생성자
		public CmdAndContent() {
			this.cmd = null;
			this.content = null;
		}
		
		public CmdAndContent(String cmd, String content) {
			this.cmd = cmd;
			this.content = content;
		}

		
	}
	
	//생성자
	public ChatServer() {
		//클라이언트의 출력스트림을 저장할 해쉬맵 생성.
		clientMap = new HashMap<String, PrintWriter>();
		roomList = new HashMap<String, RoomInfo>();
		userMap = new HashMap<String, User>();
		//해쉬맵 동기화 설정.
		Collections.synchronizedMap(clientMap);
		Collections.synchronizedMap(roomList);
		Collections.synchronizedMap(userMap);
		
	}
	
	class User{
		String id;
		String status;
		String roomName;
//		User user = new User(userName);
		
		User(String id) {
			this.id = id;
			status = "user";
			roomName = "waiting Room";
		}
		
//		User(String id, String status){
//			this.id = id;
//			this.status = status;
//			roomName = "waiting room";
//		}
		User(String id, String roomName) {
			this.id = id;
			this.roomName = roomName;
			this.status	= "user";
		}
		
		User(String id, String status, String roomName){
			this.id = id;
			this.status = status;
			this.roomName = roomName;
		}
	}
	
	class RoomInfo{
		String roomName;
		String roomStatus;
		String roomPW;
		ArrayList<User> userList = new ArrayList<>();
		int roomUserNumber = 10000;
		
		RoomInfo(){
			
		}
		RoomInfo(User user){
			this.roomName = "waiting room";
			this.roomStatus = "";
			this.roomPW	 = "";
			this.userList.clear();
		}
		
	}
	
	
	public void init()
	{
		try {
			serverSocket = new ServerSocket(9999);	//9999포트로 서버소켓 객체 생성.
			System.out.println("서버가 시작되었습니다.");
			
			while (true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress()+":"+ socket.getPort());
				
				try {
					
					Thread mst = new MultiServerT(socket); //쓰레드 생성
					mst.start();
					
				} catch(Exception e) {
					System.out.println("Login 섹션 예외:" + e);
				}
				
				
				
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
	
	//접속된 모든 클라이언트들에게 메세지를 전달.
	public void sendRoomUserMsg(String roomName, String msg, String user)
	{
		//출력스트림을 순차적으로 얻어와서 해당 메세지를 출력한다.
		Iterator<User> it = roomList.get(roomName).userList.iterator();
		
		while(it.hasNext()) {
			try {
				String name = it.next().id;
				PrintWriter it_out = (PrintWriter) clientMap.get(name);
				
//				System.out.println("방 메세지 실행");
				it_out.println(roomName + " msg ["+ URLEncoder.encode(user, "UTF-8") +"] "+
									URLEncoder.encode(msg, "UTF-8"));
			} catch(Exception e) {
				System.out.println("예외:" + e);
			}
		}
	}
	
	//접속된 모든 클라이언트들에게 메세지를 전달.
		public void sendUserMsg(String user, String msg, String toUser)
	{
		//출력스트림을 순차적으로 얻어와서 해당 메세지를 출력한다.
		Iterator<String> it = clientMap.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				String toUserName = it.next();
				PrintWriter it_out = (PrintWriter) clientMap.get(toUserName);
				if(toUserName.equals(toUser))
					it_out.println("귓속말 ["+ URLEncoder.encode(user, "UTF-8") +"] :"+
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
		String id;
		
		
		
		//생성자
		public MultiServerT(Socket socket) {
			this.socket = socket;
//			this.id = id;
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
			
			
			LoginStatus ls = new LoginStatus();
			
			User user;
			String id = null;
			while(!ls.login) {
				ls = doLoginJoin(socket);
				id = ls.name;
				if(!clientMap.containsKey(id))
					ls.login = true;
				else {
					ls.login = false;
					out.println("중복된 아이디가 접속되어 있습니다.");
				}
			}
			user = new User(id);
			userMap.put(id, user);
			
			System.out.println("로그인 성공했습니다.");
			CmdAndContent cc = new CmdAndContent();
		
			if(!roomList.containsKey("waiting room"))
				createRoom(user, "waiting room", out , in);
			else
				enterWaitRoom(user);
			
			int userListSize = roomList.get("waiting room").userList.size();
			
			System.out.println("대기실 인원 : " + userListSize);
			
			boolean completeOrFail = false;
			
		//	String name = id; // 클라이언트로부터 받은 이름을 저장할 변수
			try {
				
				sendAllMsg("", user.id + "님이 입장하셨습니다.");
				
				//현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트) 들에게 접속을 알림
				clientMap.put(user.id, out); //해쉬맵에 키를 name으로 출력스트림 객체 저장
				System.out.println("현재 접속자 수는 " +clientMap.size()+"명 입니다.");
				
				//입력스트림이 null이 아니면 반복
				String s = "";
				while (in != null) {
					
					s = in.readLine();
					s = URLDecoder.decode(s, "UTF-8");
					System.out.println(s);
					if(s.equalsIgnoreCase("y") || s.equalsIgnoreCase("n"))
					{
						System.out.println("확인합니다." + s);
						if(userMap.get(user.id).status.contains("invite from")) {
							//System.out.println(user.status.substring(11, user.status.length()));
							inviteYN(s, user.status.substring(11,user.status.length()) , user);
							
						}
					}
					if(!s.equalsIgnoreCase("/")) {
						if(s.substring(0,1).equals("/")) {
							cc = command(s);
							System.out.println("리턴받은 cc.cmd는 " + cc.cmd);
							System.out.println("리턴받은 cc.content는 " + cc.content);
								
							switch(cc.cmd) {
							case "/create":
							{
								createRoom(user, cc.content,out, in);
								System.out.println("방만들기");
								if(completeOrFail) {
									roomList.get("waiting room").userList.remove(user);
								}
								break;
							}
							case "/createpw":
								createRoomPW(user, cc.content, out, in);
								System.out.println("비번방만들기");
								break;
							case "/listroom":
							{
								showRoomList(out);
								System.out.println("방리스트 보기");
								break;
							}
							case "/in" :
							{
								enterRoom(user, cc.content, out, in);
								System.out.println("방 들어가기");
								break;
							}
							case "/userlistwait" :
							{	
								System.out.println("대기실 유저 리스트");
								showUserListRoom("waiting room", out);
								break;
							}
							case "/userlistroom" :
							{
								System.out.println("방 유저 리스트");	
								showUserListRoom(user.roomName, out);
								break;
							}
							case "/invite" :
							{
								invite(user, cc.content, out);	
								System.out.println("초대하기");
								break;
							}
							case "/banc" :
								System.out.println("일시적 강퇴");
								break;
							case "/banf" :
								System.out.println("영구 강퇴");
								break;
							case "/leave" :
								System.out.println("방나가기");
								break;
							case "/transfer" :
								System.out.println("방장 주기");
								break;
							case "/remove" :
								System.out.println("방 폭파 하기");
							case "/to" :
								System.out.println("귓속말하기");
								break;
							case "/showUserInfo" :
								showUserInfo(user, out);
								break;
							case "/showRoomInfo" :
								showRoomInfo(cc.content, out);
								break;
							}
						} else {
							if(s.equals("/list"))
								list(out);
							else {
								sendAllMsg(user.id, s);
								sendRoomUserMsg(user.roomName, s, user.id);
								sendUserMsg(user.id, s, "test2");
							}
						}
					}
				}
			} catch(Exception e) {
				System.out.println("예외 mt : " + e);
			} finally {
				clientMap.remove(user.id);
				userMap.remove(user.id, user);
				roomList.get(user.roomName).userList.remove(user);
				
				sendAllMsg("", user.id + "님이 퇴장하셨습니다.");
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
////////////////////////////////////////////////////////////////////////////////////////////////////
////명령어 메소드
	
//	1.방만들기
	public void createRoom(User user, String content, PrintWriter out, BufferedReader in) {
	try {
		RoomInfo room = new RoomInfo(user);
		System.out.println("방객체 생성");
		room.roomName = content;
		System.out.println("방 네임");
		room.userList.add(user);
		System.out.println("userlist 등록");
		
		if(!content.equals("waiting room")) {
			out.println("방 정원을 입력하세요");
			room.roomUserNumber =  Integer.parseInt(in.readLine());
			roomList.get("waiting room").userList.remove(user);
			}
		roomList.put(content, room);
		System.out.println("맵에 등록");
		user.roomName = content;
		System.out.println("유저 룸 네임 등록");
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
//	2. 비번방 만들기	
	public void createRoomPW(User user, String content,PrintWriter out, BufferedReader in) {
		try {
			RoomInfo room = new RoomInfo(user);
			room.roomName = content;
			
			out.println("패스워드를 입력하세요");
			room.roomPW = in.readLine();
			room.userList.add(user);
			roomList.put(content, room);
			
			out.println("방 정원을 입력하세요");
			room.roomUserNumber =  Integer.parseInt(in.readLine());
			user.roomName = content;
			System.out.println("룸이 생성되었습니다.");
			
			if(!content.equals("waiting room"))
				roomList.get("waiting room").userList.remove(user);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
//	3. 룸 리스트 보여주기
	public void showRoomList(PrintWriter out)
	{
		//출력스트림을 순차적으로 얻어와서 해당 메세지를 출력한다.
		Iterator<String> it = roomList.keySet().iterator();
			String roomlist = "방 리스트 [";
		while(it.hasNext()) {
			roomlist += (String)it.next() + ",";
		}
		roomlist = roomlist.substring(0, roomlist.length()-1) + "]";
		try {
			out.println(URLEncoder.encode(roomlist, "UTF-8"));
		} catch (Exception e) {
		}
	}
//	4. 방의 유저 리스트 보여주기
	public void showUserListRoom(String roomName, PrintWriter out)
	{
		try {
			System.out.println("방 유저 리스트 시작");
			RoomInfo cRoom = new RoomInfo();
			cRoom = roomList.get(roomName);
			//출력스트림을 순차적으로 얻어와서 해당 메세지를 출력한다.
			System.out.println("룸 객체 생성");
			out.println("[유저 리스트 in " + cRoom + "]");
			
			String userlist = "";
			System.out.println("cRoom의 룸네임: " + cRoom.roomName);
			
			for(int i = 0; i < cRoom.userList.size(); i++ )
				userlist += cRoom.userList.get(i).id + ",";
			
			userlist = userlist.substring(0, userlist.length() - 1);
				
			out.println(URLEncoder.encode(userlist, "UTF-8"));
		} catch (Exception e) {
			System.out.println("show room userlist의 문제");
			e.printStackTrace();
		}
	}
	//대기방 들어가기
	public void enterWaitRoom(User user) {
		user.roomName = "waiting room";
		roomList.get("waiting room").userList.add(user);
	}
	
	//방들어가기
	public void enterRoom(User user, String content, PrintWriter out, BufferedReader in) {
		String pw;
		if(roomList.containsKey(content) && roomList.get(content).roomUserNumber > roomList.get(content).userList.size()) {
			if(roomList.get(content).roomPW.equals("")) {
				
			} else {
				out.println("패스워드를 입력하세요");
				try {
					pw = in.readLine();
					if(pw.equals(roomList.get(content).roomPW)) {
						roomList.get(user.roomName).userList.remove(user);
						user.roomName = content;
						roomList.get(content).userList.add(user);
					} else
						out.println("잘못된 패스워드입니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		} else if(roomList.get(content).roomUserNumber <= roomList.get(content).userList.size()) {
			out.println("정원 초과 입니다.");
		} else
			out.println("방이 존재하지 않습니다.");	
	}
	//초대장 
	public void invite(User user, String toName, PrintWriter out) {
		sendUserMsg(user.id, user.id + "의 초대에 응하시겠습니까 ? (y or n)", toName);
		userMap.get(toName).status = "invite from" + user.id;
		System.out.println("아웃 성공");
	//	ivString = toName + " yes" + user.id;		
	}
	//초대장
	//@SuppressWarnings("unlikely-arg-type")
	public void inviteYN(String s, String fromName, User user) {
		String key = s;
		
		if(user.roomName.equals("waiting room")) {
			if(key.equalsIgnoreCase("y"))
			{
				user.roomName = userMap.get(fromName).roomName;
				roomList.get("waiting room").userList.remove(user);
				roomList.get(userMap.get(fromName).roomName).userList.add(user);
				
				user.status = "user";
				
			} else if(key.equalsIgnoreCase("n")) {
				sendUserMsg(user.id, user.id + "님이 초대를 거절하셨습니다.", fromName);
			}
		} else {
			sendUserMsg(user.id, "대기방이 아닙니다.", fromName);
		}
	}
	//명령어 추출
	public CmdAndContent command(String cs) {
		String s = cs;
		String cmd;
		String content = "";
		StringTokenizer sc = new StringTokenizer(s);
		cmd = sc.nextToken();
		System.out.println("cmd는 " + cmd);
		
		if(sc.hasMoreTokens()) {
			
			while(sc.hasMoreTokens())
				content += sc.nextToken() + " ";
			
			content = content.substring(0, content.length()-1);
			
		}else 
			content = null;
		
		CmdAndContent cc = new CmdAndContent(cmd, content);
		System.out.println("content 는" + content); 

		return cc;	
	}
	public void showUserInfo(User user, PrintWriter out) {
		out.println("User Info");
		out.println("User id : " + user.id);
		out.println("User status : " + user.status);
		out.println("User roomName : " + user.roomName);
	}
	
	public void showRoomInfo(String roomName, PrintWriter out) {
		System.out.println("메소드 시작");
		System.out.println(roomName);
		if(roomList.containsKey(roomName)) {
			System.out.println("roomName : " + roomName);
			//roomList.get(roomName);
		}
		else
		{
			System.out.println("없는 방 입니다.");
			return;
		}
		out.println("Room Info");
		System.out.println("RoomInfo");
		out.println("Room name : " + roomList.get(roomName).roomName);
		System.out.println(roomList.get(roomName).roomName);
		
		if(roomList.get(roomName).roomPW.equals(""))
			out.println("Room status : 공개방");
		else
			out.println("Room status : 비공개방");
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////	
////	초기 메뉴 메소드
	public LoginStatus doLoginJoin(Socket dSocket) {
		System.out.println("로그인 시작");
		Socket socket = dSocket;
		

		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(
										socket.getInputStream(), "UTF-8"));
		} catch(Exception e) {
			System.out.println(e);
		}
		
		connectDatabase();
		
		String choice = null;
		String id = null;
		String pwd = null;
		
		LoginStatus ls = new LoginStatus();
		
		while(true) {
			try {
					showMenu(out);			
					while(in != null) {
						choice = in.readLine();
						//System.out.println("초이스는" + choice);
						if(!choice.equals(""))
							break;	
					}
					//System.out.println("확정된 초이스는" + choice);
					
					if(choice.equals("1") || choice.equals("2")) {
						out.println("ID를 입력하세요");
						while(in != null) {
							id = in.readLine();
							//System.out.println("in : " + in);
							if(!id.equals(""))
								break;	
						}
						//System.out.println("확정된 아이디는" + id);
						
						out.println("pwd를 입력하세요");
						while(in != null) {
							pwd = in.readLine();
							//System.out.println("in : " + in);
							if(!pwd.equals(""))
								break;	
						}
						//System.out.println("확정된 패스워드는" + pwd);
					}
					
					switch(choice) {
						case "1":
						{
							Join(id, pwd, out);
							break;
						}
						case "2":
						{
							ls = Login(id, pwd, out);
							if (ls == null)
								break;
							else
								return ls;
						}
						case "3":
						{
							System.out.println("프로그램을 종료합니다.");
								return ls;
//							try {
//								in.close();
//								out.close();
//								
//								socket.close();
//							} catch(Exception e) {
//								e.printStackTrace();
//							}
						}
					}
			System.out.println("로그인섹션이 끝났습니다.");
			} catch (IOException e) {
				
				e.printStackTrace();
			}	
			
		}
	}
	
	public LoginStatus Login(String lId, String lPwd, PrintWriter lOut) {
		String id = lId;
		String pwd = lPwd;
		
		String sql = "select * from member where id = ? and pwd = ?";
		try {
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, id);
			pstmt2.setString(2, pwd);
			pstmt2.executeUpdate();
			
			ResultSet rs = pstmt2.executeQuery();
			
			if(rs.next()) {
				lOut.println("id : " + rs.getString(1));
				lOut.println("pwd : " + rs.getString(2));
				
				LoginStatus ls = new LoginStatus();
				ls.name = id;
				//ls.login = true;
				return ls;
			} else {
				lOut.println("잘못된 입력입니다.");		
			}
			
			if(rs != null) rs.close();
			
		} catch (Exception e) {
			lOut.println("알 수 없는 에러가 발생했습니다." + e);
		}
		return null; 
	}
	
	public void Join(String jId, String jPwd, PrintWriter jOut) {
		String id = jId;
		String pwd = jPwd;
		
		String sql = "insert into member(id, pwd) values(?, ?)";
		try {
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1, id);
			pstmt1.setString(2, pwd);
			
			pstmt1.executeUpdate();
			
			jOut.println("가입 되셨습니다.");
			return;
		} catch (SQLIntegrityConstraintViolationException e) {
			if(e.getErrorCode() == 1400)
				jOut.println("공백입니다.");
			if(e.getErrorCode() == 1)
				jOut.println("중복된 아이디 입니다.");
		} catch (Exception e) {
			jOut.println("알 수 없는 에러 입니다.");
		}
	}
	
	public void showMenu(PrintWriter sOut) {
		sOut.println("환영합니다.");
		sOut.println("1. 가입, 2. 접속 3. 종료");
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