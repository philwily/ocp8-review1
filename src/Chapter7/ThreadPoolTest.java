package Chapter7;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;;

public class ThreadPoolTest {

	public static void main(String[] args) 
	{
		ExecutorService pool1 = Executors.newSingleThreadExecutor();
		ExecutorService pool2 = Executors.newCachedThreadPool();
		ExecutorService pool3 = Executors.newFixedThreadPool(5);
		
		ScheduledExecutorService pool4 = Executors.newSingleThreadScheduledExecutor();
		ScheduledExecutorService pool5 = Executors.newScheduledThreadPool(5);
	}

}
