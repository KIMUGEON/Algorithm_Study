package _0315_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_김준우 {
	static int N, result;
	static int[][] map;
	static int[] dr = {0,1,1};	//오른쪽, 아래, 대각선
	static int[] dc = {1,0,1};	//오른쪽, 아래, 대각선
	
	public static void move(int r, int c, int pos) {	//pos : 가로 세로 대각선
		if(r == N-1 && c == N-1) {
			result++;
			return;
		}
		//오른쪽으로 이동
		if(pos != 1) {	//세로가 아니면
			int nr = r; int nc = c+1;
			if(nc < N && map[nr][nc] == 0) {
				move(nr,nc,0);
			}
		}
		
		//아래로 이동
		if(pos != 0) {	//가로가 아니면
			int nr = r+1; int nc = c;
			if(nr < N && map[nr][nc] == 0) {
				move(nr,nc,1);
			}
		}
		
		//대각선 이동
		int nr = r+1; int nc = c+1;
		if(nr < N && nc < N && map[r][nc] == 0 && map[nr][c] == 0 && map[nr][nc] == 0) {
			move(nr,nc,2);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		result = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(0,1,0);
		
		System.out.println(result);
	}

}
