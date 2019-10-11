package Chapter7;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class AmbiguousLambdaSample 
{
	public static void useCallable(Callable<Integer> expression){}
	public static void useSupplier(Supplier<Integer> expression){}	
	
	public static void use(Callable<Integer> expression) {}
	public static void use(Supplier<Integer> expression) {}
	
	public static void main(String... args)
	{
		useCallable(()-> {throw new IOException();});
		//useSupplier(()-> {throw new IOException();});
		use((Callable<Integer>)()->{throw new IOException();});
		
		ExecutorService service = null;
		try
		{
			service = Executors.newSingleThreadExecutor();	
			service.submit(()->{throw new IOException();});
		}
		finally 
		{
			if (service != null)
				service.shutdown();
		}
		
	}
	
}
