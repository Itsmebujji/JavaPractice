package com.java.multithread;

public class ThreadCreation {

	public static void main(String[] args) {
		
		ExtendThread t1 = new ExtendThread();
		t1.setName("Thread-1");
		t1.start();
		
		Thread t2 = new Thread(new RunnableThread(), "Thread-2");
		t2.start();

	}

}
