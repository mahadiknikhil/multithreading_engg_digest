package test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//Executor Framework

public class Program{

	private static long factorial(int index) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		long result = 1;
		for(int i = 1; i <= index; i++) {
			result = result * i;
		}
		return result;
	}

	public static void main(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleWithFixedDelay(() -> {
			System.out.println("Task executed after every 5 seconds!");
		}, 5, 5, TimeUnit.SECONDS);
		
		scheduler.schedule(() -> {
			System.out.println("Initiating shutdown....");
			scheduler.shutdown();
		}, 20, TimeUnit.SECONDS);
	}
	
	public static void main12(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(() -> {
			System.out.println("Task executed after every 5 seconds !");
		}, 5, 5, TimeUnit.SECONDS);
		
		scheduler.schedule(() -> {
			System.out.println("Initiating shutdown....");
			scheduler.shutdown();
		}, 20, TimeUnit.SECONDS);
	}
	
	//ScheduledExecutorService
	public static void main11(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.schedule( () -> {
			System.out.println("Task executed after 5 seconds delay");
		}, 5, TimeUnit.SECONDS);
		
		scheduler.shutdown();
	}
	
	public static void main10(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return 42;
		});
		
		future.cancel(true);
		System.out.println(future.isCancelled());
		System.out.println(future.isDone());
		executorService.shutdown();
		System.out.println("Hello World");
	}
	
	public static void main9(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return 42;
		});
		
		Integer i = null;
		try {
			i = future.get(5, TimeUnit.SECONDS);
			System.out.println(future.isDone());
			System.out.println(i);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			Thread.currentThread().interrupt();
		}
		executorService.shutdown();
		System.out.println("Hello World");
	}
	
	public static void main8(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Callable<Integer> callable1 = ()->{
			Thread.sleep(1000);
			System.out.println("Task 1");
			return 1;
		};
		
		Callable<Integer> callable2 = () ->{
			Thread.sleep(1000);
			System.out.println("Task 2");
			return 2;
		};
		
		Callable<Integer> callable3 = () ->{
			Thread.sleep(1000);
			System.out.println("Task 3");
			return 3;
		};
		
		List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
		try {
			Integer i = executorService.invokeAny(list);
			
			System.out.println(i);
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
		}
		
		executorService.shutdown();
		System.out.println("Hello World");
	}
	
	public static void main7(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Callable<Integer> callable1 = ()->{
			Thread.sleep(1000);
			System.out.println("Task 1");
			return 1;
		};
		
		Callable<Integer> callable2 = () ->{
			Thread.sleep(1000);
			System.out.println("Task 2");
			return 2;
		};
		
		Callable<Integer> callable3 = () ->{
			Thread.sleep(1000);
			System.out.println("Task 3");
			return 3;
		};
		
		List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
		try {
			List<Future<Integer>> futures = executorService.invokeAll(list, 2, TimeUnit.SECONDS);
			
			for (Future<Integer> future : futures) {
				System.out.println(future.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
		}
		
		executorService.shutdown();
		System.out.println("Hello World");
	}
	
	public static void main6(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Callable<Integer> callable1 = ()->{
			Thread.sleep(1000);
			System.out.println("Task 1");
			return 1;
		};
		
		Callable<Integer> callable2 = () ->{
			Thread.sleep(1000);
			System.out.println("Task 2");
			return 2;
		};
		
		Callable<Integer> callable3 = () ->{
			Thread.sleep(1000);
			System.out.println("Task 3");
			return 3;
		};
		
		List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
		try {
			List<Future<Integer>> futures = executorService.invokeAll(list);
			
			for (Future<Integer> future : futures) {
				System.out.println(future.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
		}
		
		executorService.shutdown();
		System.out.println("Hello World");
	}
	
	public static void main5(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> future = executorService.submit(() -> 1+2);
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public static void main4(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<?> future = executorService.submit(() -> System.out.println("Hello World"));
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
		}
		
		executorService.shutdown();
	}
	
	
	public static void main3(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(() -> 42);
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
		}
		executorService.shutdown();
	}
	
	public static void main2(String[] args) {
		long startTime = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(9);
		for(int i = 0; i < 10; i++) {
			int index = i;
			executorService.submit(() -> {
				long result = factorial(index);
				System.out.println(result);
			});
		}
		
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Total time : "+(System.currentTimeMillis() - startTime));
	}

	public static void main1(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.submit(() -> System.out.println("Hello WOrld"));
		
		executorService.shutdown();
		
	}
	
}
