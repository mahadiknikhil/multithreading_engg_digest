package test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

	int balance = 1000;
	private final Lock lock = new ReentrantLock();
	
	public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+amount);
		try {
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
				if(balance >= amount) {
					System.out.println(Thread.currentThread().getName()+" proceeding with withdrawl");
					try {
						Thread.sleep(3000);
						balance -= amount;
						
						System.out.println(Thread.currentThread().getName()+" completed withdrawl.Remaining balance :"+balance);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}finally {
						lock.unlock();
					}
				}else {
					System.out.println(Thread.currentThread().getName()+" Insufficient balance");
				}
			}else {
				System.out.println(Thread.currentThread().getName() + " could not acquire the lock will try later");
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}
	
}
