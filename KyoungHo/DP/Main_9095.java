package _15_동적_계획법1.Silver3;

import java.util.Scanner;
/*
  [입력]
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
각 테스트 케이스는 한 줄로 이루어져 있고, 
정수 n이 주어진다. n은 양수이며 11보다 작다.

  [출력]
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
 */
public class Main_9095 { //1,2,3 더하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			int n = sc.nextInt();
			int dp[] = new int[11];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i=4; i<=n; i++) {
				dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
			}
			System.out.println(dp[n]);
			
		}

	}

}
