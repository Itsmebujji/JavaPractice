package com.java.multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		// CyclicBarrier
		
		/*
		 * Concept:
		 * A CyclicBarrier allows a set of threads to wait for each other to reach a common barrier point.
		 * The barrier is cyclic, meaning it can be reused after the waiting threads are released.
		 * Use Case:
		 * Coordinating multiple threads to perform tasks in phases (e.g., simulation steps).
		 * 
		 */
		
		int threadCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
            System.out.println("All threads reached the barrier. Continuing...");
        });

        for (int i = 1; i <= threadCount; i++) {
            int id = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + id + " is working...");
                    Thread.sleep(1000 * id);
                    System.out.println("Thread " + id + " reached barrier.");
                    barrier.await(); // wait for others
                    System.out.println("Thread " + id + " continues after barrier.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
	}

}
