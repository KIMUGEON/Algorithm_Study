import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14889 {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int[] start;
	static int[] link;
	static int min=2001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		visited = new boolean[N];
		start = new int[N/2];
		link = new int[N/2];
		
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println(min);
	}
	static void dfs(int start_idx,int cnt)
	{
		if(cnt == N/2)
		{
			int start_member = 0;
			int link_member = 0;
			for(int i=0;i<N;i++)
			{
				if(visited[i]==true)
					start[start_member++]=i;
				else
					link[link_member++]=i;
			}
			int start_score = 0;
			int link_score = 0;
			for(int i=0;i<start.length;i++)
			{
				for(int j=i;j<start.length;j++)
				{
					if(i==j)
						continue;
					else
					{
						int member = start[i];
						int partner = start[j];
						start_score += (map[member][partner]+ map[partner][member]);
						member = link[i];
						partner = link[j];
						link_score += (map[member][partner]+ map[partner][member]);
					}
				}
			}
			
			if(min > Math.abs(start_score - link_score))
			{
				min= Math.abs(start_score - link_score);
			}
		}
		else
		{
			for(int i=start_idx;i<N;i++)
			{
				visited[i]=true;
				cnt++;
				dfs(i+1,cnt);
				if(min==0)
					return;
				visited[i]=false;
				cnt--;
			}
		}
	}
}
