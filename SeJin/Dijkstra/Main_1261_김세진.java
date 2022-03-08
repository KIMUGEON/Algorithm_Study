import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261_김세진 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static class location implements Comparable<location>
	{
		int x,y,value;

		public location(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}
		@Override
		public int compareTo(location o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		
		for(int i=0;i<N;i++)
		{
			String temp = br.readLine();
			for(int j=0;j<M;j++)
				map[i][j] = temp.charAt(j)-'0';
		}
		
		PriorityQueue<location> pq = new PriorityQueue<>();
		boolean visited[][] = new boolean[N][M];
		int distance[][] = new int[N][M];
		for(int i=0;i<N;i++)
			Arrays.fill(distance[i], 987654321);
		distance[0][0]=0;
		pq.add(new location(0,0,0));
		visited[0][0]=true;
		while(!pq.isEmpty())
		{
			location temp = pq.poll();
			int x = temp.x;
			int y = temp.y;
			int dis = temp.value;
			visited[x][y]=true;
			for(int i=0;i<4;i++)
			{
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny]==false)
				{
					if(distance[nx][ny] > dis + map[nx][ny])
					{
						distance[nx][ny] = dis+map[nx][ny];
						pq.add(new location(nx,ny,distance[nx][ny]));
					}
				}
			}
		}
		
		System.out.println(distance[N-1][M-1]);
		
	}

}
