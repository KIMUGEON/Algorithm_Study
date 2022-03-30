import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14503 {
	static int x,y, map[][];
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	static boolean visited[][];
	static int cnt = 0;
	static class robot
	{
		int x,y,direction;

		// 로봇 좌표, 방향
		public robot(int x, int y, int direction) {
			super();
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int robotX = Integer.parseInt(st.nextToken());
		int robotY = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		map = new int[x][y];
		visited = new boolean[x][y];
		for(int i=0;i<x;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<y;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//로봇 첫 좌표 등록
		visited[robotX][robotY]=true;
		cnt++;
		dfs(robotX, robotY, direction);	//dfs돌리기
	}
	
	static void dfs(int rx, int ry, int direction)
	{	
		for(int i=0;i<4;i++)
		{
			int nd = (direction+3-i)%4; // 현재 바라보고 있는 방향의 왼쪽이므로 반시계방향
			int nx = rx + dx[nd]; 
			int ny = ry + dy[nd];
			
			if(nx >= 0 && ny >= 0 && nx < x && ny < y && map[nx][ny]==0 && visited[nx][ny]==false) //벽아니고, 들리지 않았을 경우
			{
				visited[nx][ny]=true;
				cnt++;
				dfs(nx,ny,nd); // 그 방향으로 한칸 전진
			}
		}
		
		int back = (direction+2)%4; // 현재바라보고 있는 방향의 반대로 가면 후진이 됨.
		int nx = rx+dx[back];
		int ny = ry+dy[back];
		if(nx >= 0 && ny >= 0 && nx < x && ny < y && map[nx][ny]==0) // 벽이 아닌경우
			dfs(nx,ny,direction); //후진
		else
			System.out.println(cnt); //후진도 안될경우 횟수 출력하고 종료
			System.exit(0);
	}
}
