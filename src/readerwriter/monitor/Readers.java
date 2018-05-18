package readerwriter.monitor;

public class Readers implements Runnable {

	private ReadWriteController rwController;
	
	public Readers(ReadWriteController rwController) {

		Thread t = new Thread(this);
		this.rwController = rwController;
		
		t.start();

	}

	public void run() {
		
		while (true) {
			
			try {
				
				rwController.requestRead();
				
				System.out.println("Reading the database");
				
				// Simulação do tempo de leitura
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				rwController.releaseRead();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
