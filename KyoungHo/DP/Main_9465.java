package etc.다이나믹_프로그래밍.Silver1;

import java.util.Scanner;

/*
  [입력]
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 n (1 ≤ n ≤ 100,000)이 주어진다. 
다음 두 줄에는 n개의 정수가 주어지며, 각 정수는 그 위치에 해당하는 스티커의 점수이다. 
연속하는 두 정수 사이에는 빈 칸이 하나 있다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다. 

  [출력]
각 테스트 케이스 마다, 2n개의 스티커 중에서 두 변을 공유하지 않는 스티커 점수의 최댓값을 출력한다.
 */
public class Main_9465 {//스티커

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int 스티커[][] = new int[3][n+1];
			int dp[][] = new int[3][n+1];
			
			for(int i=1; i<=2; i++) {
				for(int j=1; j<=n; j++) {
					스티커[i][j] = sc.nextInt();
				}
			}
			
			dp[1][1] = 스티커[1][1];
			dp[2][1] = 스티커[2][1];
			
			for(int i=2; i<=n; i++) {// 왼쪽 대각선(합)과 왼왼쪽 대각선 확인
				dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + 스티커[1][i];
				dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + 스티커[2][i];
			}
			System.out.println(Math.max(dp[1][n], dp[2][n]));
		}
	}

}
