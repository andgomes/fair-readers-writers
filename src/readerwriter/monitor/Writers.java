package readerwriter.monitor;

public class Writers implements Runnable {

	private ReadWriteController rwController;
	
	public Writers(ReadWriteController rwController) {

		Thread t = new Thread(this);
		this.rwController = rwController;
		
		t.start();

	}

	public void run() {
		
		while (true) {
			
			try {
				
				rwController.requestWrite();
				
				System.out.println("Writing the database");
				
				// Simulação do tempo de escrita
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				rwController.releaseWrite();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
