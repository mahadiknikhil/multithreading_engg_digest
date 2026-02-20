package test;

//Thread Methods 
//start(), run(), sleep(), join(), setPriority(), interrupt(), yield(), setDaemon()

public class Program extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Thread is running....");
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted "+e);
		}
	}
	
	
	public static void main(String[] args){
		Program t1 = new Program();
		t1.start();
		t1.interrupt();
	}
}
