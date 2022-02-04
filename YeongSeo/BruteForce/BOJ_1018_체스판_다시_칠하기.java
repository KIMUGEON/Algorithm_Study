package Brute_Force;

import java.util.Scanner;

/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1018
 * 걸린 시간 : 1시간+@
 * 느낀 점 : 처음에는 체스판의 이전 색깔 정보를 따로 변수에 저장해서 그 변수와 현재 색깔을 하나하나
 * 다 비교하면서 코드를 짜니 매우 복잡하고 반례도 많아서 틀렸다는 결과만 나왔다.
 * 스터디를 통해 스터디원의 코드를 보니 아주 간단하게.. 미리 나올 수 있는 체스판의 종류를 2개 저장해서
 * 그 체스판과 비교를 하는 식으로 코드를 짜니 매우 쉽고도 편하게..(ㅜㅜ) 풀 수 있었다.
 * 브루트포스 알고리즘이라고 해서 너무 비효율적이고 복잡하게 로직을 짜지 말고 간단한 방법으로 짤 수 있는 
 * 아이디어(중요!! 별표 5개)를 생각하는 것이 중요한 것 같다.
 */
public class BOJ_1018_체스판_다시_칠하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 행의 수
		int M = sc.nextInt(); // 열의 수

		char[][] board = new char[N][M];
		int cnt1 = 0;
		int cnt2 = 0;
		int min = Integer.MAX_VALUE;
		
		// 보드판 색깔값 저장
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		char[][] chess1 = {{'W','B','W','B','W','B','W','B'},
							{'B','W','B','W','B','W','B','W'},
							{'W','B','W','B','W','B','W','B'},
							{'B','W','B','W','B','W','B','W'},
							{'W','B','W','B','W','B','W','B'},
							{'B','W','B','W','B','W','B','W'},
							{'W','B','W','B','W','B','W','B'},
							{'B','W','B','W','B','W','B','W'}};

		char[][] chess2 = {{'B','W','B','W','B','W','B','W'},
							{'W','B','W','B','W','B','W','B'},
							{'B','W','B','W','B','W','B','W'},
							{'W','B','W','B','W','B','W','B'},
							{'B','W','B','W','B','W','B','W'},
							{'W','B','W','B','W','B','W','B'},
							{'B','W','B','W','B','W','B','W'},
							{'W','B','W','B','W','B','W','B'}};

		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				cnt1 = 0;
				cnt2 = 0;
				for(int r=0; r<8; r++) {
					for(int c=0; c<8; c++) {
						if(board[i+r][j+c] != chess1[r][c]) cnt1++;
						if(board[i+r][j+c] != chess2[r][c]) cnt2++;
					}
				}
				
				if(cnt1 < min) min = cnt1;
				if(cnt2 < min) min = cnt2;
				
			}		
		}
		
		System.out.println(min);

	}

}
