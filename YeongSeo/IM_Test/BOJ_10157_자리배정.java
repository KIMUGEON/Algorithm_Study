package Implementation;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/10157
 * 걸린 시간 : 30분
 */
public class BOJ_10157_자리배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); // 가로 길이
		int R = sc.nextInt(); // 세로 길이
		int K = sc.nextInt(); // 좌석번호를 구할 대기 번호
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}}; // 상우하좌 (공연장 좌석 번호 변하는 순서)
		boolean[][] visited = new boolean[C+1][R+1]; // 좌석 채워졌는지 체크하는 배열
		int max = C*R; // 공연장의 총 좌석 개수
		
		if(K > max) { // 대기 번호가 총 좌석 개수보다 크면 무조건 좌석 배정 불가
			System.out.println(0); // 0 출력
			return; // 프로그램 종료
		}
		
		int x = 1; // 좌석번호 행
		int y = 1; // 좌석번호 열
		int k = 1; // 현재 좌석번호
		int dir = 0; // 현재 좌석을 채울 방향 (delta의 인덱스)
		visited[1][1] = true; // 시작 좌석 방문 체크
		
		// 현재 좌석번호가 K와 같아질 때까지 반복
		while(k++ != K) {
			int nx = x+deltas[dir%4][0]; // 다음 채워질 좌석의 행
			int ny = y+deltas[dir%4][1]; // 다음 채워질 좌석의 열
			
			if(nx >= 1 && nx <= C && ny >= 1 && ny <= R && !visited[nx][ny]) { // 경계체크 및 방문체크 후 이상 없으면 좌석 배정
				x = nx;
				y = ny;
			}
			else { // 경계를 벗어났거나 이미 방문한 좌석이면 방향을 바꿔서 좌석 배정
				dir++;
				x = x+deltas[dir%4][0];
				y = y+deltas[dir%4][1];
			}
			visited[x][y] = true; // 방문 체크
		}
		
		System.out.println(x+" "+y); // 결과 출력
	}

}
