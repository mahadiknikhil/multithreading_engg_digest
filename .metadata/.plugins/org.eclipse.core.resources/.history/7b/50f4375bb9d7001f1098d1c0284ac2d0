package test1;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//CountDownLatech

class DependantService implements Callable<String>{

	private final CountDownLatch latch;
	
	public DependantService(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public String call() throws Exception {
		try{
			System.out.println(Thread.currentThread().getName()+" service started");
			Thread.sleep(2000);
		}finally {
			latch.countDown();
		}
		return "OK";
	}
	
}

public class Program{

	public static void main(String[] args) throws InterruptedException{
		int numberOfServices = 3;
		
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
		CountDownLatch latch = new CountDownLatch(numberOfServices);
		executorService.submit(new DependantService(latch));
		executorService.submit(new DependantService(latch));
		executorService.submit(new DependantService(latch));
		latch.await();
		
		System.out.println("Main");
		executorService.shutdown();
	}
}
