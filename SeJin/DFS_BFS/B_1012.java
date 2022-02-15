import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1012 {
	static int N,M,map[][];
	static boolean visited[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0;t<tc;t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			int K = Integer.parseInt(st.nextToken());
			for(int i=0;i<K;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			int result=0;
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(map[i][j]==1)
					{
						dfs(i,j);
						result++;
					}
			
			System.out.println(result);
		}
	}
	
	static void dfs(int x, int y)
	{
		//visited[x][y]=true;
		map[x][y]=0;
		for(int i=0;i<4;i++)
		{
			int nx = x +dx[i];
			int ny = y +dy[i];
			
			if(nx >= 0 && ny >= 0 && nx <N && ny < M)
			{
				if(map[nx][ny] == 1)
				{
					dfs(nx,ny);
				}
			}
		}
	}
}

