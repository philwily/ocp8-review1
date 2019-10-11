package iteration;

public class PrintTriangle
{
	public static void main(String[] args)
	{
		int input = 4;
		for (int i = 0; i < input; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("================================");
		//rows should contain 2n-1 asterisks
		//rows should have 2n indent
		// * * * * * * *
		//   * * * * *
		//     * * *
		//       *
		for (int i = input; i >= 0; i--)
		{
			for (int j = 2 * i - 1; j> 0; j--)
			{
				int indentation = j * 
				if (j  input - i)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}			
	}
}