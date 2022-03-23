package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2579
 * 걸린 시간 : 20분
 * 리뷰 : 처음에는 마지막 결과값에만 % 연산을 해줘서 출력을 해줬더니 계속 틀리다고 나왔다.
 * % 연산을 마지막에만 해주는 것이 아니라 f(n)을 구할 때마다 해주어야 한다는걸 깨달았다.
 * 마지막에만 % 연산을 해주면 중간에 저장되는 값들이 int의 범위를 넘어서므로 오버플로우가 발생한다.
*/
public class BOJ_2579_계단_오르기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 계단의 개수
		int[] stairs = new int[301]; // 각 계단의 점수를 저장할 배열
		
		// 점수 입력
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int[] max = new int[301]; // 각 계단에서 나올 수 있는 가장 높은 점수를 저장할 배열
		
		// 1,2,3 번째 계단의 최댓값 초기화
		max[1] = stairs[1];
		max[2] = stairs[1] + stairs[2];
		max[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
		
		for (int i = 4; i <= N; i++) {
			int case1 = max[i-2]; // i번째 계단을 연속 1번째로 올라섰을 때 최댓값
			int case2 = max[i-3] + stairs[i-1]; // i번째 계단을 연속 2번째로 올라섰을 때 최댓값
			
			// case1과 case2 중 더 큰 값에 현재 계단의 점수 더하기
			max[i] = Math.max(case1 , case2) + stairs[i];
		}
		
		System.out.println(max[N]); // 결과 출력
	}
	
}
