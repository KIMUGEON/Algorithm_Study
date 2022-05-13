package study_0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] weights = new int[N+1]; // 물건의 무게
		int[] profits = new int[N+1]; // 물건의 가치
		int[][] result = new int[N+1][M+1]; // 가치 테이블
		// 입력받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}	
		int itemWeight = 0;
		int itemBenefit = 0;
		for (int i = 1; i <= N; i++) {
			itemWeight = weights[i]; // 현재 아이템 무게
			itemBenefit = profits[i]; // 현재 아이템 가치
			// 1부터 목표 무게 까지의 가치 테이블
			for (int j = 1; j <= M; j++) {
				if(itemWeight <= j) { // 현재 아이템 <= 주어진 무게 ( 담을 수 있는 경우 ) - 담는 경우와 담지 않는 경우를 비교
					result[i][j] = Math.max(result[i-1][j], result[i-1][j-itemWeight] + itemBenefit);
				}
				else {
					result[i][j] = result[i-1][j];
				}
			}
		}
		System.out.println(result[N][M]);
	}

}
