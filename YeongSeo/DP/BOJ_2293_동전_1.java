package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2293
 * 걸린 시간 : 60분 (해설 참고)
 * 리뷰 :
    2를 사용해서 5를 만드는 경우의 수는,
 	1과 2를 사용해서 3을 만드는 경우의 수이다.
  	
  	즉, 동전 i원을 사용해서 j원을 만드는 경우의수는
    : dp[j] = dp[j] + dp[j-i]

    <dp 초기 상태>
	0	1	2	3	4	5	6	7	8	9	10
	1	0	0	0	0	0	0	0	0	0	0

	<1원 사용했을 때>
	0	1	2	3	4	5	6	7	8	9	10
	1	1	1	1	1	1	1	1	1	1	1

	<1,2원 사용했을 때>
	0	1	2	3	4	5	6	7	8	9	10
	1	1	2	2	3	3	4	4	5	5	6

	<1,2,5원 사용했을 때>
	0	1	2	3	4	5	6	7	8	9	10
	1	1	2	2	3	4	5	6	7	8	10
	
	참고 : https://squareyun.tistory.com/14
*/
public class BOJ_2293_동전_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 동전 종류의 개수
		int k = Integer.parseInt(st.nextToken()); // 구할 가치의 합
		int[] coins = new int[n]; // 사용할 수 있는 동전의 종류
		
		// 동전 가치 입력
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[k+1]; // (index)원이 나오는 경우의 수를 저장할 동적 테이블
		dp[0] = 1; // 0원이 나오는 경우의 수 -> 1로 초기화

		// 중복 방지를 위해 동전 종류가 작은것부터 고려하기
		for (int i = 0; i < n; i++) {
			// (j-i)원이 0 이상이어야 하므로 i원 동전부터 고려하기
			for (int j = coins[i]; j <= k; j++) {
				dp[j] += dp[j-coins[i]];
			}
		}
		
		// k원이 나오는 경우의 수 출력
		System.out.println(dp[k]);
	}

}
