package study_0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17276_김유완 {
	static int n,d;
	static int[][] arr;
	static int[][] temp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 배열 크기
			d = Integer.parseInt(st.nextToken()); // 각도
			arr = new int[n][n];
			temp = new int[n][n];
			for (int r = 0; r < n; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					temp[r][c] = arr[r][c];
				}
			}
			// -270,+90 같으니까 
			int dir = d;
			if(dir < 0) dir = (dir + 360) / 45;
			else dir = d / 45;
			// 회전
			if(dir >= 5) rotateL(8-dir); // 180 넘으면 왼쪽 회전시키게
			else rotateR(dir);
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					sb.append(temp[r][c]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	public static void rotateR(int dir) { // 오른쪽 회전
		for (int t = 0; t < dir; t++) {
			for (int i = 0; i < n; i++) {
				temp[i][n-1-i] = arr[i][n/2];
				temp[n/2][n-1-i] = arr[i][n-1-i];
				temp[n-1-i][n-1-i] = arr[n/2][n-1-i];
				temp[n-1-i][n/2] = arr[n-1-i][n-1-i];
			}
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					arr[r][c] = temp[r][c];
				}
			}
		}
	}
	public static void rotateL(int dir) { // 왼쪽 회전
		for (int t = 0; t < dir; t++) {
			for (int i = 0; i < n; i++) {
				temp[i][i] = arr[i][n/2];
				temp[n/2][i] = arr[i][i];
				temp[n-1-i][i] = arr[n/2][i];
				temp[n-1-i][n/2] = arr[n-1-i][i];
			}
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					arr[r][c] = temp[r][c];
				}
			}
		}
	}
}
