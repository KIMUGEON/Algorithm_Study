package study_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11727_김유완 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 개수 구해보면
		// 1  1개
		// 2  3개
		// 3  세로1개있으면(3개)+가로1개있으면(1개*2) = 5개
		// 4  세로1개있으면(5개)+가로1개있으면(3개*2) = 11개
		// 5  세로1개있으면(11개)+가로1개있으면(5개*2) = 21개
		int[] dp = new int[N+1];
		dp[1] = 1;
		if(N!=1) {
			dp[2] = 3;		
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
			}
		}
		System.out.println(dp[N]%10007);
	}
}