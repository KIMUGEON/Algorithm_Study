package study_0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261_김유완 {
	static int N,M,min;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr;
	static boolean[][] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		min = Integer.MAX_VALUE;
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
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
			Node current = pq.poll();
			// 마지막 N,M
			if(current.r == N-1 && current.c == M-1) {
				if(min > current.count) min = current.count;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = current.r + dx[i];
				int nc = current.c + dy[i];
				if(nr>=0 && nc>=0 && nr<N && nc<M && !visited[nr][nc]) {
					if(arr[nr][nc] == 1) pq.offer(new Node(nr,nc,current.count+1));
					else pq.offer(new Node(nr, nc, current.count));
					visited[nr][nc] = true;
				}
			}
		}
	}
}
