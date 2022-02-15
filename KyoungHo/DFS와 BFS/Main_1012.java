package Silver2;

import java.util.Scanner;

public class Main_1012 {//유기농 배추

	static int N,M,배추[][],num,count;
	static boolean visit[][];
	static int deltas[][] = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 1; test<=T; test++) {
		M = sc.nextInt();	//가로
		N = sc.nextInt();	//세로
		num = sc.nextInt();	//배추 개수
		배추 = new int [N][M];	//배추 배열
		visit = new boolean[N][M];	//방문체크
		count = 0;
		
		for(int i=0; i<num; i++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			배추[r][c] = 1; //배추 있는 땅에 1
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(배추[i][j] == 1 && !visit[i][j]) { //배추 있고 방문 x
					dfs(i,j);
					count++; //배추 카운트
				}
			}
		}
		
		System.out.println(count);
		}
	}
	
	public static void dfs(int i, int j) { //인접 배추 탐색 후 true로 만들기 (배추 뭉탱이만 카운트 하면 됨)
		visit[i][j] = true;
		
		for(int d=0; d<4; d++) {
			int dx = i + deltas[d][0];
			int dy = j + deltas[d][1];
			if(dx>=0 && dx<N && dy>=0 && dy<M) {
				if(배추[dx][dy] == 1 && !visit[dx][dy]) {
					dfs(dx,dy);
				}
			}
		}
	}

}
