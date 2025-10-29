package com.java.multithread;

public class ThreadStates {
	
	private static final String obj = "Vineeth";
	private static final String obj1 = "Vineeth";
	
	public static void main(String[] args) {
		
		
		/*
		 * Detailed Flow Explanation:
		 * 
		 * Thread-1 acquires the shared lock first and goes to sleep for 3 seconds.
		 * - During this time, it’s in the TIMED_WAITING state but still holds the lock.
		 * Thread-2 starts next, but cannot acquire the lock (since Thread-1 holds it).
		 * - It enters the BLOCKED state.
		 * Thread-3 starts after 1 second delay and also tries to acquire the same lock.
		 * - It becomes BLOCKED as well.
		 * After 3 seconds, Thread-1 finishes and releases the lock.
		 * - The JVM scheduler randomly selects one of the waiting threads to continue.
		 * Thread-3 happens to acquire the lock next.
		 * - It enters TIMED_WAITING due to sleep(1000) and then completes execution.
		 * Thread-2 finally gets the lock after Thread-3 releases it.
		 * - It runs for 3 seconds and completes last.
		 * 
		 * Important Observations:
		 * 
		 * All three threads are alive concurrently, but only one executes the synchronized block at a time.
		 * The BLOCKED and TIMED_WAITING states appear exactly as expected in the log output.
		 * Lock acquisition order is not guaranteed — the JVM’s thread scheduler decides which waiting thread proceeds next.
		 * Because obj and obj1 are the same string literal, the synchronized blocks are effectively serialized.
		 * 
		 * 
		 * Sometimes you want threads to execute in a predetermined order rather than relying on JVM scheduling. 
		 * This can be done using the monitor wait/notify mechanism.
		 * 
		 * Concept:
		 * Each thread waits on a shared object until it is notified.
		 * Only the notified thread can acquire the lock and continue execution.
		 * This allows controlled sequencing: for example, Thread-1 -> Thread-2 -> Thread-3.
		 * 
		 */
		
		
		Thread m1 = new Thread(()->{
			System.out.println(Thread.currentThread().getName()+" is running");
			try {
				synchronized(obj1) {
					Thread.sleep(3000);
				}
			}catch(InterruptedException ex) {
				System.out.println(ex.toString());
			}
			System.out.println(Thread.currentThread().getName()+" is executed successfully");
		},"Thread-1");
		m1.start();
		
		
		Thread m2 = new Thread(()->{
			System.out.println(Thread.currentThread().getName()+" is running");
			try {
				synchronized(obj) {
					Thread.sleep(3000);
				}
			}catch(InterruptedException ex) {
				System.out.println(ex.toString());
			}
			System.out.println(Thread.currentThread().getName()+" is executed successfully");
		},"Thread-2");
		m2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Thread m3 = new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+" is running");
				synchronized(obj) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+" is executed successfully");
			}, "Thread-3"	
		);
		
		System.out.println("State-1: "+ m3.getState());
		m3.start();
		System.out.println("State-2: "+ m3.getState());
		try {
			while(m3.isAlive()) {
				System.out.println("State-3: "+ m3.getState());
				Thread.sleep(500);
			}
			m3.join();
			System.out.println("State-4: "+ m3.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

