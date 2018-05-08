package readerwriter;

import static readerwriter.SharedVariables.nr;
import static readerwriter.SharedVariables.e;
import static readerwriter.SharedVariables.r;
import static readerwriter.SharedVariables.w;
import static readerwriter.SharedVariables.dr;
import static readerwriter.SharedVariables.dw;

public class Readers implements Runnable {
	
	public Readers() {
		
		Thread t = new Thread(this);
		t.start();
		
	}
	
	public void run() {
		
		while (true) {
			
			try {
				
				e.acquire();
				
				if (dw > 0) {
					
					dr++;
					e.release();
					r.acquire();
					
				}
				
				nr++;
				
				e.release();
				
				System.out.println("Reading the database");
				
				e.acquire();
				
				nr--;

				if (dw > 0) {
					dw--; w.release();
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
