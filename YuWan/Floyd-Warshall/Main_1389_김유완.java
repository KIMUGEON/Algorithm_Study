package study_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1389_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int INF = 9999999;
		int min = Integer.MAX_VALUE;
		int result = 0; // 결과는 사람 번호니까
		int N = Integer.parseInt(st.nextToken()); // 유저의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		int[][] arr = new int[N+1][N+1]; // 계속 사람 번호로 할테니까 +1해놓기
		// 큰 값 다 넣어 놓기 자기자신 가는거 뺴고
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				arr[i][j] = INF;
				if(i==j) arr[i][j] = 0;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r][c] = arr[c][r] = 1; // 둘다 서로 친구
		}
		for (int k = 1; k < N+1; k++) { // 경유지
			for (int i = 1; i < N+1; i++) { // 출발지
				for (int j = 1; j < N+1; j++) { // 도착지
					if(arr[i][j] > arr[i][k] + arr[k][j]) { // 얘는 최단 경로 봐야해
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		// 각각 합 구하기
		for (int i = 1; i < N+1; i++) {
			int num = 0;
			for (int j = 1; j < N+1; j++) {
				num += arr[i][j];
			}
			if(num < min) {
				min = num;
				result = i; // 최소일때의 사람 번호 구하는거니까
			}
		}
		System.out.println(result);
	}
}