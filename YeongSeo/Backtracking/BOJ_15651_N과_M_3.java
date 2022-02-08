package Backtracking;

import java.util.Scanner;

public class BOJ_15651_N과_M_3 {
	static int N, M;
	static int[] input, numbers; // input : 입력수 배열, numbers : 선택수 배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		numbers = new int[M];
		
		for(int i=1; i<=N; i++) {
			input[i-1] = i;
		}
		permutation(0);
		System.out.println(sb);
	}
	
	public static void permutation(int cnt) { // cnt : 직전까지 뽑은 수 개수
		
		if(cnt == M) {
			for(int n: numbers) {
				sb.append(n + " ");
			}
			sb.append('\n');
			return;
		}
		
		// 입력받은 모든 수를 현재 자리에 넣어보기
		for(int i=0; i<N; i++) {
			numbers[cnt] = input[i];
			
			// 다음 수 뽑기
			permutation(cnt+1);
		}
	}

}
