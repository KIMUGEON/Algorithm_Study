package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1261
 * 걸린 시간 : 30분
*/
public class BOJ_1261_알고스팟 {
	public static class Room implements Comparable<Room> {
		int x, y, minCost; // x: 행 위치 y: 열 위치 minCost: 출발지에서 자신으로의 최소비용(벽을 부순 횟수)
		
		public Room(int x, int y, int minCost) {
			super();
			this.x = x;
			this.y = y;
			this.minCost = minCost;
		}

		@Override
		public int compareTo(Room o) { // minCost 오름차순 정렬
			return this.minCost - o.minCost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()); // 미로의 가로 크기
		int N = Integer.parseInt(st.nextToken()); // 미로의 세로 크기
		int[][] map = new int[N][M]; // 미로의 상태를 저장할 배열
		int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우
		
		// 미로의 상태 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		int[][] cost = new int[N][M]; // 출발지에서 자신으로 오는 최소비용(벽을 부순 횟수)
		boolean[][] visited = new boolean[N][M]; // 최소비용 확정여부
		PriorityQueue<Room> pQueue = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) { // 최소비용 초기화
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		
		cost[0][0] = 0; // 시작위치 최소비용 0으로 초기화
		pQueue.offer(new Room(0, 0, cost[0][0])); // 시작위치 pQueue에 넣기
		
		while(!pQueue.isEmpty()) {
			Room current = pQueue.poll(); // 현재 방 위치 (pQueue로 인해 무조건 최소비용인 방으로 이동)
			
			if(visited[current.x][current.y]) continue; // 최소비용이 확정된 방이면 pass
			
			visited[current.x][current.y] = true; // 최소비용 확정 체크
			
			// 상하좌우로 이동
			for (int i = 0; i < 4; i++) {
				int nr = current.x+deltas[i][0];
				int nc = current.y+deltas[i][1];
				
				// 경계체크 && 최소비용 확정여부 체크 && 이동칸으로의 이동이 현재 최소비용보다 작은지 체크
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && 
						cost[nr][nc] > cost[current.x][current.y] + map[nr][nc]) {
					// 이동 칸의 값(1또는 0)이 비용이므로 현재 칸의 최소비용에 이동 칸의 비용 더하기
					cost[nr][nc] = cost[current.x][current.y] + map[nr][nc];
					pQueue.offer(new Room(nr, nc, cost[nr][nc]));
				}
			}
		}
		
		// (N,M)의 최소비용 출력
		System.out.println(cost[N-1][M-1]);
	}

}
