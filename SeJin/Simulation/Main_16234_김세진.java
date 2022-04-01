import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_김세진 {
	public static class location
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
	static int N,L,R,map[][];
	static int copy_map[][];
	static int result=0;
	static Queue<location> q = new LinkedList<>();
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		copy_map = new int[N][N];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				copy_map[i][j] = map[i][j];
			}
		}
		
		while(solve()) // bfs를 돌릴 수 있는 환경인지 확인해 돌릴 수 있으면 무한 반복 => 인구이동을 할 수 있다는 뜻
		{
			
		}
		System.out.println(result-1);
		
		
	}
	
	private static boolean solve() {
		result++; // 인구이동 횟수 증가
		boolean check = false;
		visited = new boolean[N][N]; 
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<4;k++)
				{
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny]==false)
					{
						int gap = Math.abs(map[i][j]- map[nx][ny]); // 두 나라사이의 인구차이가 L이상 R이하일때
						if(L <= gap && gap <= R)
						{
							q.offer(new location(i,j)); //bfs돌리기 위해 q에 넣기
							bfs();
							check= true;
						}
					}
				}
			}
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j] = copy_map[i][j];
		return check;
	}

	public static void bfs()
	{
		
		boolean checked[][] = new boolean[N][N]; //현재 찾은 나라에서 근접한 bfs만 돌리므로 따로checked라는 visited성질을 갖는 배열 생성
		int cnt = 0;
		int sum = 0;
		while(!q.isEmpty())
		{
			location temp = q.poll();
			visited[temp.x][temp.y]=true; // 해당 bfs가 끝나고 같은 지점을 다시 확인하지 않기위해
			checked[temp.x][temp.y]=true; // 현재  bfs를 위한 checked배열
			cnt++; // 인구 합칠 나라 카운트
			sum+=copy_map[temp.x][temp.y]; // 인구합
			for(int i=0;i<4;i++)
			{
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny]==false)
				{
					
					int gap = Math.abs(copy_map[temp.x][temp.y]- copy_map[nx][ny]); // 기존의 map이 영향을 받지 않도록 copy_map에 bfs적용
					if(L <= gap && gap <= R)
					{
						visited[nx][ny]=true;
						checked[nx][ny]=true;
						q.offer(new location(nx,ny));
					}
				}
			}
		}
		
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(checked[i][j]==true) //check된 부분은 들린 부분으로 인구를 합쳐야함
					copy_map[i][j] = sum/cnt; // 인구합/합칠나라로 값 재할당
			}
		}
	}

}
