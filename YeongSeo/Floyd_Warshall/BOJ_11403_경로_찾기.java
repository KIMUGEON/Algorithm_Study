package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/11403
 * 걸린 시간 : 20분
*/
public class BOJ_11403_경로_찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정점의 개수
		int[][] adjMatrix = new int[N][N]; // 인접 행렬
		StringTokenizer st;
		
		// 인접 행렬 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 플로이드 와샬 알고리즘 적용
		for (int k = 0; k < N; k++) { // 경유지
			for (int i = 0; i < N; i++) { // 출발지
				for (int j = 0; j < N; j++) { // 도착지
					// (출발지->경유지)가 인접하고 (경유지->도착지)가 인접할 경우
					// (출발지->경유지->출발지)로 가는 경로 존재
					if (adjMatrix[i][k] == 1 && adjMatrix[k][j] == 1) adjMatrix[i][j] = 1;
				}
			}
		}
		
		// 결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}

	}

}
