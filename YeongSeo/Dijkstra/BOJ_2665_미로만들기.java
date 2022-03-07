package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2665
 * 걸린 시간 : 40분
 * 리뷰 : 백준 4485와 똑같은 방식으로 dfs를 통한 방 이동과 다익스트라를 이용한 최소비용 구하기로 문제를 풀었다.
 * 여기서 중요했던 것은 최소비용을 어떻게 정의하느냐인 것인데, 문제에서 흰 방으로 바꾸어야 할 최소의 검은 방의 수를
 * 구해야 한다고 했으므로 현재 방까지 도달하는데 검은 방을 지나온 횟수를 최소비용으로 정의하였다.
 * 즉, 검은방을 한번씩 지나올 때마다 비용이 1씩 들도록 정의하였다. 
*/
public class BOJ_2665_미로만들기 {
	static class Room implements Comparable<Room>{
		int x, y, minCost; // x: 행 위치 y: 열 위치 minCost: 출발지에서 자신으로의 최소비용(검은 방을 지나온 횟수)

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
		int n = Integer.parseInt(br.readLine()); // 한 줄에 들어가는 방의 수
		int[][] map = new int[n][n]; // nxn 방의 상태
		int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우
		
		// 방 상태 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		PriorityQueue<Room> pQueue = new PriorityQueue<>();
		int[][] distance = new int[n][n]; // 출발지에서 자신으로 오는 최소비용(검은 방을 지나온 횟수)
		boolean[][] visited = new boolean[n][n]; // 최소비용 확정여부
		
		for (int i = 0; i < n; i++) { // 최소비용 초기화
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		
		distance[0][0] = 0; // 시작방 최소비용 0으로 초기화
		pQueue.offer(new Room(0, 0, distance[0][0])); // 시작방 pQueue에 넣기
		
		while(!pQueue.isEmpty()) {
			Room current = pQueue.poll(); // 현재 방 위치 (pQueue로 인해 무조건 최소비용인 방으로 이동)
			
			if(visited[current.x][current.y]) continue; // 최소비용이 확정된 방이면 pass
			
			visited[current.x][current.y] = true; // 최소비용 확정 체크
			
			// 상하좌우로 이동
			for (int i = 0; i < 4; i++) {
				int nr = current.x+deltas[i][0];
				int nc = current.y+deltas[i][1];
				
				// 경계체크 && 최소비용 확정여부 체크 && 이동칸으로의 이동이 현재 최소비용보다 작은지 체크
				// Math.abs(map[nr][nc]-1)은 이동 방이 검은 방일 경우 비용을 1 더해주고, 흰 방일 경우 비용을 0으로 하기 위함
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && 
						distance[nr][nc] > distance[current.x][current.y] + Math.abs(map[nr][nc]-1)) {
					distance[nr][nc] = distance[current.x][current.y] + Math.abs(map[nr][nc]-1);
					pQueue.offer(new Room(nr, nc, distance[nr][nc]));
				}
			}
		}
		
		// 끝 방의 최소비용 출력
		System.out.println(distance[n-1][n-1]);
	}
	
}
