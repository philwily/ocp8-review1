package Chapter7;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
//import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager 
{
	private static int sheepCount = 0;
	//private AtomicInteger sheepCount = new AtomicInteger(0);
	
	private void incrementAndReport()
	{
		synchronized (this)
		{
			System.out.print(++sheepCount + " ");
		}
		//System.out.print(sheepCount.incrementAndGet() + " ");
	}
	
	private synchronized void incrementAndReport2()
	{
		System.out.print(++sheepCount + " ");
	}
	
	private static void printDaysWork()
	{
		synchronized (SheepManager.class)
		{
			System.out.println("Finished: " + sheepCount);
		}
	}
	
	public static void main(String[] args) 
	{
		ExecutorService service = null;
		try
		{
			service = Executors.newFixedThreadPool(20);
			SheepManager manager = new SheepManager();
			
			for (int i = 0; i < 10; i++)
				service.submit(()->manager.incrementAndReport2());
		}
		finally
		{
			if (service != null)
				service.shutdown();
		}
		SheepManager.printDaysWork();
		
	}

}
