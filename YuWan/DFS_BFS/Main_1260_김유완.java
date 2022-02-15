package study_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_김유완 {
	static int N,M,V;
	static int[][] arr;
	static boolean[] is;
	static Queue<Integer> q = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 개수
		M = Integer.parseInt(st.nextToken()); // 선의 수
		V = Integer.parseInt(st.nextToken()); // 탐색 시작하는 간선의 수
		arr = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1; // 연결된 부분 체크
			arr[y][x] = 1;
		}
		is = new boolean[N+1]; // 1부터니까
		dfs(V);
		sb.append('\n');
		
		is = new boolean[N+1]; // 1부터니까
		bfs(V);
		
		System.out.print(sb);
	}
	public static void dfs(int index) {
		is[index] = true; // 방문표시하기
		sb.append(index).append(" ");
		if(index == N+1) return; // 조건
		for(int i=1;i<N+1;i++) {
			if(arr[index][i]==1 && is[i]==false) {
				dfs(i);
			}
		}
	}
	public static void bfs(int start) {
		q.offer(start); // 첫값 넣기
		is[start] = true;
		while(!q.isEmpty()) {
			int top = q.poll();
			sb.append(top).append(" ");
			for(int i=1;i<N+1;i++) {
				if(arr[top][i]==1 && is[i]==false) {
					q.offer(i);
					is[i] = true;
				}
			}
		}
	}
}