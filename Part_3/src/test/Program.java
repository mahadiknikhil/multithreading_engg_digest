package test;

class World implements Runnable{

	@Override
	public void run() {
		for( ; ; ) {
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	
}

public class Program {

	public static void main(String[] args) {
		World world = new World();
		Thread t = new Thread(world);
		t.start();
		
		for( ; ; ) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
