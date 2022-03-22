package _15_동적_계획법1.Silver3;

import java.util.Scanner;

/*
  [입력]
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

  [출력]
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 */
public class Main_11726 {//2*n 타일링

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int dp[] = new int[n+2];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-2]+dp[i-1]) % 10007;
		}
		
		System.out.println(dp[n]);
	}

}
