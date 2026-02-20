package test;

class World extends Thread{
	@Override
	public void run() {
		for( ; ;) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}

public class Program {

	public static void main(String[] args) {
		World world = new World();
		world.start();
		
		for( ; ; ) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
