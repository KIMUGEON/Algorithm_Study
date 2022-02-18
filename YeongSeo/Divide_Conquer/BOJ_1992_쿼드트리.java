package Divide_Conquer;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1992
 * 걸린 시간 : 40분
*/
public class BOJ_1992_쿼드트리 {
	static int N;
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 영상의 크기
		map = new int[N][N]; // NxN 영상
		
		// 영상의 각 점 입력
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		sb = new StringBuilder(); // 압축한 문자열을 저장할 StringBulider
		
		divide(N, 0, 0); // 분할 시작
		
		System.out.println(sb); // 결과 출력
	}

	/**
	 * @param n : 분할된 영상의 가로,세로 크기
	 * @param startRow : 분할된 영상의 첫번째 값의 행
	 * @param startCol : 분할된 영상의 첫번째 값의 열
	 */
	private static void divide(int n, int startRow, int startCol) { 
		if(n == 1) { // n이 1이면 한칸을 의미하니 그 칸에 적힌 수 출력
			if(map[startRow][startCol] == 1) sb.append("1");
			else sb.append("0");
			
			return;
		}
		
		int size = n*n; // n x n 영상의 전체 크기
		int cnt = 0; // 1의 개수를 세는 카운트변수
		
		// n x n 에서 1의 개수 세기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[startRow+i][startCol+j] == 1) cnt++;
			}
		}
		
		if(size == cnt) { // 영상이 전부 1로 되어있으면 1로 압축
			sb.append("1");
			return;
		}
		else if(cnt == 0) { // 영상이 전부 0으로 되어있으면 0으로 압축
			sb.append("0");
			return;
		}
		
		// 1이나 0으로 압축되지 않으면 분할 시작
		
		sb.append("("); // n x n 영상 분할 시작의 의미인 ( 출력
		divide(n/2, startRow, startCol); // 왼쪽 위 분할
		divide(n/2, startRow, startCol+n/2); // 오른쪽 위 분할
		divide(n/2, startRow+n/2, startCol); // 왼쪽 아래 분할
		divide(n/2, startRow+n/2, startCol+n/2); // 오른쪽 아래 분할
		sb.append(")"); // n x n 영상 분할 시작의 의미인 ) 출력
		
	}

}
