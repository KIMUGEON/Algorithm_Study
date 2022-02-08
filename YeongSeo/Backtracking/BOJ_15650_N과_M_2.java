package Backtracking;

import java.util.Scanner;

public class BOJ_15650_N과_M_2 {
	static int N, M;
	static int[] numbers; // input : 입력수 배열, numbers : 선택수 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		
		combination(0, 1);
	}
	
	public static void combination(int cnt, int start) { // cnt : 직전까지 뽑은 수 개수, start : 중복 방지를 위한 인덱스 시작 위치
		
		if(cnt == M) {
			for(int n: numbers) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<=N; i++) {

			numbers[cnt] = i;
			
			combination(cnt+1, i+1);
		}
	}

}
