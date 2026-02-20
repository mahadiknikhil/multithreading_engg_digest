package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program{
	private final Lock lock = new ReentrantLock(true);
	
	public void accessResource() {
		lock.lock();
		System.out.println(Thread.currentThread().getName()+" acquired the lock");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			System.out.println(Thread.currentThread().getName()+" released the lock");
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Program p = new Program();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				p.accessResource();
			}
		};
		
		Thread t1 = new Thread(task, "Thread 1");
		Thread t2 = new Thread(task, "Thread 2");
		Thread t3 = new Thread(task, "Thread 3");
		
		try {
			t1.start();
			Thread.sleep(50);
			t2.start();
			Thread.sleep(50);
			t3.start();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}
}
