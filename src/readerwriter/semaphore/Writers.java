package readerwriter.semaphore;

import static readerwriter.semaphore.SharedVariables.dr;
import static readerwriter.semaphore.SharedVariables.dw;
import static readerwriter.semaphore.SharedVariables.e;
import static readerwriter.semaphore.SharedVariables.nw;
import static readerwriter.semaphore.SharedVariables.r;
import static readerwriter.semaphore.SharedVariables.w;

public class Writers implements Runnable {

	public Writers() {

		Thread t = new Thread(this);
		t.start();

	}

	public void run() {

		while (true) {
		
			try {
	
				e.acquire();
	
				if (dr > 0) {
	
					dw++;
					e.release();
					w.acquire();
	
				}
	
				nw++;
	
				e.release();
	
				System.out.println("Writing the database");
	
				e.acquire();
	
				nw--;
	
				if (dr > 0) {
	
					while (dr > 0) {
						dr--;
						r.release();
					}
	
				} else if (dw > 0) {
					dw--;
					w.release();
				} else {
					e.release();
				}
	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}

	}

}
