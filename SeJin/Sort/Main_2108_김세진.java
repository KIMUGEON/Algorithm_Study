

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B_2108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++)
		{
			 arr[i] = sc.nextInt();
		}
		double avg = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int max=-4001;
		int min=4001;
		int max_fre=0;
		for(int i=0;i<N;i++)
		{
			avg+=arr[i];
			if(map.get(arr[i])==null)
				map.put(arr[i], 0);
			else
			{
				map.put(arr[i], map.get(arr[i])+1);
				if(max_fre < map.get(arr[i]))
					max_fre = map.get(arr[i]);
			}
			if(arr[i]>max)
				max = arr[i];
			if(arr[i]<min)
				min = arr[i];
		}
		
		List<Integer> arrlist = new ArrayList<>();
		for(int key : map.keySet())
		{
			if(map.get(key) == max_fre)
			{
				arrlist.add(key);
			}
		}
		int most_fre=0;
		if(arrlist.size()==1)
		{
			most_fre=arrlist.get(0);
		}
		else
		{
			Collections.sort(arrlist);
			most_fre= arrlist.get(1); 
		}
		Arrays.sort(arr);
		
		System.out.printf("%.0f\n", avg/N);
		System.out.println(arr[N/2]);
		System.out.println(most_fre);
		System.out.println(max - min);

	}

}
