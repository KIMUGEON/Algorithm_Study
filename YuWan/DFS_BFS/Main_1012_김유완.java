package study_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_김유완 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr; // 배추 있는지 없는지 저장하는 배열
	static boolean[][] is; // 방문여부
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			int K = Integer.parseInt(st.nextToken()); // 배추 심은 위치 개수
			int count = 0; // 개수
			arr = new int[N][M]; // 배추내용
			is = new boolean[N][M]; // 방문 여부
			// 배추 있는 개수만큼 위치 입력받아오기
			for(int j=0;j<K;j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1; // 배추 있는 경우 1
			}
			// 0,0부터 탐색하기
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					if(arr[r][c] == 1 && is[r][c] == false) { // 배추 있을때 들어가서 확인하기
						is[r][c] = true;
						count++;
						dfs(r,c);
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.print(sb);
	}
	public static void dfs(int row,int column) {
		for(int i=0;i<4;i++) { // 배추 있는 곳에서 4방 탐색
			int nr = row + dx[i];
			int nc = column + dy[i];
			// 범위에 포함될때 들어가서 더 확인하기
			if(nr>=0 && nc>=0 && nr<N && nc<M && is[nr][nc]==false && arr[nr][nc]== 1) {
				is[nr][nc] = true;
				dfs(nr,nc);
			}
		}
	}
}
