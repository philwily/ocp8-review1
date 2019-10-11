package Chapter7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResults 
{
	private static int counter = 0;
	
	public static void main(String[] args) throws TimeoutException, ExecutionException, InterruptedException
	{
		ExecutorService service = null;
		try
		{
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(()-> {
				for (int i = 0; i < 100; i++)
					System.out.println(++counter);
				return "1";
			});
			System.out.println("Result: " + result.get(10, TimeUnit.SECONDS));
			System.out.println("REACHED");
		}
		finally
		{
			if (service != null)
				service.shutdown();
		}
		
		if (service != null)
		{
			service.awaitTermination(1,  TimeUnit.MINUTES);
			if (service.isTerminated())
			{
				System.out.println("All Tasks finished");
			}
			else
			{
				System.out.println("At least one task is still running");
			}
		}
	}

}
