package _0308_다익스트라;
/* 미로만들기
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2665_김준우 {
	static int n;
	static boolean[][] rooms;		//각 방의 정보
	static int[][] visited;		//방문한 방의 정보
	static int[] dr = {-1,1,0,0};	//상화좌우
	static int[] dc = {0,0,-1,1};	//상하좌우
	
	static class Node{
		int r, c;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(r,c));
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				
				if(nr >= 0 && nr<n && nc >= 0 && nc<n) {
					if(visited[nr][nc] <= visited[node.r][node.c]) continue;
					
					if(rooms[nr][nc]) {
						q.add(new Node(nr,nc));
						visited[nr][nc] = visited[node.r][node.c];
					}
					else {
						q.add(new Node(nr,nc));
						visited[nr][nc] = visited[node.r][node.c] + 1;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		//=====input 1st line==============
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		rooms = new boolean[n][n];		//각 방의 정보
		visited = new int[n][n];		//각 방의 정보
		
		//=====input rest of line==========
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				if(str.charAt(j) == '1') {
					rooms[i][j] = true;	//흰색방이면 true
				}
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(0,0);
		
		System.out.println(visited[n-1][n-1]);
	}

}
