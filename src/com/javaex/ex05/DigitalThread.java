package com.javaex.ex05;
//이미 상속받은게 깃어서 Thread를 상송받을 수 없음
//public class DigitalThread extends Object implements Runnable {

public class DigitalThread implements Runnable {
	@Override
	public void run() {

		for(int i = 0 ; i<=30 ; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
