import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2606 {
	static int N,K,map[][];
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean visited[];
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		map = new int[N][N];
		
		
		StringTokenizer st;
		for(int i=0;i<K;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start-1][end-1]=1;
			map[end-1][start-1]=1;
		}

		bfs(0);
		System.out.println(result);
	}

	static void bfs(int start)
	{
		q.add(start);
		visited[start]=true;
		
		while(!q.isEmpty())
		{
			int computer = q.poll();
			for(int i=1;i<N;i++)
			{
				if(visited[i]==false && map[computer][i]==1)
				{
					result++;
					visited[i]=true;
					q.add(i);
				}
			}
		}
	}
}
