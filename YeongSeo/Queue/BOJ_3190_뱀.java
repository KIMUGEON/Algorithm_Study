package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/3190
 * 걸린 시간 : 60분
 * 리뷰 : 뱀의 머리와 꼬리부분의 위치가 항상 변하므로 이를 자료구조로 어떻게 구조화시킬지 고민해보았다.
 * 뱀의 머리부분과 꼬리부분만 추가, 삭제되고 가운데 몸통부분은 유지되므로, 이를 덱(deque)으로 구현하면
 * 손쉽게 리스트의 앞부분과 뒷부분을 추가, 삭제할 수 있다는걸 깨달았다.
 * 앞으로 LinkedList로 deque와 유사하게 데이터를 관리하는 방법도 염두해보면서 생각할것!!
*/
public class BOJ_3190_뱀 {
	static int N, K, time, dir;
	static int[][] map;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}}; // 우하좌상
	static List<int[]> snakes;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 보드의 크기
		K = Integer.parseInt(br.readLine()); // 사과의 개수
		map = new int[N+1][N+1]; // 보드 배열, -1: 뱀의 몸통 0: 비어있음 1: 사과
		StringTokenizer st;
		
		// 사과 위치 보드에 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}
		
		time = 0; // 지난 시간(초)
		dir = 0; // 현재 이동 방향 -> 0~3까지 우하좌상 순서
		map[1][1] = -1; // 뱀의 시작 위치 초기화
		
		int L = Integer.parseInt(br.readLine()); // 방향 변환 횟수
		snakes = new LinkedList<>(); // 뱀 몸통의 위치를 저장할 리스트 (Deque)
		// 0번째 위치와 마지막 위치의 삽입,삭제가 자주 일어나므로 LinkedList로 선언!!
//		snakes = new ArrayList<>();
		snakes.add(new int[] {1, 1}); // 뱀의 처음 위치 리스트에 넣기
		
		// 방향 변환 횟수만큼 실행
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken()); // 방향 전환을 할 시간(초)
			char C = st.nextToken().charAt(0); // 회전 방향
			
			// 방향 변환 시간이 되기 전까지 1초씩 이동
			while(time != X) {
				move();
			}
			
			// 방향 변환 -> deltas를 90도 방향 변환했을 때 순서로 정의하였으므로 -1 또는 1만 해주면 됨
			if (C == 'D') { // D일 경우 오른쪽으로 90도
				dir++;
				if (dir == 4) dir = 0;
			}
			else if (C == 'L') { // L일 경우 왼쪽으로 90도
				dir--;
				if (dir == -1) dir = 3;
			}
		}
		
		// 게임이 종료될 때까지 실행
		while(true) {
			move();			
		}
	}
	
	// 현재 이동방향으로 뱀을 이동시키는 함수
	private static void move() {
		time++; // 1초 증가
		int[] head = snakes.get(0); // 뱀의 머리의 위치
		int nx = head[0] + deltas[dir][0]; // 이동 방향의 행
		int ny = head[1] + deltas[dir][1]; // 이동 방향의 열
		
		// 뱀의 이동방향이 경계를 벗어날 경우 게임 종료
		if (nx < 1 || nx >= N+1 || ny < 1 || ny >= N+1) {
			System.out.println(time);
			System.exit(0);
		}
		
		// 뱀의 이동방향이 뱀의 몸통일 경우 게임 종료
		if (map[nx][ny] == -1) {
			System.out.println(time);
			System.exit(0);
		}
		// 뱀의 이동방향이 사과일 경우
		else if (map[nx][ny] == 1) {
			map[nx][ny] = -1;
			snakes.add(0, new int[] {nx, ny}); // 뱀의 머리를 배열에 추가
		}
		// 뱀의 이동방향이 비어있을 경우
		else {
			map[nx][ny] = -1;
			snakes.add(0, new int[] {nx, ny}); // 뱀의 머리를 배열에 추가
			int[] tail = snakes.get(snakes.size()-1); // 뱀의 꼬리의 위치
			snakes.remove(snakes.size()-1); // 뱀의 꼬리위치 지우기
			map[tail[0]][tail[1]] = 0; // 뱀의 꼬리 부분 빈곳으로 바꾸기
		}
	}

}
