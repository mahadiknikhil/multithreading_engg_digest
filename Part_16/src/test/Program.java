package test;

//Thread using Lambda expression 

public class Program{

	public static void main(String[] args) {
		Student s = () -> "Nikhil";
		
		System.out.println(s.getStudentName());
	}
	
	public static void main2(String[] args) {
		Thread t = new Thread( ()-> System.out.println("Hello"));
		
		t.start();
	}
	
	public static void main1(String[] args) {
		Thread t = new Thread( ()-> {
			System.out.println("Hello");
		});
		
		t.start();
	}
	
}
