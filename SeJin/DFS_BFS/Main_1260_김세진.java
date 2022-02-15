import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited_dfs;
	static boolean[] visited_bfs;
	static int N,M,map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		int start = Integer.parseInt(st.nextToken())-1; //시작번호
		System.out.print((start+1)+" ");
		visited_dfs = new boolean[N];
		visited_bfs = new boolean[N];
		
		map = new int[N][N];
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int vertex1 = Integer.parseInt(st.nextToken())-1;
			int vertex2 = Integer.parseInt(st.nextToken())-1;
			
			map[vertex1][vertex2]=1;
			map[vertex2][vertex1]=1;
		} //간선연결
		
		visited_dfs[start]=true;
		dfs(start);
		System.out.println();
		System.out.print((start+1)+" ");
		bfs(start);
	}

	static void dfs(int start)
	{
		for(int i=0;i<N;i++)
		{
			if(map[start][i]==1 && visited_dfs[i]==false)
			{
				visited_dfs[i]=true;
				System.out.print((i+1)+" ");
				dfs(i);
			}
				
		}
		
	}
	
	static void bfs(int start)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited_bfs[start]=true;
		
		while(!q.isEmpty())
		{
			int temp = q.poll();
			
			for(int i=0;i<N;i++)
			{
				if(map[temp][i]==1 && visited_bfs[i]==false)
				{
					System.out.print((i+1)+" ");
					visited_bfs[i]=true;
					q.add(i);
				}
			}
		}
	}
}
