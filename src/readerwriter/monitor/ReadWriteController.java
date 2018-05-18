package readerwriter.monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadWriteController {

	private Lock lock = new ReentrantLock();
	private Condition oktoread = lock.newCondition();
	private Condition oktowrite = lock.newCondition();
	
	private int nw = 0;
	private int nr = 0;
	
	private int dw = 0;
	private int dr = 0;
	
	public void requestRead() throws InterruptedException {
		
		lock.lock();
		
		try {
			
			if (nw > 0 || dw > 0) {
				
				++dr;
				oktoread.await();
				--dr;
				
			}
			
			nr = nr + 1;
			
		} finally {
			lock.unlock();
		}
		
	}
	
	public void releaseRead() {
		
		lock.lock();
		
		try {
			
			nr = nr - 1;
			
			if (dw > 0) oktowrite.signal();
			
		} finally {
			lock.unlock();
		}
		
	}
	
	public void requestWrite() throws InterruptedException {
		
		lock.lock();
		
		try {
			
			if (nr > 0 || nw > 0 || dr > 0) {
				
				++dw;
				oktowrite.await();
				--dw;
				
			}
			
			nw = nw + 1;
			
		} finally {
			lock.unlock();
		}
		
	}
	
	public void releaseWrite() {
		
		lock.lock();
		
		try {
			
			nw = nw - 1;
			
			if (dr > 0) oktoread.signalAll();
			
		} finally {
			lock.unlock();
		}
		
	}
	
}
