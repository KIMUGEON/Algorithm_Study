package DP;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1463
 * 걸린 시간 : 20분
 * 리뷰 : 점화식을 f(n) = min(f(n/3), f(n/2), f(n-1)) + 1 로 세워서 dp 개념을 적용해서 풀었다.
 * f(n/3), f(n/2), f(n-1) 을 수행하면 나누기 또는 빼기 연산을 한번 수행한 셈이니 마지막에 꼭 +1을 더해주어야 한다.
*/
public class BOJ_1463_1로_만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] memory = new int[N+1]; // 결과값을 기억하기 위한 배열
		
		Arrays.fill(memory, Integer.MAX_VALUE); // 가장 큰 값으로 초기화
		
		memory[1] = 0; // 1의 결과값 초기화
		
		// 2부터 N까지 연산을 하는 횟수의 최솟값 구하기
		// 가능한 연산 다 해보고 가장 최솟값으로 갱신
		for (int i = 2; i <= N; i++) {
			// 3으로 나누어 떨어지면 f(i) = f(i/3) + 1
			if(i % 3 == 0) {
				memory[i] = Math.min(memory[i], memory[i/3] + 1);
			}
			// 2로 나누어 떨어지면 f(i) = f(i/2) + 1
			if(i % 2 == 0) {
				memory[i] = Math.min(memory[i], memory[i/2] + 1);
			}
			// 1을 빼면 f(i) = f(i-1) + 1
			memory[i] = Math.min(memory[i], memory[i-1] + 1);
		}
		
		// 결과 출력
		System.out.println(memory[N]);
	}

}
