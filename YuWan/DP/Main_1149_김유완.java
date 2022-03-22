package study_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_김유완 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
		// N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
		// i(2 ≤ i≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int result = Integer.MAX_VALUE;
		int[][] cost = new int[N][3]; // 비용넣는 곳
		int[][] dp = new int[N][3]; // 합 더해놓기
		for (int i = 0; i < N; i++) {
			// 주어진 비용 넣기 [i][0] 빨 [i][1] 초 [i][2] 파
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		// 처음값
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		// 비용더하기
		// 같은 색 아닌 두개중에 최소값 더하기
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}
		for (int i = 0; i < 3; i++) {
			if(result>dp[N-1][i]) result = dp[N-1][i];
		}
		System.out.println(result);
	}

}
