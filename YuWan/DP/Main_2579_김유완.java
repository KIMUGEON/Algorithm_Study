package study_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_김유완 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// +2를 해서 계단 수 가 1일때 따로 예외처리 안해줘도 오류 안뜸
		int[] arr = new int[N+2]; // 계단 점수 넣어놓기
		int[] dp = new int[N+2]; // 총 점수
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = arr[0];
		dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(arr[1]+arr[2], arr[0]+arr[2]);
		// 연속으로 1칸1칸 못내려옴
		// 1칸 1
		// 2칸 1,2 / 2 중 1,2가 크겠지
		// 3칸 1,3 / 2,3 중 큰 값 고르기
		// 4칸 1,2,4 / 1,3,4 / 2,4 ( 2칸+4 / 1칸+3,4)
		// 5칸 1,2,4,5 / 1,3,5 / 2,3,5 / 2,4,5 (3칸+5 / 2칸+4,5)
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i]+arr[i-1]);
		}
		System.out.println(dp[N-1]);
	}

}
