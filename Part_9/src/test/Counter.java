package test;

public class Counter {

	private int count;
	
	public int getCount() {
		return count;
	}
	
	public synchronized void increment() {
		count++;
	}
}
