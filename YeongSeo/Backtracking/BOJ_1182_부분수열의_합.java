package Backtracking;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1182
 * 걸린 시간 : 30분
 */
public class BOJ_1182_부분수열의_합 {
	static int N, S;
	static int[] inputs; // 수열 정수 N개를 저장할 배열
	static int res; // 합이 S가 되는 부분수열의 개수 (결과값)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정수의 개수
		S = sc.nextInt(); // 수열의 합
		inputs = new int[N];
		
		// 정수 N개 입력
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}

		subset(0, 0, 0);
		
		System.out.println(res); // 결과 출력
	}

	/**
	 * @param cnt : 직전까지 고려한 원소 수
	 * @param sum : 현재까지 선택된 원소의 총합
	 * @param elementCnt : 현재까지 부분집합에 포함된 원소 수
	 */
	private static void subset(int cnt, int sum, int elementCnt) {
		if(cnt == N) { // 마지막 원소까지 부분집합에 다 고려된 상황
			// 공집합이 아니고 원소의 총합이 S이면 결과값 1 증가
			if(elementCnt != 0 && sum == S) res++;

			return;
		}
	
		// 현재 원소를 선택
		subset(cnt+1, sum+inputs[cnt] ,elementCnt+1);
		
		// 현재 원소를 비선택
		subset(cnt+1, sum, elementCnt);
	}
}
