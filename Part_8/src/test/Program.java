package test;

//Thread Methods 
//start(), run(), sleep(), join(), setPriority(), interrupt(), yield(), setDaemon()

public class Program extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello WOrld");
		}
	}
	
	public static void main(String[] args) {
		Program t = new Program();
		t.setDaemon(true);
		t.start();
		System.out.println("Main Done...");
	}
}
