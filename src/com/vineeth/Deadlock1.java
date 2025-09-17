package com.vineeth;

public class Deadlock1 extends Thread {
	public Object obj1;
	public Object obj2;
	public Deadlock1(Object obj1, Object obj2){
		this.obj1=obj1;
		this.obj2=obj2;
	}
	@Override
	public void run(){
		synchronized(obj1){
			System.out.println("Obj1 got lock by thread1");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				throw new RuntimeException(ex);
			}
			synchronized(obj2){
				System.out.println("Obj2 got lock by thread1");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException ex){
					throw new RuntimeException(ex);
				}
			}
		}
		System.out.println("Thread1 successfully executed");
	}
}
