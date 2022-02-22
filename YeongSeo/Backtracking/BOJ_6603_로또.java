package Backtracking;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/6603
 * 걸린 시간 : 15분
 */
public class BOJ_6603_로또 {
	static int k; // 집합 S를 만들 k개의 수
	static int[] inputs; // 집합 S에 포함되는 k개의 숫자를 저장할 배열
	static int[] numbers; // 로또 번호 6개를 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while((k = sc.nextInt()) != 0) { // k가 0이면 프로그램 종료
			inputs = new int[k];
			numbers = new int[6];
			
			// k개의 숫자 입력
			for(int i=0; i<k; i++) {
				inputs[i] = sc.nextInt();
			}
			
			combination(0, 0); // 로또 번호 뽑기 시작
			System.out.println();
		}
	}

	/**
	 * @param cnt : 직전까지 뽑은 숫자의 개수
	 * @param start : 중복 방지를 위한 인덱스 시작 위치
	 */
	private static void combination(int cnt, int start) { // 로또 번호 6개를 뽑는 함수 -> 조합
		if(cnt == 6) { // 숫자 6개를 다 뽑았을 경우
			// 로또 번호 6개 출력
			for(int i=0; i<6; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<k; i++) {
			numbers[cnt] = inputs[i];
			// 다음 숫자 뽑으러 가기 (중복 방지를 위해 시작 위치는 지금 뽑은 숫자의 인덱스+1)
			combination(cnt+1, i+1); 
		}
	}
}
