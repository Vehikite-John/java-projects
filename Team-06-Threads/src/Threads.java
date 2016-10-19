// My version of Team 06 Threads assignment

/**
 * super abstract class with num, name, and
 * an abstract run() method
 * 
 * @author John Vehikite
 *
 */
abstract class Counter implements Runnable {
	int num = 0;
	String name = "";
	public abstract void run();
}

/**
 * subclass of Counter that counts evenly
 * 
 * @author John Vehikite
 *
 */
class CounterEven extends Counter {
	int num = 2;
	String name = "Counter Even";
	
	// count to 100 evenly, taking a 100 milli
	// break between counts
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

/**
 * subclass of Counter that counts by oddly
 * 
 * @author John Vehikite
 *
 */
class CounterOdd extends Counter {
	int num = 1;
	String name = "Counter Odd";
	
	// count to 100 oddly, taking a 100 milli
	// break between counts
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

/**
 * per directions, create a class that prints out "running..." every
 * second
 * 
 * @author John Vehikite
 *
 */
class ThreadTimer implements Runnable {
	
	// sentinel to stop while loop below
	Boolean isFinished = false;
	
	void setIsFinished() {
		isFinished = true;
	}
	
	@Override
	public void run() {
		
		while (!isFinished) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println("running...");
		}
	}
}

public class Threads {

	public static void main(String[] args) throws InterruptedException {
		// create objects of each task
		CounterEven cEven = new CounterEven();
		CounterOdd cOdd = new CounterOdd();
		ThreadTimer tTimer = new ThreadTimer();
		
		// have each task on its own thread
		Thread te = new Thread(cEven);
		Thread to = new Thread(cOdd);
		Thread tt = new Thread(tTimer);
		
		// start the threads
		te.start();
		to.start();
		tt.start();
		
		// join() waits until threads complete tasks to continue
		// with the program
		te.join();
		to.join();
		
		// signal that counters are finished counting
		tTimer.setIsFinished();
		
		// wait until tt is complete
		tt.join();
		
		// we did it!
		System.out.println("All finished");
	}
}