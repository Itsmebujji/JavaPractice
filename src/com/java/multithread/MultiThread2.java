package com.java.multithread;

public class MultiThread2 implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is running");
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {
			System.out.println(ex.toString());
		}
		System.out.println(Thread.currentThread().getName()+" is executed successfully");
	}

}
