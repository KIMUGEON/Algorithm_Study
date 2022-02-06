import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_김세진 {

	static int maxValue = -1000000001;
	static int minValue = 1000000001;
	static int N;
	static int operator[] = new int[4];
	static int arr[];
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr=new int[N];
		
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;i++)
		{
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++)
		{
			dfs(arr[0],1);
		}
		System.out.println(maxValue);
		System.out.println(minValue);
	}
	static void dfs(int result, int cnt)
	{
		if(cnt==N)
		{
			if(result > maxValue)
				maxValue = result;
			else if(result < minValue)
				minValue=result;
		}
		for(int i=0;i<4;i++)
		{
			if(operator[i]>0)
			{
				operator[i]--;
				
				if(i==0)
					dfs(result+arr[cnt],cnt+1);
				else if(i==1)
					dfs(result-arr[cnt],cnt+1);
				else if(i==2)
					dfs(result*arr[cnt],cnt+1);
				else if(i==3)
					dfs(result/arr[cnt],cnt+1);
				
				operator[i]++;
			}
		}
	}
}
