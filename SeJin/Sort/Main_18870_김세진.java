

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_18870 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = 1000000001;
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int copy_arr[] = new int[N];
		int rank=0;

		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		for(int i=0;i<N;i++)
		{
			arr[i] = copy_arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
	
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++)
		{
			if(map.get(arr[i])==null)
				map.put(arr[i], rank++);
		}
        
		for(int i=0;i<arr.length;i++)
			//System.out.print(map.get(copy_arr[i])+" ");
			sb.append(map.get(copy_arr[i])).append(' ');
		
        System.out.println(sb);
	}

}

