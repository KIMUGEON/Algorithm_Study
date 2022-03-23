package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1149
 * 걸린 시간 : 30분
 * 리뷰 :
 * dp(n, 색깔1) = min(dp(n-1, 색깔2), dp(n-1, 색깔3)) + cost(n, 색깔1)
 * dp(n, 색깔2) = min(dp(n-1, 색깔1), dp(n-1, 색깔3)) + cost(n, 색깔2)
 * dp(n, 색깔3) = min(dp(n-1, 색깔2), dp(n-1, 색깔1)) + cost(n, 색깔3)
 * 현재 집에서 그 전의 집의 색깔과 겹치지 않게 비용을 고려해서 점화식을 위와 같이 세워서 풀었다.
*/
public class BOJ_1149_RGB거리 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] cost = new int[N][3]; // 각 집의 색깔을 칠하는 비용
		int[][] dp = new int[N][N]; // 현재 집까지 색깔을 칠하는 누적 비용의 최솟값
		
		// 비용 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 첫번째 집의 최소 비용 초기화
		dp[0][0] = cost[0][0]; // 빨강
		dp[0][1] = cost[0][1]; // 초록
		dp[0][2] = cost[0][2]; // 파랑
		
		// 두번째 집부터 색깔 칠하기 시작
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0]; // 빨강을 칠했을때 최소비용
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1]; // 초록을 칠했을때 최소비용
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2]; // 파랑을 칠했을때 최소비용
		}
		
		// 마지막 집의 비용 중 3개를 비교해서 가장 최솟값 출력
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}

}
