package _0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2573_김준우 {
	static int n;
	static int[][] loc;
	static boolean[] visited;
	static boolean happy;
	
	public static void bfs(int r, int cnt) {
		if(happy) return;
		if(cnt == n) {
			if(getDist(r, n+1) > 1000) return;
			happy = true;
			return;
		}
		//visited[r] = true;
		for(int i = 1;i <= n; i++) {
			if(visited[i]) continue;
			if(getDist(r, i)>1000) continue;
			visited[i] = true;
			bfs(i, cnt+1);
			visited[i] = false;
		}
	}
	
	public static int getDist(int a, int b) {
		int dist = Math.abs(loc[a][0] - loc[b][0]) + Math.abs(loc[a][1] - loc[b][1]);
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			n = Integer.parseInt(br.readLine());
			loc = new int[n+2][2];
			visited = new boolean[n+2];
			happy = false;
			
			for(int i = 0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			}
			
			bfs(0,0);
			
			if(happy) {
				sb.append("happy\n");
			}
			else {
				sb.append("sad\n");
			}
		}
		
		System.out.println(sb);
	}
}
