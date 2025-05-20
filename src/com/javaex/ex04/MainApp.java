package com.javaex.ex04;

public class MainApp {

	public static void main(String[] args) {
		
		//Runnable 만들고
		Runnable dt = new DigitalThread();	//run로직이 있음
		
		//숫자 출장
		Thread t = new Thread(dt);
		dt.run();
		//대문자 메인
		for(char ch = 'A' ; ch<='Z' ; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
