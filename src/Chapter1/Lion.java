package Chapter1;

public class Lion extends Animal {
	private int idNumber;
	private int age;
	private String name = "Leo";
	
	public Lion(int idNumber, int age, String name)
	{
		super(name, age, 'L');
		this.idNumber = idNumber;

	}
	
	@Override
	public void play() 
	{
		System.out.println("toss in meat");
	}
	
	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(idNumber);
		sb.append(", Name: ");
		sb.append(name);
		sb.append(", Age: ");
		sb.append(age);
		
		return sb.toString();
	}
	
	@Override public boolean equals(Object obj)
	{
		if (!(obj instanceof Lion)) return false;
		Lion otherLion = (Lion) obj;
		return this.idNumber == otherLion.idNumber;
	}
	
	@Override public int hashCode()
	{
		return idNumber;
	}
}
