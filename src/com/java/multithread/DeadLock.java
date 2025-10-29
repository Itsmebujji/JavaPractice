package com.java.multithread;

public class DeadLock {
	
	private static final String obj1 = "vineeth";
	private static final String obj2 = "bujji";

	public static void main(String[] args) {
		
		Thread t1 = new Thread(
			()->{
				System.out.println(Thread.currentThread().getName()+" is running");
				System.out.println(Thread.currentThread().getName()+" checking lock available on obj1......");
				synchronized(obj1) {
					System.out.println(Thread.currentThread().getName()+" acquired lock on obj1");
					System.out.println(Thread.currentThread().getName()+" checking lock available for obj2......");
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						System.out.println(e.toString());
					}
					if(!Thread.holdsLock(obj2)) {
						System.out.println(Thread.currentThread().getName()+" lock not available for obj2 which hold by another thread");
					}
					synchronized(obj2) {
						System.out.println(Thread.currentThread().getName()+" acquired lock on obj2");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							System.out.println(e.toString());
						}
					}
					System.out.println(Thread.currentThread().getName()+" release lock on obj2");
				}
				System.out.println(Thread.currentThread().getName()+" release lock on obj1");
				System.out.println(Thread.currentThread().getName()+" successfully executed");
			}, "Thread-1"
		);
		
		t1.start();

		
		Thread t2 = new Thread(
				()->{
					System.out.println(Thread.currentThread().getName()+" is running");
					System.out.println(Thread.currentThread().getName()+" checking lock available on obj2......");
					synchronized(obj2) {
						System.out.println(Thread.currentThread().getName()+" acquired lock on obj2");
						System.out.println(Thread.currentThread().getName()+" checking lock available for obj1......");
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							System.out.println(e.toString());
						}
						if(!Thread.holdsLock(obj1)) {
							System.out.println(Thread.currentThread().getName()+" lock not available for obj1 which hold by another thread");
						}
						synchronized(obj1) {
							System.out.println(Thread.currentThread().getName()+" acquired lock on obj1");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								System.out.println(e.toString());
							}
						}
						System.out.println(Thread.currentThread().getName()+" release lock on obj1");	
					}
					System.out.println(Thread.currentThread().getName()+" release lock on obj2");
					System.out.println(Thread.currentThread().getName()+" successfully executed");
				}, "Thread-2"
			);
			
			t2.start();
	}

}
