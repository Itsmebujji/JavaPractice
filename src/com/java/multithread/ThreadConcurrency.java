package com.java.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadConcurrency {
	
	static CountDownLatch latch;

	public static void main(String[] args) {
		
		// 1. CountDownLatch
		
		/*
		 * A CountDownLatch allows one or more threads to wait until a set of operations being performed in other threads completes.
		 * It has a counter initialized with a number (say N).
		 * Each time a thread completes a task, it calls countDown(), reducing the counter by 1.
		 * Threads waiting on the latch call await() and block until the counter reaches 0.
		 * Use Case:
		 * Waiting for multiple threads to complete before continuing (e.g., main thread waiting for worker threads).
		 * 
		 */
		ExecutorService executor = Executors.newFixedThreadPool(3);
		latch = new CountDownLatch(3);
		executor.submit(() -> {
	        for (int i = 1; i <= 3; i++) {
	            int id = i;
	            new Thread(() -> {
	                System.out.println("Worker " + id + " started.");
	                try {
	                    Thread.sleep(1000 * id); // simulate work
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("Worker " + id + " finished.");
	                latch.countDown(); // Decrement count
	            }).start();
	        }

	        System.out.println("Main thread waiting...");
	        try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Wait for all threads to finish
	        System.out.println("All workers finished. Main thread continues.");
		});
		
		
		// 2. BlockingQueue
		
		/*
		 * A BlockingQueue is a thread-safe queue that blocks when:
		 * A thread tries to add an element to a full queue, or
		 * A thread tries to remove an element from an empty queue.
		 * Implementations include:
		 *    ArrayBlockingQueue
		 *    LinkedBlockingQueue
		 *    PriorityBlockingQueue
		 * Use Case:
		 * Producer-Consumer problem — one or more producers put items in the queue, and consumers take items from it.
		 * 
		 */
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    System.out.println("Produced: " + i);
                    queue.put(i); // Blocks if queue is full
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer value = queue.take(); // Blocks if queue is empty
                    System.out.println("Consumed: " + value);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        
        


	
	}

}
