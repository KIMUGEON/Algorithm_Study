package study_0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_2665_김유완 {
	static int n, min;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr;
	static boolean[][] visited; // 최소비용 확정여부
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	// 행 열 개수
	static class Node implements Comparable<Node>{
		int r,c,count;

		public Node(int r, int c, int count) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			return this.count - o.count;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		min = Integer.MAX_VALUE;
		// 입력 받기
		for (int i = 0; i < n; i++) {
			String str = br.readLine();// 붙어있으니까
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		pq.offer(new Node(0,0,0));
		visited[0][0] = true;
		bfs();
		System.out.println(min);
	}
	public static void bfs() {	
		while(!pq.isEmpty()) {
			// 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			Node current = pq.poll();
			// 끝점에 가면 도착하는 것
			if(current.r == n-1 && current.c == n-1) {
				// 최소값인지 확인하기
				if(min > current.count) min = current.count;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = current.r + dx[i];
				int nc = current.c + dy[i];
				if(nr>=0 && nc>=0 && nr<n && nc<n && !visited[nr][nc]) {
					if(arr[nr][nc] == 0) { // 빈방
						pq.add(new Node(nr,nc,current.count+1));
					}
					else {
						pq.add(new Node(nr,nc,current.count));
					}
					visited[nr][nc] = true;
				}
			}
		}
	}
}
