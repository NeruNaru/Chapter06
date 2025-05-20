package com.javaex.ex03;

public class UpperThread extends Thread{
	//대문자
	//method normal
	public void run() {
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
