package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2638
 * 걸린 시간 : 40분
*/
public class BOJ_2638_치즈 {
	static int N, M, cnt, time;
	static int[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 모눈종이의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 모눈종이의 가로 크기
		map = new int[N][M]; // 모눈종이 배열
		cnt = 0; // 남은 치즈의 개수
		
		// 모눈종이 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cnt++; // 입력값이 1이면 치즈 개수 1 증가
			}
		}
		
		// 남은 치즈의 개수가 0이 될때까지 반복
		while (cnt != 0) {
			bfs(); // bfs 탐색 실행
			time++; // 1시간 증가
		}
		
		// 결과 출력
		System.out.println(time);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[][] check = new int[N][M]; // -1: 외부 공기, 0: 내부 공기, 1~4: 치즈(외부공기와 접촉한 변의 개수)
		
		queue.offer(new int[] {0, 0}); // 탐색 시작위치 queue에 넣기
		check[0][0] = -1; // 탐색 시작위치 외부 공기로 표시
		
		// 외부 공기에 해당하는 위치만 bfs 탐색
		while (!queue.isEmpty()) {
			int[] current = queue.poll(); // 현재 위치
			int curX = current[0]; // 현재 위치의 행 좌표
			int curY = current[1]; // 현재 위치의 열 좌표
			
			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int nx = curX + deltas[i][0];
				int ny = curY + deltas[i][1];
				
				// 이동위치가 경계를 벗어났거나, 이미 방문한 위치이면 pass
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || check[nx][ny] == -1) continue;
				
				// 이동위치가 치즈일 경우
				if (map[nx][ny] == 1) {
					check[nx][ny] += 1; // 접촉한 변의 개수 1 증가
				}
				// 이동위치가 공기일 경우
				else if (map[nx][ny] == 0) {
					check[nx][ny] = -1; // 외부 공기로 표시
					queue.offer(new int[] {nx, ny}); // 이동위치 queue에 넣기
				}
			}
		}
		
		// 치즈 녹이기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 외부공기와 접촉한 변의 개수가 2 이상일 경우
				if (check[i][j] >= 2) {
					map[i][j] = 0; // 공기로 바꾸기
					cnt--; // 치즈 개수 1 감소
				}
			}
		}
	}

}
