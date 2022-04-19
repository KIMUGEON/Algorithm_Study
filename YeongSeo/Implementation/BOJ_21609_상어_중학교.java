package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/21609
 * 걸린 시간 : 180분
*/
public class BOJ_21609_상어_중학교 {
	public static class Group implements Comparable<Group>{ // 블록 그룹 객체
		int size; // 그룹의 크기 (포함된 블록의 개수)
		int rainbow; // 무지개 블록의 개수
		int x, y; // 기준 블록의 행과 열 좌표
		
		public Group(int size, int rainbow, int x, int y) {
			super();
			this.size = size;
			this.rainbow = rainbow;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Group o) {
			// 크기, 무지개블록 수, 행이 같으면 열을 기준으로 내림차순 정렬
			if (this.size == o.size && this.rainbow == o.rainbow && this.x == o.x) {
				return o.y - this.y;
			}
			// 크기, 무지개블록 수가 같으면 행을 기준으로 내림차순 정렬
			else if (this.size == o.size && this.rainbow == o.rainbow) {
				return o.x - this.x;
			}
			// 크기가 같으면 무지개블록 수를 기준으로 내림차순 정렬
			else if (this.size == o.size) {
				return o.rainbow - this.rainbow;
			}
			
			// 크기 순으로 내림차순 정렬
			return o.size - this.size;
		}
	}
	
	static int N, M, ans;
	static int[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 격자의 크기
		M = Integer.parseInt(st.nextToken()); // 색상의 개수
		map = new int[N][N]; // 격자 배열
		
		// 각 칸의 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		autoPlay(); // 오토 플레이 시작
		
		// 결과 출력
		System.out.println(ans);
	}

	private static void autoPlay() { // 오토 플레이 기능 함수
		PriorityQueue<Group> pQueue = new PriorityQueue<>();
		
		while(true) {
			visited = new boolean[N][N]; // 방문체크 배열 초기화
			
			// 블록 그룹 만들기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 현재 칸을 방문하지 않았고 일반 블록일 경우
					if (!visited[i][j] && map[i][j] != -1 && map[i][j] != 0 && map[i][j] != -2) {
						// 현재 칸을 기준 블록으로 하여 블록 그룹 생성하고 pQueue에 넣기
						pQueue.offer(createGroup(i, j, map[i][j]));
					}
				}
			}
	
			// 블록 그룹이 하나도 없으면 오토 플레이 종료
			if(pQueue.isEmpty()) break;
			
			// 1. 가장 큰 우선순위의 블록 그룹 반환
			Group group = pQueue.poll();
			
			// 블록 그룹의 크기가 1이면 오토 플레이 종료
			if(group.size == 1) break;
			
			ans += group.size * group.size; // 2. 점수 계산해서 더하기
			
			// 2. 블록 그룹의 모든 블록 제거
			removeBlock(group.x, group.y, map[group.x][group.y]);
			// 3. 격자에 중력 작용
			gravity();
			// 4. 90도 반시계 방향으로 격자 회전
			rotate();
			// 5. 격자에 중력 작용
			gravity();
			
			pQueue.clear(); // 우선순위큐 비우기
		}
		
	}

	// 90도 반시계 방향으로 격자 배열을 회전하는 함수
	private static void rotate() {
        int[][] temp = new int[N][N];
        
        // temp 배열에 회전한 값 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
            	temp[N-1-j][i] = map[i][j];
            }
        }
        
        // temp 배열을 map에 복사
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
            	map[i][j] = temp[i][j];
            }
        }
	}

	// 격자 배열에 중력을 작용시키는 함수
	private static void gravity() {
		for (int i = 0; i < N; i++) { // 열
			for (int j = N-1; j >= 0; j--) { // 행
				// 빈칸이거나 검은색 블록이면 pass
				if (map[j][i] == -2 || map[j][i] == -1) continue;
				
				int p = j+1; // 현재 위치의 아래 블록을 포인터로 잡기
				
				while (true) {
					if (p == N) break; // 포인터가 경계를 벗어나면 break
					
					if (map[p][i] == -2) p++; // 포인터가 빈칸이면 포인터 1 증가
					else break; // 그 외의 경우 break
				}
				
				if (p == j+1) continue; // 포인터가 처음과 변하지 않았으면 pass
				
				map[p-1][i] = map[j][i]; // 포인터 위의 블록에 일반 블록 끌어와서 넣기
				map[j][i] = -2; // 일반 블록 위치 빈칸으로 바꾸기
			}
		}
		
	}

	// startRow, startCol를 기준블록으로 하는 그룹의 모든 블록을 제거하는 함수
	private static void removeBlock(int startRow, int startCol, int color) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N]; // 방문체크 배열
		queue.offer(new int[] {startRow, startCol}); // queue에 기준 블록 위치 넣기
		visited[startRow][startCol] = true; // 기준 블록 방문체크
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curRow = current[0];
			int curCol = current[1];
			
			map[curRow][curCol] = -2; // 현재 위치 빈칸으로 바꾸기
			
			for (int i = 0; i < 4; i++) {
				int nr = curRow + deltas[i][0];
				int nc = curCol + deltas[i][1];
				
				// 경계를 넘거나 검은색 블록이거나 빈칸이면 pass
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == -1 || map[nr][nc] == -2) continue;
				
				// 기준 블록과 같은 색이거나 무지개 블록일 경우
				if (map[nr][nc] == color || map[nr][nc] == 0) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}

			}
		}
		
	}

	// startRow, startCol를 기준 블록으로 하는 블록 그룹을 반환하는 함수
	private static Group createGroup(int startRow, int startCol, int color) {
		Queue<int[]> queue = new LinkedList<int[]>();
		Group group = new Group(1, 0, startRow, startCol); // 블록 그룹 객체 생성
		queue.offer(new int[] {startRow, startCol}); // queue에 기준 블록 위치 넣기
		visited[startRow][startCol] = true; // 기준 블록 방문체크
		boolean[][] rainbow = new boolean[N][N]; // 무지개 블록 방문체크 배열
		// 무지개 블록은 다른 그룹과는 중복이 가능하므로 전역변수인 visited로 체크하지 않고,
		// 현재 그룹에서만 한정하여 방문체크를 해줘야 한다.
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curRow = current[0];
			int curCol = current[1];
			
			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int nr = curRow + deltas[i][0];
				int nc = curCol + deltas[i][1];
				
				// 경계를 넘거나 검은색 블록이거나 빈칸이면 pass
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == -1 || map[nr][nc] == -2) continue;
				
				// 기준 블록과 같은 색이고 방문하지 않은 경우
				if (map[nr][nc] == color && !visited[nr][nc]) {
					// 그룹의 크기 1증가, queue에 넣기, visited 방문체크
					group.size += 1;
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
				// 무지개 블록이고 방문하지 않은 경우
				else if (map[nr][nc] == 0 && !rainbow[nr][nc]) {
					// 그룹의 크기 1증가, 무지개 블록 수 1증가, queue에 넣기, rainbow 방문체크
					group.size += 1;
					group.rainbow += 1;
					queue.offer(new int[] {nr, nc});
					rainbow[nr][nc] = true;
				}
			}
		}
		
		return group; // 블록 그룹 객체 반환
	}

}
