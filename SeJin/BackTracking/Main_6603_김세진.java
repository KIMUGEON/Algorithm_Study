import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_김세진 {
	static int S[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int N = Integer.parseInt(st.nextToken());
			if(N==0)
				break;
			S = new int[N];
			for(int i=0;i<N;i++)
				S[i] = Integer.parseInt(st.nextToken());
			
			dfs(0,new int[6], N, new boolean[N]);
			System.out.println();
		}
		
	}

	static void dfs(int cnt, int[] lotto, int N, boolean visited[])
	{
		if(cnt==6)
		{
			for(int i=0;i<cnt;i++)
				System.out.print(lotto[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++)
		{
			if(visited[i]==false)
			{
				visited[i]=true;
				if(cnt==0)
				{
					lotto[cnt]=S[i];
					dfs(cnt+1,lotto,N,visited);
				}
				else if(cnt-1>=0 && lotto[cnt-1]<S[i])
				{
					lotto[cnt]=S[i];
					dfs(cnt+1,lotto,N,visited);
				}
				visited[i]=false;
			}
		}
	}
	
	
}
