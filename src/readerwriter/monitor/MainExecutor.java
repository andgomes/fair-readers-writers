package readerwriter.monitor;

import readerwriter.monitor.Readers;
import readerwriter.monitor.Writers;

public class MainExecutor {

	public static void main(String[] args) throws InterruptedException {

		ReadWriteController rwController = new ReadWriteController();
		
		new Readers(rwController);

		Thread.sleep(3000);

		new Writers(rwController);

	}

}
