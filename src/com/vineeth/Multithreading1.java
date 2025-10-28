package com.vineeth;

public class Multithreading1 extends Thread{

	public void run() {
		System.out.println("Thread is running");
		System.out.println("Thread: "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
}
