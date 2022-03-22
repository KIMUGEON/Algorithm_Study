package _15_동적_계획법1.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [입력]
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 
집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

  [출력]
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 */
public class Main_1149 { //RGB거리

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int dp[][]= new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red; //i번째 빨간색 집 비용 += i-1번째 초록, 파랑의 최솟값
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green; //i번째 초록색 집 비용 += i-1번째 빨강, 파랑의 최솟값
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue; //i번째 파란색 집 비용 += i-1번째 빨강, 초록의 최솟값 
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}

}
