package com.java.multithread;

public class RunnableThread implements Runnable {
	

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is running");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" is executed successfully");
	}

}
