package Backtracking;

import java.util.Scanner;

public class BOJ_15649_N과_M_1 {
	static int N, M;
	static int[] input, numbers; // input : 입력수 배열, numbers : 선택수 배열
	static boolean[] isSelected; // 중복 체크를 위한 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		numbers = new int[M];
		isSelected = new boolean[N];
		
		for(int i=1; i<=N; i++) {
			input[i-1] = i;
		}
		permutation(0);
	}
	
	public static void permutation(int cnt) { // cnt : 직전까지 뽑은 수 개수
		
		if(cnt == M) {
			for(int n: numbers) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		// 입력받은 모든 수를 현재 자리에 넣어보기
		for(int i=0; i<N; i++) {
			// 기존 자리의 수들과 중복되는지 체크
			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			// 다음 수 뽑기
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
