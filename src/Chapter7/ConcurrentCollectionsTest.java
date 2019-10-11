package Chapter7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.Deque;
import java.util.Map;
import java.util.Queue;


public class ConcurrentCollectionsTest {

	public static void main(String[] args) 
	{
		ConcurrentCollectionsTest.testConcurrentHashMap();
		ConcurrentCollectionsTest.testConcurrentLinkedQueue();
		ConcurrentCollectionsTest.testConcurrentLinkedDeque();
		ConcurrentCollectionsTest.testLinkedBlockingQueue();
		ConcurrentCollectionsTest.testLinkedBlockingDeque();
	}
	
	public static void testConcurrentHashMap()
	{
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("zebra", 52);
		map.put("elephant", 10);
		
		System.out.println(map.get("elephant"));
	}
	
	public static void testConcurrentLinkedQueue()
	{
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(31);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
	}

	public static void testConcurrentLinkedDeque()
	{
		Deque<Integer> queue = new ConcurrentLinkedDeque<>();
		queue.offer(10);
		queue.push(4);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
	}
	
	public static void testLinkedBlockingQueue()
	{
		try
		{
			BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
			queue.offer(39);
			queue.offer(3, 4, TimeUnit.SECONDS);
		
			System.out.println(queue.poll());
			System.out.println(queue.poll(4, TimeUnit.SECONDS));
		}
		catch (InterruptedException e) {}
	}
	
	public static void testLinkedBlockingDeque()
	{
		try
		{
			// 5 91 47 3
			BlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
			queue.offer(91);
			queue.offerFirst(5, 2, TimeUnit.MINUTES);
			queue.offerLast(47, 100, TimeUnit.MICROSECONDS);
			queue.offer(3, 4, TimeUnit.SECONDS);
			
			System.out.println(queue.poll()); // 5
			System.out.println(queue.poll(950, TimeUnit.MILLISECONDS)); //91
			System.out.println(queue.pollLast(1, TimeUnit.SECONDS)); // 3
			System.out.println(queue.pollFirst(200, TimeUnit.NANOSECONDS)); //47
		}
		catch (InterruptedException e) {}
	}
}
