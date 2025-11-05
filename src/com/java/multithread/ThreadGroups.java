package com.java.multithread;

public class ThreadGroups {

	public static void main(String[] args) {
		
		ThreadGroup systemGroup = Thread.currentThread().getThreadGroup().getParent();
		System.out.println("Group Name: "+ systemGroup.getName());
		
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("Group Name: "+ mainGroup.getName());
		
		ThreadGroup childGroup = new ThreadGroup(mainGroup,"childThread");
		System.out.println("Group Name: "+ childGroup.getName());
		
		
		Thread t1 = new Thread(childGroup, ()->{System.out.println();}, "ChildThread-1");
		Thread t2 = new Thread(childGroup, ()->{}, "ChildThread-2");
		t1.start();
		t2.start();		
		
	}

}
