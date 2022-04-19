package etc.다이나믹_프로그래밍.Gold5;

import java.util.Scanner;

/*
  [입력]
첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 
다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 
동전의 가치는 100,000보다 작거나 같은 자연수이다.

  [출력]
첫째 줄에 경우의 수를 출력한다. 경우의 수는 231보다 작다.
 */
public class Main_2293 {//동전 1

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int coin[] = new int[n+1];
		int dp[] = new int [k+1];
		
		for(int i=1; i<=n; i++) {
			coin[i] = sc.nextInt();
		}
		
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=coin[i]; j<=k; j++) {//ex> dp[3] : (1,2원 사용 경우의수) = dp[3] : (기존의 1원만 사용한 경우의 수) + dp[1]
				dp[j] = dp[j] + dp[j-coin[i]];
			}
		}
		System.out.println(dp[k]);
	}

}
