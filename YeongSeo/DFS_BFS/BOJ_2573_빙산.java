package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2573
 * 걸린 시간 : 50분
 * 리뷰 : 4방탐색을 이용해서 각 빙산이 얼만큼 녹을 것인지를 계산하고,
 * 너비우선탐색을 통해서 빙산들이 서로 분리되어 있는지 아닌지 체크해주면 되는 문제였다.
 * 여기서 중요한건 맨 처음 입력에 이미 빙산이 분리되어 있는 상태로 입력될 수도 있으므로,
 * 빙산을 녹이기 전에 먼저 빙산이 분뢰되어 있는지를 체크해주어야 한다.
 * 또, 배열의 모든 값이 0이면 빙산이 전부 녹았다는 뜻이므로 0을 출력해주기 위해서 이를 체크하기 위한 반복문도 넣어주면 된다.
*/
public class BOJ_2573_빙산 {
	static int N, M, year;
	static int[][] map, temp;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 4방 탐색 deltas
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행의 개수
		M = Integer.parseInt(st.nextToken()); // 열의 개수
		map = new int[N][M]; // 빙산의 높이를 저장할 배열
		temp = new int[N][M]; // 녹은 빙산의 상태를 저장할 배열
		
		// 빙산의 높이 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		
		year = 0; // 지난 시간(년도)
		
		// 빙산이 분리될 때까지 반복
		while (true) {
			// 빙산이 전부 녹았는지 확인
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) break outer;
					// 빙산이 전부 0이면 year을 0으로 출력하고 프로그램 종료
					if(i == N-1 && j == M-1) {
						year = 0;
						System.out.println(year);
						return;
					}
				}
			}	
			
			int startRow = 0; // 탐색을 시작할 행
			int startCol = 0; // 탐색을 시작할 열
			
			// 처음 탐색을 시작할 빙산 위치 찾기
			outer: for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] != 0) {
						startRow = r;
						startCol = c;
						break outer;
					}
				}
			}
			
			// 빙산이 분리될 수 있는지 검사 -> 분리되면 true 아니면 false 반환
			if(isSeparable(startRow, startCol)) {
				// 분리되면 무한반복문 나가기
				break;
			}
			
			
			// 빙산 녹이기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 높이가 0이 아닌 빙산만 4방에 위치하는 빙산 수만큼 높이 빼기
					if (map[r][c] != 0) {
						for (int i= 0; i < 4; i++) {
							int nr = r + deltas[i][0];
							int nc = c + deltas[i][1];
							
							if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
								temp[r][c] -= 1;
								
								// 빙산의 높이가 0이면 탐색하지 않고 나가기
								if(temp[r][c] == 0) break;
							}
						}
					}
				}
			}
			
			copyTemp(); // temp 배열을 map 배열에 복사 (빙산 녹은 상태 반영)
			year++; // 1년 증가
		}
		
		// 결과 출력
		System.out.println(year);	
	}

	// temp 배열을 map 배열에 복사하는 함수
	private static void copyTemp() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[i][j];
			}
		}	
	}

	// 빙산이 분리될 수 있는지 여부를 반환하는 함수
	private static boolean isSeparable(int startRow, int startCol) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M]; // 방문체크 배열
		
		// 처음 시작 위치 queue에 넣고 방문 체크
		queue.offer(new int[] {startRow, startCol});
		visited[startRow][startCol] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curRow = current[0];
			int curCol = current[1];
			
			for (int i= 0; i < 4; i++) {
				int nr = curRow + deltas[i][0];
				int nc = curCol + deltas[i][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] != 0) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 빙산의 높이가 0이 아니고 방문체크가 안되어있으면 분리되었다는 뜻
				if(map[i][j] != 0 && !visited[i][j]) return true;
			}
		}	
		
		return false;
	}

}
