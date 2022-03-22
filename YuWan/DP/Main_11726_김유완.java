package study_0322;

import java.util.Scanner;

public class Main_11726_김유완 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 개수 구해보면
		// 1  1개
		// 2  2개
		// 3  3개
		// 4  세로1개있으면(3개)+가로1개있으면(2개) = 5개
		// 5  세로1개있으면(5개)+가로1개있으면(3개) = 8개
		int[] dp = new int[N+1];
		dp[1] = 1;
		if(N!=1) {
			dp[2] = 2;		
			for (int i = 3; i <= N; i++) {
				// 여기서도 %10007 안해주면 틀림
				dp[i] = (dp[i-1] + dp[i-2])%10007;
			}
		}
		System.out.println(dp[N]%10007);
		sc.close();
	}

}
