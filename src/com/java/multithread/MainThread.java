package com.java.multithread;

public class MainThread {

	public static void main(String[] args) {
		SyncThread obj1 = new SyncThread();
		MultiThread1 m1 = new MultiThread1();
		m1.setName("Extend Thread");
		m1.start();
		Thread m2 = new Thread(new MultiThread2(),"Runnable Thread");
		m2.start();
		Thread m3 = new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+" is running");
				synchronized(obj1) {
					obj1.updatePrice(1000, 20);
				}
				System.out.println(Thread.currentThread().getName()+" is executed successfully");
			}, "Lamda Function Thread"
				
		);
		m3.start();
		try {
			m3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

