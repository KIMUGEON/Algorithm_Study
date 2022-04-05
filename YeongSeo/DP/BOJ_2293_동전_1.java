package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_동전_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 동전 종류의 개수
		int k = Integer.parseInt(st.nextToken()); // 구할 가치의 합
		int[] coins = new int[n]; // 동전 가치를 저장할 배열
		
		// 동전 가치 입력
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[k+1]; // (index)원이 나오는 경우의 수를 저장할 동적 테이블
		dp[0] = 1; // 0원이 나오는 경우의 수 -> 1로 초기화

		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				dp[j] += dp[j-coins[i]];
			}
		}
		
		System.out.println(dp[k]);
	}

}
