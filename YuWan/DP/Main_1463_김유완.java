package study_0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1463_김유완 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		Arrays.fill(dp, Integer.MAX_VALUE); // 전체 모두 최대값
		dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1); // 1번
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1); // 2번
			}
			dp[i] = Math.min(dp[i], dp[i-1] + 1); // 3번
		}
		System.out.println(dp[N]);
	}

}