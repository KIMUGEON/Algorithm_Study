package Backtracking;

import java.util.Scanner;

public class BOJ_14888_연산자_끼워넣기 {
	static int N;
	static int[] nums;
	static int[] op;
	static int[] operation;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 피연산자의 개수
		nums = new int[N]; // 피연산자 저장하는 배열
		op = new int[4]; // 각 연산자 개수 저장하는 배열
		operation = new int[N-1]; // 연산 순서 저장하는 배열
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}

		for(int i=0; i<4; i++) {
			op[i] = sc.nextInt();
		}
		pickOp(0);
		System.out.println(max); // 최댓값 출력
		System.out.println(min); // 최솟값 출력
	}
	
	// 연산할 순서를 뽑는 함수
	static void pickOp(int cnt) { // cnt : 직전까지 뽑은 연산자 개수
		if(cnt == N-1) {
			// 연산 순서 다 뽑았으면 연산 시작
			calculate();
			return;
		}
		
		// i -> 0: 덧셈 1: 뺄셈 2:곱셈 3:나눗셈 
		for(int i=0; i<4; i++) {
			//남은 연산자 개수가 0이 아니면 뽑기
			if(op[i] != 0) {
				operation[cnt] = i;
				op[i] -= 1; // 연산자 개수 -1
				pickOp(cnt+1);
				op[i] += 1; // 연산자 개수 +1
			}
		}
	}
	
	// 연산을 수행하는 함수
	static void calculate() {
		int result = 0; // 연산 결과
		
		// 맨 처음 연산 수행하여 result에 저장
		switch(operation[0]) {
		case 0: // 덧셈
			result = nums[0] + nums[1];
			break;
		case 1: // 뺄셈
			result = nums[0] - nums[1];
			break;
		case 2: // 곱셈
			result = nums[0] * nums[1];
			break;
		case 3: // 나눗셈
			result = nums[0] / nums[1];
			break;
		}
		
		// 세번째 피연산자부터 차례대로 연산하여 result에 더해주기
		for(int i=1; i<N-1; i++) {
			switch(operation[i]) {
			case 0: // 덧셈
				result += nums[i+1];
				break;
			case 1: // 뺄셈
				result -= nums[i+1];
				break;
			case 2: // 곱셈
				result *= nums[i+1];
				break;
			case 3: // 나눗셈
				result /= nums[i+1];
				break;
			}
		}
		
		// 최댓값과 최솟값 업데이트
		max = Math.max(max, result);
		min = Math.min(min, result);
		
	}
}

