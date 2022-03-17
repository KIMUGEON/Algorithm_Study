package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1003
 * 걸린 시간 : 40분
 * 리뷰 : 처음에는 탑다운 방식으로 재귀를 이용하여 문제를 풀었지만, 시간초과가 나왔다.
 * 반복문을 이용한 보텀업 방식을 이용하여 다시 풀었더니 실행시간이 더 단축된 결과가 나왔다.
 * 같은 dp 문제 풀이라도 보텀업 방식의 성능이 더 좋다는 것을 알 수 있었다.
*/
public class BOJ_1003_피보나치_함수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			int[] fibo = new int[N+1]; // 피보나치 수 결과를 저장할 배열
			int[] zeroCnt = new int[N+1]; // 0을 호출한 횟수를 저장할 배열
			int[] oneCnt = new int[N+1]; // 1을 호출한 횟수를 저장할 배열
	
			// N이 0일 때 결과
			if (N == 0) zeroCnt[0] = 1;
			// N이 1일 때 결과
			else if (N == 1) oneCnt[1] = 1;
			// N이 2이상일 때 -> 보텀업 방식(Bottom-Up)으로 피보나치 수 구하기
			else {
				// 0과 1의 피보나치 수 결과와 호출 횟수 초기화
				fibo[0] = 0;
				fibo[1] = 1;
				zeroCnt[0] = 1;
				oneCnt[1] = 1;
				
				// N이 2일 때부터 피보나치 수 구하기
				for (int i = 2; i <= N; i++) {
					fibo[i] = fibo[i-1] + fibo[i-2];
					zeroCnt[i] = zeroCnt[i-1] + zeroCnt[i-2];
					oneCnt[i] = oneCnt[i-1] + oneCnt[i-2];
				}
			}
			
			// 결과 출력
			System.out.println(zeroCnt[N]+" "+oneCnt[N]);
		}
		
	}

}
