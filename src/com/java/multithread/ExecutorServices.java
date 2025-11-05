package com.java.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServices {

	public static void main(String[] args) {
		
		// Executor interface 
		
		Executor executor1 = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
            int taskId = i;
            executor1.execute(() -> System.out.println("Task " + taskId + " in " + Thread.currentThread().getName()));
        }
        
		// ExecutorService 
		// 1. FixedThreadPool
        
		ExecutorService executorService1 = Executors.newFixedThreadPool(1);
		Future<Integer> result1 = executorService1.submit(
			() -> {
				return 30;
			}
		);
		
		try {
			System.out.println("Result: "+result1.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.toString());
		}
        
		// 2. CachedThreadPool
		
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
            int taskId = i;
            executorService2.submit(() -> {
            		System.out.println("Task " + taskId + " in " + Thread.currentThread().getName());
            		try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            	}
            );
        }
		executorService2.shutdown();
		
		// 3. SingleThreadExecutor
		
		ExecutorService executorService3 = Executors.newSingleThreadExecutor();

		executorService3.submit(() -> System.out.println(Thread.currentThread().getName() + " running"));
		executorService3.shutdown();
		
		// 4. ScheduledThreadPool
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

		scheduler.schedule(() -> System.out.println("Run after delay"), 3, TimeUnit.SECONDS);

		scheduler.scheduleAtFixedRate(
		    () -> System.out.println("Run every 2 seconds"), 
		    1, 2, TimeUnit.SECONDS
		);
		
		// 5. newSingleThreadScheduledExecutor
		
		ScheduledExecutorService scheduler1 = Executors.newSingleThreadScheduledExecutor();

		scheduler1.scheduleAtFixedRate(
		    () -> System.out.println("Single scheduler running"),
		    1, 2, TimeUnit.SECONDS
		);

		// 6. Custom ThreadPoolExecutor
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
			    2,                      // corePoolSize
			    4,                      // maximumPoolSize
			    60, TimeUnit.SECONDS,   // keepAliveTime
			    new LinkedBlockingQueue<>(100), // task queue
			    Executors.defaultThreadFactory(),
			    new ThreadPoolExecutor.AbortPolicy() // rejection handler
			);
		
		executor.submit(() -> System.out.println(Thread.currentThread().getName() + " running"));
		executor.shutdown();
		
	}
	
	
	/*
	 * Here are 3-4 top options you could pick, one for each domain (Tableau + Informatica):
	 * “Tableau Server 2019.1 Administration” (Udemy) – for Tableau Server admin.
	 * “Tableau Server / Site Administration” official Tableau training – for deeper official/admin path.
	 * “Informatica PowerCenter Administration” (Udemy) – for Informatica admin basics & advanced.
	 * “Informatica Platform Administration Fundamentals” (Informatica University) – for enterprise/production scale admin tasks
	 */

}
