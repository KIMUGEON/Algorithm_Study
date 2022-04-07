package study_0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_김유완 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테케수
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine()); // 스티커수
			int result = 0;
			int[][] arr = new int[2][n+1]; // 스티커 
			int[][] dp = new int[2][n+1]; // 합 넣어놓기
			for (int r = 0; r < 2; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= n; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 0부분 차피 0
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for (int j = 2; j <= n; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
			}
			result = Math.max(dp[0][n], dp[1][n]);
			System.out.println(result);
		}
	}

}
