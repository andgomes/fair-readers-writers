package readerwriter.semaphore;

public class MainExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		new Readers();
		
		Thread.sleep(3000);
		
		new Writers();
		
	}
	
}
