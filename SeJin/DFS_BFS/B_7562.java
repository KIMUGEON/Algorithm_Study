import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7562 {

	static int N,start_x,start_y,target_x,target_y,map[][];
	static int dx[]= {-2,-1,1,2,2,1,-2,-1};
	static int dy[]= {1,2,2,1,-1,-2,-1,-2};
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<t;tc++)
		{
			N = Integer.parseInt(br.readLine());
			map=new int[N][N];
			visited = new boolean[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			target_x = Integer.parseInt(st.nextToken());
			target_y = Integer.parseInt(st.nextToken());
			
			bfs(start_x,start_y);
		}

	}
	public static class temp
	{
		int x,y,cnt;
		temp() {};
		temp(int x,int y, int cnt)
		{
			this.x=x;
			this.y=y;
			this.cnt = cnt;
		}
	}
	static void bfs(int x, int y)
	{
		Queue<temp> q = new LinkedList<temp>();
		temp xyCnt = new temp(x,y,0);
		q.add(xyCnt);
		visited[x][y]=true;
		
		while(!q.isEmpty())
		{
			int temp_x = q.peek().x;
			int temp_y = q.peek().y;
			int result = q.peek().cnt;
			q.poll();
			if(temp_x ==target_x && temp_y == target_y)
			{
				System.out.println(result);
				return;
			}
			for(int i=0;i<8;i++)
			{
				int nx = temp_x + dx[i];
				int ny = temp_y + dy[i];
				if(nx >= 0 && ny >= 0 && ny < N && nx < N)
				{
					if(visited[nx][ny]==false)
					{
						visited[nx][ny]=true;
						temp input = new temp(nx,ny,result+1);
						q.add(input);
					}
				}
			}
		}
	}
}
