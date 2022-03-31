package _0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2644_김준우 {
	static int n, m, p1, p2, result = 101;
	static int[][] relation;
	static boolean[] visited;

	public static void bfs(int p, int q, int c, String s) {
		if(q == p2) {
			if(result>c && c>0) result = c;
		}
		visited[p] = true;
		if(c == 0) {
			int temp = p;
			p = q;
			q = temp;
		}
		for(int i = 1; i<=n;i++) {
			if(visited[i]) continue;
			if(relation[q][i] == 0) continue;
			bfs(q,i, c + relation[q][i], s+", "+i);
			//visited[q] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		relation = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation[x][y] = 1;
			relation[y][x] = 1;
		}
		
		bfs(p1,p2, 0, "");
		if(result== 101) result= -1;
		
		System.out.println(result);
		
	}

}
