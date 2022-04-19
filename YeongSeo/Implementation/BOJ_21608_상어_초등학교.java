package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/21608
 * 걸린 시간 : 60분
*/
public class BOJ_21608_상어_초등학교 {
	public static class Position implements Comparable<Position>{
		int r, c; // 현재 위치의 행, 열 좌표
		int like; // 인접한 칸 중 좋아하는 학생이 있는 칸의 수
		int empty; // 인접한 칸 중 비어있는 칸의 수
		
		public Position(int r, int c, int like, int empty) {
			super();
			this.r = r;
			this.c = c;
			this.like = like;
			this.empty = empty;
		}

		@Override
		public int compareTo(Position o) {
			//  like, empty, r이 같으면 열 번호가 작은 순서로 오름차순 정렬
			if (this.like == o.like && this.empty == o.empty && this.r == o.r) {
				return this.c - o.c;
			}
			// like, empty가 같으면 행 번호가 작은 순서로 오름차순 정렬
			else if (this.like == o.like && this.empty == o.empty) {
				return this.r - o.r;
			}
			// like가 같으면 비어있는 칸이 많은 순서로 내림차순 정렬
			else if (this.like == o.like) {
				return o.empty - this.empty;
			}
			
			// 좋아하는 학생이 인접한 칸에 많은 순서로 내림차순 정렬
			return o.like - this.like;
		}
		
	}
	
	static int N, cnt, ans;
	static int[][] map, students;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 교실의 가로,세로 크기
		cnt = N * N; // 학생의 수
		map = new int[N][N]; // 교실 격자 배열
		students = new int[cnt+1][4]; // 각 학생이 좋아하는 학생의 번호 배열
		
		// 각 학생이 좋아하는 학생의 번호 입력
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 학생의 번호
			
			// n번 학생이 좋아하는 학생의 번호 4개 입력
			for (int j = 0; j < 4; j++) {
				students[n][j] = Integer.parseInt(st.nextToken());
			}
			
			// n번 학생의 자리 정하러 가기
			setSeat(n, students[n]);
		}
		
		ans = 0; // 학생의 만족도 총 합
		calculate(); // 만족도 계산하러 가기
		
		// 결과 출력
		System.out.println(ans);
	}

	private static void calculate() {
		// 모든 칸 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int n = map[i][j]; // 현재 위치에 앉아있는 학생의 번호
				int likeCnt = 0; // 인접 칸 중 좋아하는 학생의 수
				
				// 인접한 상하좌우 칸 체크
				for (int k = 0; k < 4; k++) {
					int nr = i + deltas[k][0];
					int nc = j + deltas[k][1];
					
					// 경계를 벗어날 경우 pass
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

					// 인접 칸이 좋아하는 학생인지 체크
					for (int num: students[n]) {
						if (map[nr][nc] == num) {
							likeCnt += 1;
							break;
						}
					}
				}
				
				ans += Math.pow(10, likeCnt-1); // 현재 학생의 만족도 계산해서 누적하기
			}
		}
		

	}

	// n번 학생의 자리를 정하는 함수 
	// n: 학생의 번호, student: n번 학생이 좋아하는 학생의 번호 배열
	private static void setSeat(int n, int[] student) {
		PriorityQueue<Position> pQueue = new PriorityQueue<>();
		
		// 교실의 모든 칸 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 현재 칸이 비어있을 경우
				if (map[i][j] == 0) {
					// 현재 칸에 대한 위치 객체 만들기
					Position current = new Position(i, j, 0, 0);
					
					// 인접한 상하좌우 칸 체크
					for (int k = 0; k < 4; k++) {
						int nr = current.r + deltas[k][0];
						int nc = current.c + deltas[k][1];
						
						// 경계를 벗어날 경우 pass
						if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						
						// 인접 칸에 다른 학생이 앉아있는 경우
						if (map[nr][nc] != 0) {		
							// student 배열의 값을 하나씩 꺼내서 비교해보기
							for (int num: student) {
								// 좋아하는 학생일 경우
								if (map[nr][nc] == num) {
									current.like += 1; // like 1 증가
									break;
								}
							}
						}
						// 인접 칸이 비어있는 경우
						else if (map[nr][nc] == 0) {
							current.empty += 1; // empty 1 증가
						}
					}
					
					pQueue.offer(current); // 현재 위치 객체 pQueue에 넣기
				}
			}
		}
		
		Position seat = pQueue.poll(); // 우선순위가 가장 높은 위치 반환
		map[seat.r][seat.c] = n; // 그 위치에 현재 학생 번호 저장
	}

}
