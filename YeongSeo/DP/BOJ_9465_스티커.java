package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/9465
 * 걸린 시간 : 50분
*/
public class BOJ_9465_스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		StringTokenizer st;
	
		// 테스트케이스 수만큼 실행
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 각 행의 스티커 개수
			
			int[] score1 = new int[n+1]; // 1행 스티커들의 점수
			int[] score2 = new int[n+1]; // 2행 스티커들의 점수
			
			// 1행 스티커 점수 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				score1[i] = Integer.parseInt(st.nextToken());
			}
			
			// 2행 스티커 점수 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				score2[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[3][n+1]; // 해당 열까지의 최대 스티커 점수를 저장할 배열
			
			// 1열 스티커 점수 초기화
			dp[0][1] = 0; // 1열 스티커를 무엇도 선택하지 않았을 때의 점수
			dp[1][1] = score1[1]; // 1행 1열 스티커 점수를 선택했을 때의 점수
			dp[2][1] = score2[1]; // 2행 1열 스티커 점수를 선택했을 때의 점수
			
			for (int col = 2; col <= n; col++) {
				// i열 스티커를 무엇도 선택하지 않았을 때의 최대 점수 저장
				dp[0][col] = Math.max(dp[1][col-1], dp[2][col-1]);
				// 1행 i열 스티커를 선택했을 때의 최대 점수 저장
				dp[1][col] = Math.max(dp[0][col-1]+score1[col], dp[2][col-1]+score1[col]);
				// 2행 i열 스티커를 선택했을 때의 최대 점수 저장
				dp[2][col] = Math.max(dp[0][col-1]+score2[col], dp[1][col-1]+score2[col]);
			}
			
			// 스티커 점수의 최댓값 구하기
			int ans = Math.max(dp[0][n], dp[1][n]);
			ans = Math.max(ans, dp[2][n]);
			
			// 결과 출력
			System.out.println(ans);
		}
	}

}
