package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/16234
 * 걸린 시간 : 120분
*/
public class BOJ_16234_인구_이동 {
	static int N, L, R;
	static int[][] map, union;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}}; // 4방 탐색
	static int total, visitCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 땅의 가로, 세로 크기
		L = Integer.parseInt(st.nextToken()); // L명 이상
		R = Integer.parseInt(st.nextToken()); // R명 이하
		map = new int[N][N]; // 각 칸의 인구수를 저장할 배열
		union = new int[N][N]; // 같은 연합임을 표시해줄 배열
		total = N*N; // 총 국가의 개수
		
		// 인구수 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0; // 지난 일수 (결과값)
		
		// 인구이동이 발생하지 않을 때까지 반복
		while (true) {
			// union 배열 0으로 초기화
			for (int i = 0; i < N; i++) {
				Arrays.fill(union[i], 0);
			}
			
			int n = 1; // 연합번호
			visitCnt = 0; // 방문한 국가 수
			
			// 모든 국가가 연합을 이룰 때까지 반복
			for (n = 1; n <= total; n++) {
				int startRow = 0;
				int startCol = 0;
				
				// bfs 탐색을 시작할 칸의 좌표 찾기
				outer:for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// union 배열값이 0이면 그 칸은 아직 아무 연합에 속하지 않았단 뜻
						if(union[i][j] == 0) {
							startRow = i;
							startCol = j;
							visitCnt++;
							break outer;
						}
					}
				}
				
				union[startRow][startCol] = n; // 시작위치에 연합번호 표시
				
				// 4방 탐색 -> 탐색 시작 칸이 연합을 이룰 수 있는지 체크
				for (int i = 0; i < 4; i++) {
					int nr = startRow+deltas[i][0];
					int nc = startCol+deltas[i][1];
					
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && union[nr][nc] == 0) {
						bfs(startRow, startCol, n); // n번 연합 구하러 bfs 탐색 시작
						break;
					}
					
				}
							
				// 모든 국가를 방문했으면 인구이동 끝
				if(visitCnt == total) break;
			}
			
			// 연합번호 개수가 전체 국가수와 같으면 인구이동이 발생하지 않았다는 뜻
			if(n == total) break;
			
			day++; // 하루 증가
		}
		
		// 결과 출력
		System.out.println(day);
	}

	/**
	 * @param startRow : 탐색을 시작할 행 좌표
	 * @param startCol : 탐색을 시작할 열 좌표
	 * @param n : 연합번호 (몇번째 연합으로 표시할지)
	 */
	private static void bfs(int startRow, int startCol, int n) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {startRow, startCol}); // 시작위치 queue에 넣기
		
		List<int[]> countries = new ArrayList<int[]>(); // 연합국가 리스트
		countries.add(new int[] {startRow, startCol}); // 시작위치 리스트에 넣기
		
		int cnt = 1; // 연합을 이루고 있는 칸의 개수
		int sum = map[startRow][startCol]; // 연합의 총 인구수 -> 시작위치의 인구수로 초기화
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curRow = current[0];
			int curCol = current[1];
			
			// 4방 탐색 -> 조건을 만족하면 같은 연합으로 표시하기
			for (int i = 0; i < 4; i++) {
				int nr = curRow+deltas[i][0];
				int nc = curCol+deltas[i][1];
				
				// 경계체크, 이미 연합이 존재하는지 체크
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && union[nr][nc] == 0) {
					int diff = Math.abs(map[curRow][curCol] - map[nr][nc]); // 두 나라의 인구 차이
					// 인구 차이가 L명 이상, R명 이하이면 같은 연합으로 표시하고 queue에 넣기
					if(diff >= L && diff <= R) {
						cnt++; // 연합을 이루고 있는 칸의 개수 1 증가
						sum += map[nr][nc]; // 이동 국가의 인구 더하기
						union[nr][nc] = n;
						countries.add(new int[] {nr, nc});
						queue.offer(new int[] {nr, nc});
						visitCnt++; // 방문한 국가 1 증가
					}
				}
			}
		}
		
		// 인구 이동하기
		move(n, cnt, sum, countries);
	}

	/**
	 * n에 해당하는 연합국 인구 이동하기
	 * @param n : 연합번호
	 * @param cnt : 연합을 이루고 있는 칸의 개수
	 * @param sum : 연합의 인구수
	 * @param countries : 연합국가 좌표 리스트
	 */
	private static void move(int n, int cnt, int sum, List<int[]> countries) {
		// 각 칸의 인구수 = (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
		int val = sum / cnt;
		
		// 각 연합국의 인구수 조절하기
		for (int[] country : countries) {
			int row = country[0];
			int col = country[1];
			
			map[row][col] = val;
		}
	}

}
