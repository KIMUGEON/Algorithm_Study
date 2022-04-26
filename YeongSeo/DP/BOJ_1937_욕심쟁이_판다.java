package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1937
 * 걸린 시간 : 60분
*/
public class BOJ_1937_욕심쟁이_판다 {
	static int n;
	static int[][] map, dp;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 대나무 숲의 크기
		map = new int[n][n]; // 대나무 숲 배열
		dp = new int[n][n]; // 현재 위치에서 이동할 수 있는 칸의 최댓값을 저장하는 동적 테이블
		
		// 대나무의 양 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0; // 문제의 답

		// 각 칸을 출발 지점으로 하여 이동할 수 있는 칸의 최댓값 구해보기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dfs(i, j); // (i, j)를 시작으로 dfs 탐색 -> dp[i][j]에 이동할 수 있는 칸의 최댓값 저장됨
				ans = Math.max(ans, dp[i][j]); // ans와 dp[i][j]를 비교하여 최댓값 갱신
			}
		}
		
		// 결과 출력
		System.out.println(ans);
	}

	private static int dfs(int curX, int curY) {
		// 현재 위치를 방문했으면 이미 dp 배열값이 정해졌으므로 더 이상 이동하지 않아도 됨
		// -> 현재 위치의 이동할 수 있는 칸의 수 반환
		if(dp[curX][curY] != 0) {
			return dp[curX][curY];
		}
		
		dp[curX][curY] = 1; // 현재 위치의 dp 배열값 1로 바꾸기 (방문했고, 현재 이동한 칸의 수가 1이라는 뜻)
		
		// 4방 탐색
		for (int i = 0; i < 4; i++) {
			int nx = curX + deltas[i][0];
			int ny = curY + deltas[i][1];
			
			// 이동 위치가 경계를 넘지 않고, 대나무의 양이 더 많을 경우
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] > map[curX][curY]) {
				// 현재 위치의 가능한 이동 칸 수와(dp[curX][curY]) 
				// 이동 위치로 갔을때의 가능한 이동 칸 수(dfs(nx, ny)+1)) 중 더 큰 값으로 갱신
				dp[curX][curY] = Math.max(dp[curX][curY], dfs(nx, ny) + 1);
			}
		}
	
		// 현재 위치의 dp 배열값 반환 (dp 배열값이 확정됐으므로 이동 가능한 칸 수가 최댓값임)
		return dp[curX][curY];
	}

}
