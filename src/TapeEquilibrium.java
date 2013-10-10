/*
 * Given an array A, find the minimum of:
 * 
 * the absolute difference between the sum of the first part and the sum of the second part.
 * for any index P in A
 */



public class TapeEquilibrium {
	
	public static void main(String[] args)
	{
		solution(new int[]{3,1,2,4,3});
	}
	
	public static int solution(int[] A) {
		
		//handle edge case
		if (A.length <= 1)
		{
			return -1;
		}
		
		int[] forward = new int[A.length-1];
		int[] backward = new int[A.length-1];
		int totalforward = 0;
		int totalbackward = 0;
		
		//go through the array both ways. 
		
		
		for (int i = 0; i < A.length -1; i++)
		{
			totalforward += A[i];
			forward[i] = totalforward;
			//System.out.println("forward: " + forward[i]);
		}
		
		for (int j = A.length-1; j > 0; j--)
		{
			totalbackward += A[j];
			backward[j-1] = totalbackward;
			//System.out.println("backward: " + backward[j-1]);
		} 
		//System.out.println("first forward: " + forward[0]);
		//System.out.println("first backward: " + backward[0]);
		int lowest = Math.abs(forward[0] - backward[0]);
		//System.out.println("LOWEST: " + lowest);
		for (int k = 1; k < A.length-1; k++)
		{
			int temp = Math.abs(forward[k] - backward[k]);
			
			if (temp < lowest)
				lowest = temp;
			
			//System.out.println("LOWEST: " + lowest);
		}
		
		return lowest;
	}
}
