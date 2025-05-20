package com.javaex.ex06;

public class MainApp {

	public static void main(String[] args) {
		
		//edit Runnable
		Runnable dt = new DigitalThread_Impl();
		Runnable ui = new UpperImpl();
		Runnable li = new LowerImpl();
		
		//connect Thread
		Thread rt = new Thread(dt);
		Thread ut = new Thread(ui);
		Thread lt = new Thread(li);
		
		//run
		rt.start();
		ut.start();
		lt.start();
		
		//숫자출력
		//대문자출력
		//소문자출력

	}

}
