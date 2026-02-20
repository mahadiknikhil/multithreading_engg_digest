package test;


public class Program{
	
	public static void main(String[] args) {
		BankAccount sbi = new BankAccount();
		Runnable task =  new Runnable() {
			
			@Override
			public void run() {
				sbi.withdraw(500);
			}
		};
		
		Thread t1 = new Thread(task, "Thread 1");
		Thread t2 = new Thread(task, "Thread 2");
		
		t1.start();
		t2.start();
	}
	
}
