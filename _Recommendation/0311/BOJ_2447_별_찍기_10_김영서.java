package Divide_Conquer;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2447
 * 걸린 시간 : 30분
 * 리뷰 : 9분할 했을때 가운데 부분만 빈칸으로 채워지도록 별을 찍어야 하니,
 * char 배열의 모든값을 *으로 채워준 후 가운데 부분만 빈칸으로 바꾸도록 분할해 주었다.
*/
public class BOJ_2447_별_찍기_10 {
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 전체 가로,세로 길이
		map = new char[N][N]; // * 또는 빈칸을 저장해서 출력할 배열
		
		// map의 값 *으로 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], '*');
		}
		
		// 분할 시작
		divide(N, 0, 0);
		
		// 시간초과를 방지하기위해 StringBuilder 사용
		StringBuilder sb = new StringBuilder();
		
		// StringBuilder에 출력할 map 배열값 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		// 결과 출력
		System.out.println(sb);
	}

	/**
	 * @param n : 패턴의 가로,세로 길이
	 * @param startRow : 분할된 패턴의 첫번째 값의 행
	 * @param startCol : 분할된 패턴의 첫번째 값의 열
	 */
	private static void divide(int n, int startRow, int startCol) {
		if(n == 1) { // 기저조건 
			// n이 1이면 한칸을 의미하니 분할 끝
			return;
		}
		
		// 9분할 했을때 가운데 부분만 빈칸으로 채우기
		
		int m = n / 3; // 가운데 부분의 가로,세로 길이
		int targetRow = startRow + m; // 가운데 부분의 시작 행
		int targetCol = startCol + m; // 가운데 부분의 시작 열
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				int nr = targetRow + i;
				int nc = targetCol + j;
				
				map[nr][nc] = ' '; // 빈칸으로 바꾸기
			}
		}
		
		// 패턴 9분할 하기 -> 재귀 호출
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int nr = startRow+(m*i);
				int nc = startCol+(m*j);
				
				divide(m, nr, nc);
			}
		}
		
	}

}
