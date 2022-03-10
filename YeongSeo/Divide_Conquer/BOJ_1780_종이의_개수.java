package Divide_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1780
 * 걸린 시간 : 60분
*/
public class BOJ_1780_종이의_개수 {
	static int N; // 종이의 가로,세로 크기
	static int cnt1, cnt2, cnt3; // -1 종이 개수, 0 종이 개수, 1 종이 개수
	static int[][] map; // NxN 종이
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		
		// 종이 상태 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 분할 시작
		divide(N, 0, 0);
		
		// 결과 출력
		System.out.println(cnt1); // -1 종이 개수
		System.out.println(cnt2); // 1 종이 개수
		System.out.println(cnt3); // 0 종이 개수
	}

	/**
	 * @param n : 분할된 종이의 가로,세로 크기
	 * @param startRow : 분할된 종이의 첫번째 값의 행
	 * @param startCol : 분할된 종이의 첫번째 값의 열
	 */
	private static void divide(int n, int startRow, int startCol) {
		if(n == 1) {
			// 종이 크기가 1이면 한칸을 의미하니 그 칸의 숫자 체크
			checkPaperNum(map[startRow][startCol]);
			return;
		}
		
		int target = map[startRow][startCol]; // 종이의 첫번째 값의 숫자
		
		// 종이가 target 숫자와 같은지 처음부터 끝까지 체크
		outer: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// target 숫자와 다르면 바깥쪽 반복문 나가기
				if(map[startRow+i][startCol+j] != target) break outer;
				
				// i와 j가 n-1이면 처음부터 끝까지 다 target 숫자로 채워져 있다는 뜻
				if(i == n-1 && j == n-1) {
					checkPaperNum(target); // target 숫자의 종이 개수 증가시키기
					return;
				}
			}
		}
		
		// 여기로 왔다는건 target 숫자로 종이가 채워지지 않았다는 뜻 -> 9분할 시작
		
		int m = n / 3; // 분할한 종이의 가로,세로 크기
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int nr = startRow+(m*i); // 분할된 종이의 첫번째 값의 행
				int nc = startCol+(m*j); // 분할된 종이의 첫번째 값의 열
				
				divide(m, nr, nc); // 분할 시작
			}
		}
		
	}
	
	// num에 해당하는 종이 개수를 1 증가시키는 함수
	private static void checkPaperNum(int num) { // num: 종이에 적힌 숫자
		switch(num) {
		case -1: 
			cnt1++;
			break;
		case 0:
			cnt2++;
			break;
		case 1:
			cnt3++;
			break;
		}
		return;
	}

}
