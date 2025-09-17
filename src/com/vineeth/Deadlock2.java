package com.vineeth;

public class Deadlock2 extends Thread {
	public Object obj1;
	public Object obj2;
	public Deadlock2(Object obj1, Object obj2){
		this.obj1=obj1;
		this.obj2=obj2;
	}
	@Override
	public void run(){
		synchronized(obj2){
			System.out.println("Obj2 got lock by thread2");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				throw new RuntimeException(ex);
			}
			synchronized(obj1){
				System.out.println("Obj1 got lock by thread2");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException ex){
					throw new RuntimeException(ex);
				}
			}
		}
		System.out.println("Thread2 successfully executed");
	}
}
