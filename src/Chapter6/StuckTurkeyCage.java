package Chapter6;

public class StuckTurkeyCage implements AutoCloseable
{
	private String name;
	
	public StuckTurkeyCage(String name)
	{
		this.name = name;
	}
	
	public void close()
	{
		System.out.println(name + " closing...");
		throw new IllegalStateException(name+ " Cage door not closed");
	}
	
	public static void main(String... args)
	{
		try (StuckTurkeyCage cage = new StuckTurkeyCage("CAGE 1 ");
			 StuckTurkeyCage cage2 = new StuckTurkeyCage("CAGE 2 ")) 
		{
			System.out.println("put turkeys in");
			throw new IllegalArgumentException("turkeys ran off");
		}
//		catch (IllegalStateException | IllegalArgumentException e)
//		{
//			System.out.println("CAUGHT: " + e.getClass() + " " + e.getMessage());
//			
//			for (Throwable t : e.getSuppressed())
//			{
//				System.out.println(t.getClass() + " " + t.getMessage());
//			}
//		}
		finally 
		{
			throw new RuntimeException("and we couldn't find them");
		}
	}
}
