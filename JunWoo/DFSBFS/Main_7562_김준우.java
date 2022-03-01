package _0215_DFSBFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_김준우 {
	static int L, R, C, tR, tC;
	static int[][] board;
	static boolean[][] visit;

	static int[] dr = {-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {-2,-1,1,2,2,1,-1,-2};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			//=======input=-==============
			L = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());	//시작 행
			C = Integer.parseInt(st.nextToken());	//시작 열
			st = new StringTokenizer(br.readLine());	
			tR = Integer.parseInt(st.nextToken());	//목표행
			tC = Integer.parseInt(st.nextToken());	//목표 열
			
			board = new int[L][L];
			visit = new boolean[L][L];
			
			move(R,C);
		}
	}
	
	public static void move(int r, int c) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(r); q.offer(c);
		visit[r][c] = true;
		
		if(r == tR && c ==tC) {
			System.out.println(0);
			return;
		}
		
		loop:
		while(!q.isEmpty()) {
			int cr = q.poll();
			int cc = q.poll();
			for(int d = 0; d<8;d++) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				
				if(nr>=0 && nr<L && nc>=0 && nc<L ) {
					if(!visit[nr][nc]) {
						q.offer(nr);
						q.offer(nc);
						visit[nr][nc] = true;
						board[nr][nc] = board[cr][cc]+1; 
						if(nr == tR && nc == tC) {
							System.out.println(board[nr][nc]);
							break loop;
						}
					}
				}
				
				
			}
			
		}
	}

}
