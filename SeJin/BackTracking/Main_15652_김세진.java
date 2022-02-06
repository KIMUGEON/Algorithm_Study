import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15652_김세진 {

	static int N,M;
	static int arr[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N];
		dfs(0);
		System.out.print(sb);
		
	}
	static void dfs(int cnt)
	{
		
		if(cnt == M)
		{
			for(int i=0;i<M;i++)
			{
				for(int j=i+1;j<M;j++)
				{
					if(arr[i] > arr[j])
					{
						return;
					}
				}
			}
			for(int i=0;i<M;i++)
			{
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
		}
		else
		{
			for(int i=1;i<=N;i++)
			{
				visited[i-1]=true;
				arr[cnt]=i;
				dfs(cnt+1);
				visited[i-1]=false;
			}
		}
	}

}
