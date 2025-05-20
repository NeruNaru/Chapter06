package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;



public class Client {

	//뉴욕
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		//소캣생성
		Socket socket = new Socket();
		
		System.out.println("<클라이언트시작>");
		System.out.println("================");

		//서버에 연결요청
		//ip : 192.168.0.62 port 10001
		System.out.println("서버에 연결 요청중...");
		socket.connect(new InetSocketAddress("192.168.0.62", 10001));
		
		//쓰기 스트림 => 메세지를 보낸다
//		OutputStream out = new FileOutputStream("C:\\javaStudy\\MS949-copy.txt");
		OutputStream out = socket.getOutputStream();	//주스트림
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//읽기 스트림
		InputStream in = socket.getInputStream();	//주수트림
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//스캐너 준비
		//Scanner sc = new Scanner(System.in);
		InputStream sin = System.in;	//주스트림
		InputStreamReader sisr = new InputStreamReader(sin, "UTF-8");
		BufferedReader sbr = new BufferedReader(sisr);
		
		
		//------------------------------------------------------------------
		while(true) {
			//메세지 키보드로 입력받기
//			String msg = sc.nextLine();
			String msg = sbr.readLine();
//			int no = Integer.parseInt(sbr.readLine());
			
			if("/q".equals(msg)) {
				break;
			}
		
			//메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		
			//메세지 받기
			String reMsg = br.readLine();
			System.out.println("server: [" + reMsg + "]");
		
		}
		
		System.out.println("======================");
//		System.out.println("<클라이언트 종료>");
		
		//println 스트림
		OutputStream pout = System.out;
		OutputStreamWriter posw = new OutputStreamWriter(pout, "UTF-8");
		BufferedWriter pbw = new BufferedWriter(posw);
		
		pbw.write("<클라이언트종료>");
		
		//자원정리
		socket.close();
		bw.close();
		br.close();
		sc.close();
	}

}
