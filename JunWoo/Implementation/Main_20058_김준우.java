package _0425_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20058_김준우 {
	static int N, Q, size;
	static int[][] map, copy;
	static int[][] visited;
	
	//사방탐색 상하좌우 
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void firestorm(int L) {
		int area = (int)Math.pow(2, L);	//배열돌리기 가로세로 길이
		copyMap();	//기존 맵 카피
		for (int i = 0; i < size/area; i++) {
			for (int j = 0; j < size/area; j++) {
				rotate(i*area, j*area, area/2);
			}
		}
		melt();
	}
	
	public static void melt() {
		//기존 맵 복사
		copyMap();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr<0 || nc<0 || nr>=size || nc>= size)continue;
					if(copy[nr][nc] == 0) continue;
					cnt++;
				}
				if(cnt<3 && map[i][j]>0) map[i][j] --;
			}
		}
	}
	
	public static void rotate(int r, int c, int area) {
		for (int i = 0; i < area*2; i++) {
			for (int j = 0; j < area*2; j++) {
				map[r+i][c+j] = copy[r + area*2-j-1][c + i];
			}
		}
	}
	
	public static void copyMap() {
		//기존 맵 복사
		copy = new int[size][size];
		for (int i = 0; i < size; i++) {
			copy[i] = Arrays.copyOf(map[i], size);
		}
	}
	
	public static void count() {
		int sum = 0; 	//얼음 개수
		int max = 0;	//가장 큰 덩어리 크기
		visited = new int[size][size]; 
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				//얼음 개수 세기
				int ice = map[i][j];
				sum += ice;
				
				//얼음 덩어리 크기 세기
				if(map[i][j] == 0) continue;
				if(visited[i][j] > 0) continue;
				int volume = dfs(i,j);
				if(volume>max) max = volume;
			}
		}
		System.out.println(sum);
		System.out.println(max);
	}
	
	public static int dfs(int r, int c) {
		int volume = 1;
		visited[r][c] = 1;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>= size || nc>= size) continue;
			if(visited[nr][nc] > 0) continue;
			if(map[nr][nc] <= 0) continue;
			volume += dfs(nr,nc);
		}
		
		return volume;
	}
	
	public static void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		size = (int)Math.pow(2, N);
		
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			firestorm(L);
		}
		count();
		
		
	}

}
