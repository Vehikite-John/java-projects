import java.util.TimerTask;

abstract class Counter implements Runnable {
	int num = 0;
	String name = "";
	public abstract void run();
}

class CounterEven extends Counter {
	int num = 2;
	String name = "Counter Even";
	
	public void run() {
		while (num <= 100) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(name + " is at " + num);
			num += 2;
		}
	}
}

class CounterOdd extends Counter {
	int num = 1;
	String name = "Counter Odd";
	
	public void run() {
		while (num < 100) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(name + " is at " + num);
			num += 2;
		}
	}
}

class ThreadTimer extends TimerTask implements Runnable {
	@Override
	public void run() {
		for (;;) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				return;
			}
			System.out.println("running...");
		}
	}
}

public class Threads {

	public static void main(String[] args) throws InterruptedException {
		Runnable cEven = new CounterEven();
		Runnable cOdd = new CounterOdd();
		Runnable tTimer = new ThreadTimer();
		Thread te = new Thread(cEven);
		Thread to = new Thread(cOdd);
		Thread tt = new Thread(tTimer);
		te.start();
		to.start();
		tt.start();
		te.join();
		to.join();
		tt.interrupt();
		System.out.println("All finished");
	}
}

// First time writing a superclass and subclasses
//abstract class Counter implements Runnable {
//	int num = 0;
//	String name = "";
//	public void run()
//	{
//		go();
//	}
//	public void go()
//	{
//		try {
//			Thread.sleep(100);
//		}
//		catch(InterruptedException ex) {
//			ex.printStackTrace();
//		}
//		count();
//	}
//	
//	public abstract void count();
//}
//
//class CounterEven extends Counter {
//	int num = 2;
//	String name = "Counter Even";
//	
//	public void count() {
//		System.out.println(name + " is at " + num);
//		num += 2;
//	}
//}
//
//class CounterOdd extends Counter {
//	int num = 1;
//	String name = "Counter Odd";
//	
//	public void count() {
//		System.out.println(name + " is at " + num);
//		num += 2;
//	}
//}
