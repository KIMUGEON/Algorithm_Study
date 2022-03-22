package _15_동적_계획법1.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
  [입력]
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

  [출력]
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */
public class Main_1463 { //1로 만들기

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[N+1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		
		for(int i=2; i<=N; i++) {
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);				
			}
			dp[i] = Math.min(dp[i], dp[i-1]+1);				
		}
		
		System.out.println(dp[N]);
	}

}
