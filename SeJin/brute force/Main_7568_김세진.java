

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class B_7568 {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		for(int i=0;i<N;i++)
		{
			String[] temp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(temp[0]);
			arr[i][1] = Integer.parseInt(temp[1]);
		}
		
		for(int i=0;i<N;i++)
		{
			int rank=1;
			
			for(int j=0;j<N;j++)
			{
				if(i==j) continue;
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
				{
					rank++;
				}
			}
			System.out.println(rank + " ");
			
		}
		
	}

}
