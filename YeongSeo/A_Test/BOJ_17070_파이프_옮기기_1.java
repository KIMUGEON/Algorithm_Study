package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/17070
 * 걸린 시간 : 60분
 */
public class BOJ_17070_파이프_옮기기_1 {
	static int N, res;
	static int[][] map;
	static int[][] deltas = {{0,1},{1,0},{1,1}}; // →, ↓, ↘ 순서
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 집의 크기
		map = new int[N][N]; // NxN 집의 상태 배열
		StringTokenizer st;
		
		// 집의 상태 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = 0; // 방법의 수 (결과값)
		dfs(0, 1, 0); // 깊이우선탐색 시작
		
		System.out.println(res); // 결과 출력
	}

	/**
	 * @param r : 파이프 한쪽 끝의 행 위치
	 * @param c : 파이프 한쪽 끝의 열 위치
	 * @param status : 현재 파이프의 방향
	 */
	private static void dfs(int r, int c, int status) {
		if(r == N-1 && c == N-1) {
			// 파이프의 한쪽 끝이 도착 지점에 도달했으면 결과값 1 증가
			res++;
			return;
		}
		
		// 현재 파이프의 방향에 따라 분기
		switch(status) {
		// 가로일 때
		case 0:
			// 가로로 이동
			if(c+deltas[0][1] < N && map[r][c+deltas[0][1]] == 0) {
				dfs(r, c+deltas[0][1], 0);
			}
			break;
		// 세로일 때
		case 1:
			// 세로로 이동
			if(r+deltas[1][0] < N && map[r+deltas[1][0]][c] == 0) {
				dfs(r+deltas[1][0], c, 1);
			}
			break;
		// 대각선일 때
		case 2:
			// 가로로 이동
			if(c+deltas[0][1] < N && map[r][c+deltas[0][1]] == 0) {
				dfs(r, c+deltas[0][1], 0);
			}
			// 세로로 이동
			if(r+deltas[1][0] < N && map[r+deltas[1][0]][c] == 0) {
				dfs(r+deltas[1][0], c, 1);
			}
			break;
		}
		
		// 대각선으로 이동
		for (int i = 0; i < 3; i++) {
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			
			// 이동방향이 경계를 벗어나거나 벽이면 break
			if(nr >= N || nc >= N || map[nr][nc] == 1) break;
			
			if (i == 2) { 
				// 마지막 deltas 조건까지 통과했으면 대각선 이동 가능
				dfs(nr, nc, 2);
			}
		}
		
	}

}
