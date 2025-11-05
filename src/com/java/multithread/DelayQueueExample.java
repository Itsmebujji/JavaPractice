package com.java.multithread;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample implements Delayed {
	
	/*
	 * Concept:
	 * A DelayQueue is a special kind of BlockingQueue where elements can be taken only after a specific delay has expired.
	 * Each element must implement the Delayed interface.
	 * Use Case:
	 * Task scheduling, caching, retry mechanisms — any situation where you want to delay processing of elements.
	 * 
	 */

	private final long startTime;
    private final String taskName;

    public DelayQueueExample(String taskName, long delayInMillis) {
        this.taskName = taskName;
        this.startTime = System.currentTimeMillis() + delayInMillis;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "Task[" + taskName + "]";
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayQueueExample> delayQueue = new DelayQueue<>();

        delayQueue.put(new DelayQueueExample("Task 1", 2000)); // 2 seconds
        delayQueue.put(new DelayQueueExample("Task 2", 4000)); // 4 seconds
        delayQueue.put(new DelayQueueExample("Task 3", 1000)); // 1 second

        while (!delayQueue.isEmpty()) {
        	DelayQueueExample task = delayQueue.take(); // blocks until delay expires
            System.out.println("Executed: " + task + " at " + System.currentTimeMillis());
        }
    }
}
