package com.javaex.ex02;

public class MainApp {

	public static void main(String[] args) {
		
		//숫자출력 ==> 출장
		DigitalThread dt = new DigitalThread();
		dt.start();
		//문자출력 ==>메인처리
		for(char ch = 'A' ; ch<'Z' ; ch++) {
			System.out.println(ch);
			try {//1초대기
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
