package test;

//Thread states : NEW, RUNNABLE, RUNNING, BLOCKED/WAITING, TERMINATED 

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("Running.....");
	}
}

public class Program {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		Thread.sleep(1000);
		System.out.println(t1.getState());
		t1.join();
		System.out.println(t1.getState());
	}
}
