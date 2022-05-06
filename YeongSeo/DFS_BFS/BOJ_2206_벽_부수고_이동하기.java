package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2206
 * 걸린 시간 : 100분
 * 리뷰 : 벽을 부수고 지나온 경로와 벽을 부수지 않고 지나온 경로의 방문체크를 따로 해주어야 하는게 핵심인 문제였다.
 * 그 처리를 어떻게 할지 고민하다가 백준 1600 문제와 똑같이 삼차원 방문체크 배열을 이용해서 해결하였다.
*/
public class BOJ_2206_벽_부수고_이동하기 {
	public static class Position implements Comparable<Position>{
		int x, y; // 위치 좌표
		int dist; // 현재까지 지나온 거리
		int wall; // 벽을 부순 횟수
		
		public Position(int x, int y, int dist, int wall) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.wall = wall;
		}

		@Override
		public int compareTo(Position o) { // 거리가 작은 순서대로 오름차순 정렬
			return this.dist - o.dist;
		}
		
	}
	
	static int N, M, ans;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 맵의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 맵의 가로 크기
		map = new int[N][M]; // 맵 행렬
		// 방문체크 배열 (벽을 부쉈을 경우와 부수지 않았을 경우 2개로 나눠서)
		// visited[0][][] : 벽을 부수지 않았을 경우
		// visited[1][][] : 벽을 부쉈을 경우
		visited = new boolean[2][N][M];
		
		// 맵 정보 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		ans = -1; // 문제의 답 (-1로 초기화)
		
		bfs(); // bfs 탐색 시작
		
		// 결과 출력
		System.out.println(ans);
	}

	private static void bfs() {
		PriorityQueue<Position> pQueue = new PriorityQueue<>(); // 우선순위
		pQueue.offer(new Position(0, 0, 1, 0)); // 시작 위치 pQueue에 넣기
		visited[0][0][0] = true; // 시작 위치 방문 체크
		
		while (!pQueue.isEmpty()) {
			Position current = pQueue.poll(); // 현재 위치
			int wall = current.wall; // 현재 벽을 부순 횟수
			
			// 현재 위치가 도착 위치일 경우 -> 현재 거리를 저장하고 bfs 탐색 종료
			if (current.x == N-1 && current.y == M-1) {
				ans = current.dist;
				break;
			}
			
			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int nx = current.x + deltas[i][0];
				int ny = current.y + deltas[i][1];
				
				// 경계를 벗어날 경우 pass
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				// 이동 위치가 벽이고, 현재 벽을 한번도 안부셨고, 방문하지 않았을 경우
				if (map[nx][ny] == 1 && current.wall == 0 && !visited[wall][nx][ny]) {
					visited[wall][nx][ny] = true;
					pQueue.offer(new Position(nx, ny, current.dist+1, 1));
				}
				// 이동 위치가 벽이 아니고, 방문하지 않았을 경우
				else if (map[nx][ny] == 0 && !visited[wall][nx][ny]) {
					visited[wall][nx][ny] = true;
					pQueue.offer(new Position(nx, ny, current.dist+1, current.wall));
				}
			}
		}
	}

}
