package readerwriter.semaphore;

import java.util.concurrent.Semaphore;

public class SharedVariables {

	public static int nr = 0;
	public static int nw = 0;
	
	public static Semaphore e = new Semaphore(1);
	public static Semaphore r = new Semaphore(0);
	public static Semaphore w = new Semaphore(0);
	
	public static int dr = 0;
	public static int dw = 0;
	
}
