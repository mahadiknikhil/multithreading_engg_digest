package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Program{
	
	private int count = 0;
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	
	public void increment() {
		writeLock.lock();
		try {
			count++;
		}finally {
			writeLock.unlock();
		}
	}
	
	public int getCount() {
		readLock.lock();
		try {
			return count;
		}finally {
			readLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Program p = new Program();
		
		Runnable readTask = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+" read :"+p.getCount());
				}
				
			}
		};
		
		Runnable writeTask = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					p.increment();
					System.out.println(Thread.currentThread().getName()+" incremented");
				}
			}
		};
		
		Thread writeThread = new Thread(writeTask, "WriteThread");
		Thread readThread1 = new Thread(readTask, "ReadThread1");
		Thread readThread2 = new Thread(readTask, "ReadThread2");
		
		writeThread.start();
		readThread1.start();
		readThread2.start();
		
		try {
			writeThread.join();
			readThread1.join();
			readThread2.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Final count :"+p.getCount());
	}
}
