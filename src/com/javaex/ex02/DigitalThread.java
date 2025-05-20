package com.javaex.ex02;

public class DigitalThread extends Thread{
	//field
	
	//editor
	
	//method g/s
	
	//method normal
	public void run() {
		
		for(int i = 0 ; i<30 ; i++) {
			System.out.println(i);
			
			try {//1초대기
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
