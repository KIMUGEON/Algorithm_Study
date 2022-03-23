package DP;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/11726
 * 걸린 시간 : 30분
 * 리뷰 : 처음에는 마지막 결과값에만 % 연산을 해줘서 출력을 해줬더니 계속 틀리다고 나왔다.
 * % 연산을 마지막에만 해주는 것이 아니라 f(n)을 구할 때마다 해주어야 한다는걸 깨달았다.
 * 마지막에만 % 연산을 해주면 중간에 저장되는 값들이 int의 범위를 넘어서므로 오버플로우가 발생한다.
*/
public class BOJ_11726_2xn_타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 직사각형의 가로 크기
		int[] memory = new int[1001]; // 결과값을 기억하기 위한 배열
		
		memory[1] = 1; // 2×1 방법의 수 초기화
		memory[2] = 2; // 2×2 방법의 수 초기화
		
		// n이 3일 때부터 방법의 수 구하기
		for (int i = 3; i <= n; i++) {
			memory[i] = (memory[i-1] + memory[i-2]) % 10007; 
		}

		System.out.println(memory[n]);
	}

}
