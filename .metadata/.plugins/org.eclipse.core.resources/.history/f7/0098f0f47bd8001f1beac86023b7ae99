package test1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//CyclicBarrier
class SubSystem implements Runnable{
	private String name;
	private int initializationTime;
	private CyclicBarrier barrier;
	
	public SubSystem(String name, int initializationTime, CyclicBarrier barrier) {
		this.name = name;
		this.initializationTime = initializationTime;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + "initialization started");
			Thread.sleep(initializationTime);
			System.out.println(name+" initialization complete");
			barrier.await();
		}catch(InterruptedException  | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
	
	
}


public class Program{
	public static void main(String[] args) {
		int numberOfServices = 4;
		
		CyclicBarrier barrier = new CyclicBarrier(numberOfServices, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("All subsystems are up and running. System startup completed");
				
			}
		});
		
		Thread webServerThread = new Thread(new SubSystem("WebServer", 2000, barrier));
		Thread dataBaseThread = new Thread(new SubSystem("Database", 4000, barrier));
		Thread cacheThread = new Thread(new SubSystem("Cache", 3000, barrier));
		Thread messagingThread = new Thread(new SubSystem("MessagingService", 3500, barrier));
		
		webServerThread.start();
		dataBaseThread.start();
		cacheThread.start();
		messagingThread.start();
	}
}
