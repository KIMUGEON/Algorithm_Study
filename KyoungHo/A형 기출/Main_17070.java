/*
  [입력]
첫째 줄에 집의 크기 N(3 ≤ N ≤ 16)이 주어진다. 
둘째 줄부터 N개의 줄에는 집의 상태가 주어진다. 
빈 칸은 0, 벽은 1로 주어진다. (1, 1)과 (1, 2)는 항상 빈 칸이다.

  [출력]
첫째 줄에 파이프의 한쪽 끝을 (N, N)으로 이동시키는 방법의 수를 출력한다. 
이동시킬 수 없는 경우에는 0을 출력한다. 방법의 수는 항상 1,000,000보다 작거나 같다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {//파이프 옮기기1
	
	static int N,map[][],cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		=============================  입력   ======================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //맵 크기
		
		
		StringTokenizer st;
		map = new int[N+1][N+1]; //맵 입력, 0 안씀
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		=============================  풀이   ======================================
		cnt=0; //끝까지 이동시키는 방법의 개수
		dfs(1,2,0); //초기 파이프는 (1,1),(1,2) 차지하고 있음
		
//		=============================  출력   ======================================
		System.out.println(cnt);
	}

//	===================== dfs ========================
	private static void dfs(int x, int y, int dir) {
		if(x==N && y==N) { //끝까지 이동하면 카운트
			cnt++;
			return;
		}
		
		if(dir==0) { //파이프가 가로
			if(y+1<=N && map[x][y+1]==0) { //가로로 이동
				dfs(x,y+1,0);
			}
			if(x+1<=N && y+1<=N && map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0) { //대각선으로 이동
				dfs(x+1,y+1,2);
			}
		}
		
		else if(dir==1) { //파이프가 세로
			if(x+1<=N && map[x+1][y]==0) {//세로로 이동
				dfs(x+1,y,1);
			}
			if(x+1<=N && y+1<=N && map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0) { //대각선으로 이동
				dfs(x+1,y+1,2);
			}
		}
		
		else if(dir==2) { //파이프가 대각선
			if(y+1<=N && map[x][y+1]==0) { //가로로이동
				dfs(x,y+1,0);
			}
			if(x+1<=N && map[x+1][y]==0) { //세로로이동
				dfs(x+1,y,1);
			}
			if(x+1<=N && y+1<=N && map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0) { //대각선으로 이동
				dfs(x+1,y+1,2);
			}
		}
		
	}

}
