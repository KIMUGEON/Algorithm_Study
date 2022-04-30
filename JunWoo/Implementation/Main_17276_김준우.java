package _0422_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17276_김준우 {
	static int n, d;
	static int[][] arr;
	static int[] dr = {-1,-1,0,1,1,1,0,-1}; 	//12시부터 시계방향순
	static int[] dc = {0,1,1,1,0,-1,-1,-1}; 	//12시부터 시계방향순
	
	public static void rotate45() {
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			copy[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
		
		for (int i = 1; i <= n/2; i++) {
			for (int d = 0; d < 8; d++) {
				int center = n/2;
				//
				int cr = center + dr[(d+1)%8]*i;
				int cc = center + dc[(d+1)%8]*i;
				int nr = center + dr[d]*i;
				int nc = center + dc[d]*i;
				arr[cr][cc] = copy[nr][nc];
			}
		}
	}
	
	public static void rotateNegative45() {
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			copy[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
		
		for (int i = 1; i <= n/2; i++) {
			for (int d = 0; d < 8; d++) {
				int center = n/2;
				int cr = center + dr[d]*i;
				int cc = center + dc[d]*i;
				int nr = center + dr[(d+1)%8]*i;
				int nc = center + dc[(d+1)%8]*i;
				arr[cr][cc] = copy[nr][nc];
			}
		}
	}
	
	public static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			while(d != 0) {
				if(d>=45) {
					rotate45();
					d -= 45;
				} 
				else if(d <= -45) {
					rotateNegative45();
					d += 45;
				}
			}
			print();
		}
		
	}

}
