package Chapter7;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

	public static void main(String[] args) 
	{
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		Runnable run1 = () -> System.out.println("Hello zoo");
		Callable<String> task = () -> "Monkey";
	
		Future<?> future1 = service.schedule(run1,5,TimeUnit.SECONDS);
		Future<?> future2 = service.schedule(task, 5, TimeUnit.MINUTES);
		
		service.scheduleAtFixedRate(run1, 0, 5, TimeUnit.MINUTES);
		service.scheduleWithFixedDelay(run1,  0,  2,  TimeUnit.MINUTES);
	}

}
