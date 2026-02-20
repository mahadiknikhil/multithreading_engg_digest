package test;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//CyclicBarrier

class DependantService implements Callable<String>{

	private final CyclicBarrier barrier;
	
	public DependantService(CyclicBarrier barrier) {
		this.barrier = barrier;
	}



	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" service started");
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName()+" is waiting at the barrier");
		barrier.await();
		System.out.println("Wait done");
		return "OK";
	}
	
}

public class Program{

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int numberOfServices = 3;
		
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
		
		CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
		
		executorService.submit(new DependantService(barrier));
		executorService.submit(new DependantService(barrier));
		executorService.submit(new DependantService(barrier));
		
		System.out.println("Main");
		executorService.shutdown();
		barrier.reset();
	}
}
