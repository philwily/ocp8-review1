package Chapter7;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManager 
{
	private Map<String, Object> foodData = new ConcurrentHashMap<>();
	
	public void put(String key, Object value)
	{
		foodData.put(key, value);
	}
	
	public Object get(String key)
	{
		return foodData.get(key);
	}
	
	public static void main(String[] args) 
	{
		//Map<String, Object> foodData = new HashMap<String, Object>();
		Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		for(String key: foodData.keySet())
			System.out.println(foodData.remove(key));
	}

}
