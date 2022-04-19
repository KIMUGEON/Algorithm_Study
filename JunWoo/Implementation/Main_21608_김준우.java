package _0419_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_21608_김준우 {
	static int N, N2;
	static int[][] map, preference;
	static int[] dr = {-1,1,0,0};	//상하좌우
	static int[] dc = {0,0,-1,1};	//상하좌우
	
	public static int satisfied() {
		int score = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt_prefer = 0;
				
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr<0 || nc< 0 || nr>= N || nc>= N) continue;
					int[] p = preference[map[i][j]];
					for (int k = 0; k < p.length; k++) {
						if(p[k] == map[nr][nc]) {cnt_prefer++; break;}
					}
				}
				
				if( cnt_prefer > 0) {
					int temp = 1;
					for (int k = 0; k < cnt_prefer-1; k++) {
						temp = temp * 10;
					}
					score += temp;
				}
			}
		}
		
		return score;
	}
	public static void findSeat(int s, int[] p) {
		LinkedList<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] > 0) continue;	//값이 있으면 스킵
				
				int cnt_prefer = 0;	//인접한 좋아하는 학생 수
				int cnt_empty = 0;	//인접한 빈자리 수
				
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr<0 || nc< 0 || nr>= N || nc>= N) continue;
					if(map[nr][nc] == 0) { cnt_empty++;}
					else {
						for (int k = 0; k < p.length; k++) {
							if(p[k] == map[nr][nc]) {cnt_prefer++; break;}
						}
					}
				}
				
				int[] temp = {i, j, cnt_prefer, cnt_empty};	//행, 열, 인접한 좋아하는 학생 수, 인접한 빈자리 수
				
				q.add(temp);
			}
		}
		
		int max_pref = 0;
		for (int i = 0; i < q.size(); i++) {
			int pref = q.get(i)[2];
			if(pref>max_pref) max_pref = pref;
		}
		for (int i = 0; i < q.size(); i++) {
			int pref = q.get(i)[2];
			if(pref<max_pref) {q.remove(i); i--;}
		}
		
		int max_empty = 0;
		for (int i = 0; i < q.size(); i++) {
			int empty = q.get(i)[3];
			if(empty>max_empty) max_empty = empty;
		}
		for (int i = 0; i < q.size(); i++) {
			int empty = q.get(i)[3];
			if(empty<max_empty) {q.remove(i); i--;}
		}

		int[] selected = q.poll();
		map[selected[0]][selected[1]] = s;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		N2 = N * N;	//N 제곱
		map = new int[N][N];	//맵 크기
		preference = new int[N2+1][4];
		
		for (int i = 0; i < N2; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int[] prefer = new int[4];
			for (int j = 0; j < prefer.length; j++) {
				prefer[j] = Integer.parseInt(st.nextToken());
			}
			
			preference[s] = prefer;
			
			findSeat(s, prefer);
		}
		
		System.out.println(satisfied());
		
	}

}
