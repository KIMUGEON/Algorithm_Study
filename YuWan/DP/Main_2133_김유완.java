package study_0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2133_김유완 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		dp[0] = 0;
		
		if(N>=2) dp[2] = 3;
		
		int count = 0;
		// 예외 2개는 발견했는데 처음 점화식은 왼쪽에만 예외가 있는 경우
		for (int i = 3; i < N+1; i++) {
			if(i%2 == 1) dp[i] = 0; // 홀수인 경우
			else{
				dp[i] = dp[i-2] * 3 + 2;
				// 4개일때부터 예외있었으니까 
				// 총 6일때 앞에 2인경우*예외(4짜리) 두개
				// 총 8일때 앞에 2인경우*예외(6짜리) 두개 + 앞에4인경우*예외(4짜리) 두개
				for (int j = 1; j <= count; j++) {
					dp[i] = dp[i] + 2 * dp[i-(j+1)*2];
				}
				count++;
			}
			
		}
		System.out.println(dp[N]);
	}

}
