package Chapter7;

import java.util.ArrayList;
import java.util.List;

public class WhaleDataCalculator 
{
	public int processRecord(int input)
	{
		try
		{
			Thread.sleep(10);
		}
		catch (InterruptedException e) {}
		return input+1;
	}
	
	public void processAllData(List<Integer> data)
	{
		//data.stream().map(a->processRecord(a)).count();
		data.parallelStream().map(a->processRecord(a)).count();
	}
	
	public static void main(String[] args) 
	{
		WhaleDataCalculator calc = new WhaleDataCalculator();
		
		//define
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i < 4000; i++)
		{
			data.add(i);
		}
		
		//process
		long start = System.currentTimeMillis();
		calc.processAllData(data);
		double time = (System.currentTimeMillis()-start)/1000;
		
		// results
		System.out.println("Tasks completed in: " + time + " seconds");
	}

}
