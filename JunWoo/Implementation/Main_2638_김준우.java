package _0510_Class4_김준우;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2638_김준우 {
	static int N, M, size;	//가로크기, 세로크기, 치즈의 크기
	static int[][] arr, touch;	//현재 치즈상태, 접촉된 면의 개수
	static boolean[][] visited;
	
	//사방탐색
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc< 0 || nr>=N || nc>=M) continue;
			if(visited[nr][nc]) continue;
			if(arr[nr][nc] == 0) {
				dfs(nr,nc);
			}
			else {
				touch[nr][nc]++;
			}
		}
	}
	
	public static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int temp = touch[i][j];
				if(temp>=2) {
					arr[i][j] = 0;
					size --;
				}
			}
		}
	}
	
	public static void print(int[][] ar) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(ar[i]));
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		size = 0;
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(st.nextToken());
				arr[i][j] = val;
				if(val>0) size++;
			}
		}
		
		int cnt = 0;
		while(size>0) {
			cnt++;
			
			touch = new int[N][M];
			visited = new boolean[N][M];
			dfs(0,0);
			melt();
		}
		
		System.out.println(cnt);
	}

}
