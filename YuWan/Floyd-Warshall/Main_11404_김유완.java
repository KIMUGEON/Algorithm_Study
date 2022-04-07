package study_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404_김유완 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int INF = 9999999;
		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수
		int[][] arr = new int[n+1][n+1];
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				arr[i][j] = INF;
				if(i == j) arr[i][j] = 0;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(arr[r][c] > w) arr[r][c] = w; // 예시 처럼 3 5 1 / 3 5 10 이렇게 둘다 입력될수있는데 그 중 최소 골라야함
		}
		for (int k = 1; k < n+1; k++) { // 경유지
			for (int i = 1; i < n+1; i++) { // 출발지
				for (int j = 1; j < n+1; j++) { // 도착지
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(arr[i][j] == INF) arr[i][j] = 0;
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}