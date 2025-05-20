package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	//천호동
	public static void main(String[] args) throws IOException {
		
		//서버 소켓 생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인드 ip : 192.168.0.62 port 10001
		/*
		 *InetSocketAddress ipport = new InetSocketAddress("192.168.0.62", 10001);
		 *serverSocket.bind(ipport);
		 */
		
		serverSocket.bind(new InetSocketAddress("192.168.0.62", 10001));
		
		//서버 시작
		System.out.println("<서버시작>");
		System.out.println("==========");
		System.out.println("연결대기중");
		
		//클라이언트가 연결되면 accept()가 실행된다
		Socket socket = serverSocket.accept();
		System.out.println("클라이언트 연결 완료");
		
		//읽기 스트림 => 메세지를 받는다
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//쓰기 스트림 준비
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		while(true) {
			String msg = br.readLine();
			
			if(msg == null	) {
				break;
			}
			
			System.out.println("Client: [" + msg + "]");
			
			//메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
			
			System.out.println("==========");
		}
		//=====================================================//
		
		
		System.out.println("<서버종료>");
		//자원정리
		socket.close();
		serverSocket.close();
		br.close();
		bw.close();
	}

}
