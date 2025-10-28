package com.java.multithread;

public class MultiThread1 extends Thread {
	SyncThread syncThread = new SyncThread();
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is running");
		try {
			Thread.sleep(1000);
			syncThread.updatePrice(800, 30);
		}catch(InterruptedException ex) {
			System.out.println(ex.toString());
		}
		System.out.println(Thread.currentThread().getName()+" is executed successfully");
	}
}
