package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1389
 * 걸린 시간 : 20분
*/
public class BOJ_1389_케빈_베이컨의_6단계_법칙 {
	static final int INF = 999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 유저의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		int[][] adjMatrix = new int[N+1][N+1]; // 인접 행렬
		
		// 친구 관계 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 친구 a
			int b = Integer.parseInt(st.nextToken()); // 친구 b
			// a와 b 양방향으로 연결
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1;
		}
		
		// 자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if (i != j && adjMatrix[i][j] == 0) {
					adjMatrix[i][j] = INF;
				}
			}
		}
		
		// 플로이드 와샬 알고리즘 적용
		for(int k = 1; k <= N; k++) { // 경유지
			for(int i = 1; i <= N; i++) { // 출발지
				if(i == k) continue; // 출발지와 경유지가 같다면 다음 출발지
				for(int j = 1; j <= N; j++) { // 도착지
					if(i == j || k == j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE; // 가장 작은 케빈 베이컨 값 
		int ans = 0; // 케빈 베이컨 수가 가장 작은 사람
		
		// 각 유저의 케빈 베이컨 수 구하기
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			for(int j = 1; j <= N; j++) {
				sum += adjMatrix[i][j];
			}
			
			// 케빈 베이컨 수가 현재 최소값보다 작을 경우 min과 ans 갱신
			if (sum < min) {
				min = sum;
				ans = i;
			}
		}
		
		// 결과 출력
		System.out.println(ans);
	}

}
