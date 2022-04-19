import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_21608 {
	static int N, map[][];
	static int dx[]= {-1,1,0,0}, dy[] = {0,0,-1,1};
	static int favorite[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		favorite = new int[N*N][4]; //좋아하는 학생 
		for(int i=0;i<N*N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int student = Integer.parseInt(st.nextToken()); //학생
			
			for(int j=0;j<4;j++)
				favorite[student-1][j]=Integer.parseInt(st.nextToken()); //해당 학생이 좋아하는 학생 배열
			
			solve(student, favorite[student-1]); // 학생 순서마다 배치하기
		}
		
		int result=0;
		for(int x=0;x<N;x++)
			for(int y=0;y<N;y++)
			{
				int cnt=0;
				for(int i=0;i<4;i++)
				{
					int nx = x+dx[i];
					int ny = y+dy[i];
					//4방탐색해서 좋아하는 학생 수 세기
					if(nx >= 0 && ny >= 0 && nx < N && ny < N)
					{
						for(int j=0;j<4;j++)
							if(favorite[map[x][y]-1][j] == map[nx][ny])
								cnt++;
					}
					
				}
				if(cnt==0) //없으면 0
					continue;
				else //있으면 1, 10, 100, 1000순서 이므로 차례대로 10의0승, 10의1승, 10의2승, 10의3승
					result+=Math.pow(10, cnt-1);
			}
			System.out.println(result);

	}
	private static void solve(int student, int[] favorite) {
		int adj_favorite_cnt = -1; //좋아하는 학생이 근접해 있는 수 (현재기준 가장 많은 수)
		int adj_zero_cnt=-1; // 비어있는 자리가 근접해 있는 수 (현재기준 가장 많은 수)
		int r=0,c=0; // 최종적으로 배치할 좌표
		
		//전체 맵 탐색
		for(int x=0;x<N;x++)
			for(int y=0;y<N;y++)
			{
				if(map[x][y]==0) //빈자리일 경우
				{
					int favorite_cnt = 0; //인접 좋아하는 학생 체크용
					int zero_cnt=0; // 인접 빈자리 체크용
					for(int i=0;i<4;i++)
					{
						int nx = x+dx[i]; //4방탐색
						int ny = y+dy[i];
						
						if(nx >=0 && ny >= 0 && nx < N && ny < N)
						{
							if(map[nx][ny]==0)
								zero_cnt++;// 빈자리일 경우 zero_cnt++
							else
							{
								for(int j=0;j<4;j++)//빈자리가 아닐경우 4방탐색한 곳이 좋아하는 학생일 경우
								{
									if(favorite[j]==map[nx][ny])
										favorite_cnt++;
								}
							}
							if(adj_favorite_cnt < favorite_cnt) //현재까지 나온 근접 좋아하는 학생보다 지금 자리가 더 많을 경우
							{
								adj_favorite_cnt=favorite_cnt; //근접 좋아하는 학생 갱신
								adj_zero_cnt = zero_cnt; // 근접 빈자리 갱신 (다음에 같은 좋아하는 학생 수가 나올 때 빈자리로 비교해야하므로)
								r = x;
								c = y;
							}
							else if(adj_favorite_cnt == favorite_cnt) //같을 경우는 빈자리를 비교해야함
							{
								if(adj_zero_cnt < zero_cnt) //현재까지 나온 빈자리 보다 지금 자리의 근처에 빈자리가 더 많을경우
								{
									adj_zero_cnt = zero_cnt; //빈자리 개수 갱신
									r=x;
									c=y;
								}
							}
						}
						
					}
				}
			}
		map[r][c] = student;
	}

}
