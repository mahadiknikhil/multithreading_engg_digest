package test;

//Thread Methods 
//start(), run(), sleep(), join(), setPriority(), interrupt(), yield(), setDaemon()

public class Program extends Thread{
	@Override
	public void run() {
		for(int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName()+" is running");
			Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		Program p1 = new Program();
		Program p2 = new Program();
		
		p1.start();
		p2.start();
	}
}
