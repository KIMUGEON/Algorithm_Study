package 삼성_SW_역량테스트_기출.Silver1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_21608 { //상어 초등학교

	static int N,map[][],input[][],ans;
	static int deltas[][] = {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}};
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int likeCnt;
		int emptyCnt;
		
		public Node(int x, int y, int likeCnt, int emptyCnt) {
			super();
			this.x = x;
			this.y = y;
			this.likeCnt = likeCnt;
			this.emptyCnt = emptyCnt;
		}

		@Override
		public int compareTo(Node o) {
			if(this.likeCnt>o.likeCnt) return -1;
			else if(this.likeCnt == o.likeCnt) {
				if(this.emptyCnt>o.emptyCnt) return -1;
				else if(this.emptyCnt == o.emptyCnt) {
					if(this.x<o.x) return -1;
					else if(this.x == o.x) {
						if(this.y<o.y) return -1;
					}
				}
			}
			return 1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ans = 0;
		map = new int[N+1][N+1];
		input = new int[N*N+1][4];
		for(int i=0; i<N*N; i++) {
			int student = sc.nextInt();
			for(int j=0; j<4; j++) {
				input[student][j] = sc.nextInt();
			}
			seat(student);
		}
		
		sum();

		System.out.println(ans);
	}

	private static void sum() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int res=0;
				int student = map[i][j];
				
				for(int d=0; d<4; d++) {
					int dx = i+deltas[d][0];
					int dy = j+deltas[d][1];
					
					if(dx>0 && dy>0 && dx<=N && dy<=N) {
						if(check(student,dx,dy)) {
							res++;
						}
					}
				}
				if(res == 1) ans += 1;
				else if(res == 2) ans += 10;
				else if(res == 3) ans += 100;
				else if(res == 4) ans += 1000;
			}
		}
	}

	private static void seat(int student) {
		ArrayList<Node> list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 0) {
					int empty = 0;
					int like = 0;
					
					for(int d=0; d<4; d++) {
						int dx = i+deltas[d][0];
						int dy = j+deltas[d][1];
						
						if(dx>0 && dy>0 && dx<=N && dy<=N) {
							if(check(student,dx,dy)) {
								like++;
							}else if(map[dx][dy] == 0) {
								empty++;
							}
						}
					}
					list.add(new Node(i,j,like,empty));
				}
			}
		}
		Collections.sort(list);
		Node node = list.get(0);
		map[node.x][node.y] = student;
		
	}

	private static boolean check(int student, int dx, int dy) {
		if(input[student][0] == map[dx][dy] ||
			input[student][1] == map[dx][dy]||
			input[student][2] == map[dx][dy]||
			input[student][3] == map[dx][dy]) {
			return true;
		} 
		
		return false;
	}

}
