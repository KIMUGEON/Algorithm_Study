package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2644
 * 걸린 시간 : 30분
 * 리뷰 : 사람들 수가 최대 100까지 주어지므로 메모리 제한에 걸리지 않고
 * 인접 행렬로 충분히 구현할 수 있을것 같다 생각하였다.
*/
public class BOJ_2644_촌수계산 {
	static int n, end, res;
	static int[][] adjMatrix;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 사람의 수
		adjMatrix = new int[n+1][n+1]; // 인접 행렬
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
		int start = Integer.parseInt(st.nextToken()); // 촌수 계산 시작할 사람 번호
		end = Integer.parseInt(st.nextToken()); // 촌수 계산 목표로 찾아갈 사람 번호
		int m = Integer.parseInt(br.readLine()); // 관계의 개수
		
		// 부모 자식간의 관계 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");;
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// x와 y를 부모 자식 관계로 연결
			adjMatrix[x][y] = 1;
			adjMatrix[y][x] = 1;
		}
		
		visited = new boolean[n+1]; // 방문체크를 위한 배열
		res = -1; // 결과값 -1로 초기화
		
		dfs(start, 0); // 시작 번호로 깊이우선탐색 시작
		
		System.out.println(res); // 결과값 출력
	}

	/**
	 * @param current : 현재 방문하고 있는 정점 번호
	 * @param cnt : 현재까지의 촌수 누적값
	 */
	private static void dfs(int current, int cnt) {
		if(current == end) {
			// 현재 정점 번호가 목표 번호와 같으면 결과값에 현재 촌수 누적값 저장
			res = cnt;
			return;
		}
		
		visited[current] = true; // 현재 정점 방문 체크
		
		// 현재 정점과 인접한 정점을 차례대로 방문
		for (int i = 1; i <= n; i++) {
			if(adjMatrix[current][i] == 1 && !visited[i]) {
				dfs(i, cnt+1);
			}
		}
	}

}
