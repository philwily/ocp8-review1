package Chapter6;

public class Assertion 
{
	public static void main(String... args)
	{
		int n = 5;
		//assert n < 0: "OhNo";
		//assert (n < 0): "OhNo";
		assert n < 0: ("OhNo");
	}
}
