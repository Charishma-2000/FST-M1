import java.util.Arrays;

public class Activity4 {
	public static void main (String [] args)
	{
		int [] arr= {6,3,2,1,5};
		int i;
		int j;
		int key;
		System.out.println("Before sorting: "+Arrays.toString(arr));
		
		for (i=1;i<arr.length;i++)
		{
			key = arr[i];
			j=i-1;
			
			while(j>=0 && arr[j]>key)
			{
				arr[j+1]= arr[j];
				j=j-1;
			}
			arr[j+1]=key;	
		}
		
		System.out.println("After sorting: "+Arrays.toString(arr));
		
	}

}
