package iteration;

public class Depth
{
	public static void main(String[] args)
	{
		              //0  1  2   3  4  5  6   7  8   9  
		int[] input = { 0, 1, 3, -2, 0, 1, 0, -3, 2 , 3};
		// pits
		// 
		System.out.println("FINAL: Max Depth: " + depth(input));
		
		
		int[] input2 = {0, -2, 2 };
		
		System.out.println("FINAL: Max Depth: " + depth(input2));
	}

	public static int depth(int[] A)
	{
		int depth = -1;
		if (A != null && A.length > 0)
		{
			int P = 0;
			int Q = -1;
			int R = -1;
			
			
			for (int i = 1; i < A.length; i++)
			{
				System.out.println("A[" + i + "] >= A[" + (i-1) + "]: " + A[i] + " >= " + A[i-1]);
				// decreasing. set Q if already increasing
				if (Q == -1  && A[i] >= A[i-1])
				{
					Q = i-1;
				}
			
				//if (Q != -1)
				if (Q != -1 && A[i] <= A[i-1])
				{
					R = i-1;					
				}
				
				if (R == -1 && A.length == i+1)
				{
					R = i;
					System.out.println("HERE");
				}
				
				if (Q != -1 && R != -1)
				{
					//if (P != Q ) //|| Q != R)
					//System.out.println("P,Q: " + P + "," + Q);
					System.out.println("P,Q,R: " + P + "," + Q + "," + R);
					
					int depth1 = A[P]-A[Q];
					int depth2 = A[R]-A[Q];
					System.out.println("DEPTH: " + depth1 + ", " + depth2);
					int minDepth = Math.min(depth1,depth2);
					System.out.println("Min Depth: " + minDepth);
					
					depth = Math.max(minDepth, depth);
					//reset
					P = i-1;
					Q = -1;
					R = -1;
				}
			}
		}
			
		return depth;
	}
}