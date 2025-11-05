package com.java.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPools {

	public static void main(String[] args) {
		ExecutorService executor1 = Executors.newFixedThreadPool(2);
		ExecutorService executor2 = Executors.newSingleThreadExecutor();
		ExecutorService executor3 = Executors.newCachedThreadPool();
		ScheduledExecutorService executor4 = Executors.newScheduledThreadPool(2);
		ScheduledExecutorService executor5 = Executors.newSingleThreadScheduledExecutor();
		
		Future<String> f1 = executor1.submit(()->{return "vineeth";});
		Future<String> f2 = executor2.submit(()->{return "vineeth";});
		Future<String> f3 = executor3.submit(()->{return "vineeth";});
		Future<String> f4 = executor4.submit(()->{return "vineeth";});
		Future<String> f5 = executor5.submit(()->{return "vineeth";});
		try {
			System.out.println("F1: "+f1.get());
			System.out.println("F2: "+f2.get());
			System.out.println("F3: "+f3.get());
			System.out.println("F4: "+f4.get());
			System.out.println("F5: "+f5.get());
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println(ex.toString());
		}
		
	}

}
