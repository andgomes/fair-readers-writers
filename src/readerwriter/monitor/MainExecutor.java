package readerwriter.monitor;

import readerwriter.monitor.Readers;
import readerwriter.monitor.Writers;

public class MainExecutor {

	public static void main(String[] args) throws InterruptedException {

		ReadWriteController rwController = new ReadWriteController();
		
		System.out.println("Somente processos readers...");
		
		new Readers(rwController);

		Thread.sleep(5000);

		System.out.println("Processos writers começam a pedir acesso...");
		
		new Writers(rwController);

	}

}
