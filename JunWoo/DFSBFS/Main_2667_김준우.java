package _0215_DFSBFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2667_김준우 {
	static int N, areanum;
	static int[] area = new int[25*25];	//행 : 단지번호, 0열 : 단지별 집의 수
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		areanum = 0;
		
		//첫번째줄 입력
		for(int n = 0;n<N;n++) {
			String st = br.readLine();
			for(int m = 0;m<N;m++) {
				map[n][m] = st.charAt(m)-'0';
			}
		}
		
		//차례대로 탐색
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					areanum++;
					dfs(i,j);
				}
			}
		}
		
		System.out.println(areanum);
		Arrays.sort(area);
		for(int i = 0; i<area.length;i++) {
			if(area[i] != 0)
				System.out.println(area[i]);
		}
		
		
		
	}
	
	public static void dfs(int r, int c) {
		int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};//상하좌우
		
		visit[r][c] = true;
		area[areanum]++;
		
		for(int d = 0; d<4;d++) {	//d가 탐색 방향도 나타냄
			int next_r = r + dir[d][0];	//탐색 행
			int next_c = c + dir[d][1];	//탐색 열
			if(next_r >= 0 && next_r < N && next_c >= 0 && next_c < N) {
				if(map[next_r][next_c] == 1 && !visit[next_r][next_c]) {
					dfs(next_r,next_c);
				}
			}
		}
	}

}
