package Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2630
 * 걸린 시간 : 15분
 * 리뷰 : 배열 크기가 1인 경우의 기저조건을 굳이 넣어주지 않았어도 어차피 1의 개수를 세는 반복문에서
 * 그 칸이 1인지 아닌지 한번만 세주기 때문에 그 부분의 코드를 생략해주어도 좋았을 것 같다.
*/
public class BOJ_2630_색종이_만들기 {
	static int[][] map;
	static int white, blue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 종이의 한 변의 길이
		StringTokenizer st;
		map = new int[N][N]; // 색종이의 각 칸의 색을 저장하는 배열
		
		// 각 칸의 색 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		white = 0; // 하얀색 색종이 개수
		blue = 0; // 파란색 색종이 개수
		
		divide(N, 0, 0); // 분할 시작
		
		// 결과 출력
		System.out.println(white);
		System.out.println(blue);
	}
	
	/**
	 * @param n : 분할된 색종이의 가로,세로 크기
	 * @param startRow : 분할된 색종이의 첫번째 값의 행
	 * @param startCol : 분할된 색종이의 첫번째 값의 열
	 */
	private static void divide(int n, int startRow, int startCol) {
		if(n == 1) { // 배열 크기가 1이면 한칸을 의미하니 그 칸에 칠해진 색의 색종이 1 증가
			if(map[startRow][startCol] == 1) blue++;
			else white++;
			
			return;
		}
		
		int size = n*n; // 분할된 종이의 전체 크기
		int cnt = 0; // 1의 개수(파란색)를 세는 카운트변수
		
		// 분할된 n x n 종이에서 1의 개수 세기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[startRow+i][startCol+j] == 1) cnt++;
			}
		}
		
		if(size == cnt) { // 종이가 전부 1로 되어있으면 파란색 색종이 개수 1 증가
			blue++;
			return;
		}
		else if(cnt == 0) { // 종이가 전부 0으로 되어있으면 하얀색 색종이 개수 1 증가
			white++;
			return;
		}
		
		// 전부 1이나 0으로 칠해져있지 않으면 분할 시작
		
		divide(n/2, startRow, startCol); // 왼쪽 위 분할
		divide(n/2, startRow, startCol+n/2); // 오른쪽 위 분할
		divide(n/2, startRow+n/2, startCol); // 왼쪽 아래 분할
		divide(n/2, startRow+n/2, startCol+n/2); // 오른쪽 아래 분할
	}

}
