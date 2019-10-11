package Chapter1;

public enum Season {
	WINTER("Low")
	{
		public void printHours()
		{
			System.out.println("9am-3pm");
		}
		
		public void printExtendedHours()
		{
			System.out.println("Short hours");
		}
	}, 
	SPRING("Medium")
	{
		public void printHours()
		{
			System.out.println("9am-5pm");
		}
	}, 
	SUMMER("High")
	{
		public void printHours()
		{
			System.out.println("9am-7pm");
		}
		
		public void printExtendedHours()
		{
			System.out.println("Long hours");
		}
	}, FALL("Medium")
	{
		public void printHours()
		{
			System.out.println("9am-5pm");
		}
	};
	
	private String expectedVisitors;
	
	private Season(String expectedVisitors)
	{
		this.expectedVisitors = expectedVisitors;
		System.out.println("Creating " +  this.name());
	}
	
	public void printExpectedVisitors()
	{
		System.out.println(expectedVisitors);
	}
	
	public abstract void printHours();
	
	public void printExtendedHours()
	{
		System.out.println("default hours");
	}
}
