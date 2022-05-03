package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/14499
 * 걸린 시간 : 60분
 * 리뷰 : 주사위 이동 방법과 주사위 값을 어떻게 가져올지를 고민해보았다.
 * 서로 반대면에 위치한 면을 더하면 항상 7이 되므로, 현재 주사위가 놓여진 상태에서
 * 윗면, 오른쪽면, 앞면이 어딘지를 알면 자연스레 바닥면, 왼쪽면, 뒷면도 어딘지를 알 수 있다.
 * 이를 이용하여 top, right, front와 같이 주사위의 세가지면의 위치값을 사용하여 문제를 풀었다.
 */
public class BOJ_14499_주사위_굴리기 {
	static int N, M, x, y, top, right, front;
	static int[][] map;
	static int[] dice;
	static int[][] deltas = {{0,0},{0,1},{0,-1},{-1,0},{1,0}}; // 1:동쪽 2:서쪽 3:북쪽 4:남쪽
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
		x = Integer.parseInt(st.nextToken()); // 주사위의 현재 행 좌표
		y = Integer.parseInt(st.nextToken()); // 주사위의 현재 열 좌표
		int K = Integer.parseInt(st.nextToken()); // 명령의 개수
		dice = new int[7]; // 주사위 배열 (각 인덱스는 주사위 전개도에 쓰여진 숫자)
		map = new int[N][M]; // 지도 배열
		sb = new StringBuilder();
		
		top = 1; // 현재 주사위의 윗면 인덱스
		right = 3; // 현재 주사위의 오른쪽면 인덱스
		front = 5; // 현재 주사위의 앞면 인덱스
		
		// 지도 배열값 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		st = new StringTokenizer(br.readLine(), " ");
		// 각 명령 실행
		for (int i = 0; i < K; i++) {
			int cmd = Integer.parseInt(st.nextToken()); // 명령 커맨드
			move(cmd); // 명령 수행
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}

	private static void move(int cmd) {
		int nx = x + deltas[cmd][0]; // 이동 위치 행 좌표
		int ny = y + deltas[cmd][1]; // 이동 위치 열 좌표
		
		// 이동 위치가 지도를 벗어나면 명령 무시 -> 함수 종료
		if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
		
		// 현재 위치의 좌표를 이동 위치로 바꾸기
		x = nx;
		y = ny;
		
		// top, right, front 변경
		change(cmd);
		
		int bottom = 7-top; // 주사위 바닥면 인덱스
		
		// 이동한 칸에 쓰여진 수가 0일 경우
		if (map[x][y] == 0) {
			map[x][y] = dice[bottom]; // 주사위의 바닥면에 쓰여 있는 수를 이동 칸으로 복사
		}
		// 0이 아닐 경우
		else {
			dice[bottom] = map[x][y]; // 칸에 쓰여있는 수를 주사위의 바닥면으로 복사
			map[x][y] = 0; // 칸에 쓰여 있는 수 0으로 바꾸기
		}
		
		// 출력할 주사위 윗면 값 sb에 추가
		sb.append(dice[top]+"\n");
	}

	// 주사위를 이동했을 시 바뀌는 주사위의 top, right, front 구하기
	private static void change(int cmd) {
		// 각 값들 복사
		int tTmp = top;
		int rTmp = right;
		int fTmp = front;
		
		switch (cmd) {
		case 1: // 동쪽
			top = 7-rTmp;
			right = tTmp;
			break;
		case 2: // 서쪽
			top = rTmp;
			right = 7-tTmp;
			break;
		case 3: // 북쪽
			top = fTmp;
			front = 7-tTmp;
			break;
		case 4: // 남쪽
			top = 7-fTmp;
			front = tTmp;
			break;
		}
	}

}
