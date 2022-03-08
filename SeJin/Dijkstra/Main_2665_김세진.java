import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2665_김세진 {
	static int N,map[][],cnt[][];
	static boolean visited[][];
	static class location
	{
		int x,y;

		public location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int result=2501;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			String temp = br.readLine();
			Arrays.fill(cnt[i], 987654321);
			for(int j=0;j<N;j++)
				map[i][j]=temp.charAt(j)-'0';
		}
		
		bfs();
		System.out.println(cnt[N-1][N-1]);
		
	}
	
	static void bfs()
	{
		Queue<location> q = new LinkedList<>();
		cnt[0][0]=0;
		q.add(new location(0,0));
		while(!q.isEmpty())
		{
			location current = q.poll();
			int x = current.x;
			int y = current.y;
			
			for(int i=0;i<4;i++)
			{
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && ny >=0 && nx < N && ny < N && cnt[nx][ny]>cnt[x][y])
				{
					if(map[nx][ny]==0)
					{
						cnt[nx][ny]=cnt[x][y]+1;
						q.add(new location(nx,ny));
					}
					else
					{
						cnt[nx][ny]=cnt[x][y];
						q.offer(new location(nx,ny));
					}
				}
			}
		}
		
		
	}

}
