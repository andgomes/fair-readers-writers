package readerwriter.semaphore;

public class MainExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Somente processos readers...");
		
		new Readers();
		
		Thread.sleep(5000);
		
		System.out.println("Processos writers a começam pedir acesso...");
		
		new Writers();
		
	}
	
}
