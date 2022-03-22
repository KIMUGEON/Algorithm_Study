package _15_동적_계획법1.Silver3;

import java.util.Scanner;
/*
  [입력]
입력의 첫째 줄에 계단의 개수가 주어진다.
둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 
계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.

  [출력]
첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.
 */
public class Main_2579 { //계단 오르기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		
		int dp[] = new int[N+1]; //누적합
		int arr[] = new int[N+1]; //계단 값
		
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[1] = arr[1];
		
		if(N>=2) { //안해주면 에러남
			dp[2] = arr[1]+arr[2];
		}
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i]; //두칸 전 값, 한칸 전 값+세칸 전 값 중 큰값과 현재 계단 값 더하기
		}
		System.out.println(dp[N]);
	}

}
