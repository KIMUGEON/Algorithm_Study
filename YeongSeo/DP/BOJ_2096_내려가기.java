package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2096
 * 걸린 시간 : 60분
*/
public class BOJ_2096_내려가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());// 줄의 개수
		int[][] map = new int[N][3]; // N개 줄의 숫자를 입력할 배열
		int[][] min = new int[N][3]; // 자기 자신까지 올때까지의 최소 점수를 저장할 동적 테이블
		int[][] max = new int[N][3]; // 자기 자신까지 올때까지의 최대 점수를 저장할 동적 테이블
		
		// 숫자 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// min, max 각각 최대수, 최소수로 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
			Arrays.fill(max[i], Integer.MIN_VALUE);
		}
		
		// min, max의 첫째줄 각각 map의 첫째줄 숫자로 초기화
		for (int i = 0; i < 3; i++) {
			min[0][i] = map[0][i];
			max[0][i] = map[0][i];
		}
		
		// 한줄씩 내려가면서 각 칸의 최소점수, 최대점수 구하기
		for (int i = 0; i < N-1; i++) { // 줄
			for (int j = 0; j < 3; j++) { // 각 줄의 칸 (0, 1, 2)
				// 좌하 ↙ 로 이동 가능할 경우
				if (j-1 >= 0) {
					// 최소 점수 갱신 가능할 경우
					if (min[i][j] + map[i+1][j-1] < min[i+1][j-1]) {
						min[i+1][j-1] = min[i][j] + map[i+1][j-1];
					}
					// 최대 점수 갱신 가능할 경우
					if (max[i][j] + map[i+1][j-1] > max[i+1][j-1]) {
						max[i+1][j-1] = max[i][j] + map[i+1][j-1];
					}
				}
				// 우하 ↘ 로 이동 가능할 경우
				if (j+1 < 3) {
					// 최소 점수 갱신 가능할 경우
					if (min[i][j] + map[i+1][j+1] < min[i+1][j+1]) {
						min[i+1][j+1] = min[i][j] + map[i+1][j+1];
					}
					// 최대 점수 갱신 가능할 경우
					if (max[i][j] + map[i+1][j+1] > max[i+1][j+1]) {
						max[i+1][j+1] = max[i][j] + map[i+1][j+1];
					}
				}
				
				// 하 ↓ 는 모든 위치 다 가능
				
				// 최소 점수 갱신 가능할 경우
				if (min[i][j] + map[i+1][j] < min[i+1][j]) {
					min[i+1][j] = min[i][j] + map[i+1][j];
				}
				// 최대 점수 갱신 가능할 경우
				if (max[i][j] + map[i+1][j] > max[i+1][j]) {
					max[i+1][j] = max[i][j] + map[i+1][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		
		sb.append(Math.max(Math.max(max[N-1][0], max[N-1][1]), max[N-1][2])); // 최대 점수 추가
		sb.append(" ");
		sb.append(Math.min(Math.min(min[N-1][0], min[N-1][1]), min[N-1][2])); // 최소 점수 추가
		
		System.out.println(sb); // 결과 출력
	}

}
