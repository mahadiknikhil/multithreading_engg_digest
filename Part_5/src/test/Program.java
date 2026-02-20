package test;

//Thread Methods 

class MyThread extends Thread{
	
	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		int count = 0;
		for(int i = 0; i < 5 ; i++) {
			String a = "";
			
			for(int j = 0; j<10000; j++) {
				a  = a + "a";
			}
			count++;
			System.out.println(Thread.currentThread().getName()+" Priority :"+Thread.currentThread().getPriority()+" Count :"+ count);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Program {

	public static void main(String[] args){
		MyThread l = new MyThread("Low Priority Thread");
		MyThread m = new MyThread("Medium Priority Thread");
		MyThread h = new MyThread("High Priority Thread");
		
		l.setPriority(Thread.MIN_PRIORITY);
		m.setPriority(Thread.NORM_PRIORITY);
		h.setPriority(Thread.MAX_PRIORITY);
		
		l.start();
		m.start();
		h.start();
	}
}
