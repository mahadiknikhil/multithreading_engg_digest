package test;


public class Program{
	public static void main(String[] args) {
		Counter counter = new Counter();
		MyThread t1 = new MyThread(counter);
		MyThread t2 = new MyThread(counter);
		MyThread t3 = new MyThread(counter);
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Count :"+counter.getCount());
	}
}
