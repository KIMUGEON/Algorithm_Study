package _0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14499_김준우 {
	static int N, M, c, r, K;	//N: 세로크기, M: 가로크기, r,c : 시작좌표, K : 명령어개수
	static int[] dice;	//인덱스 0:북쪽면, 1:상단, 2:남쪽면, 3:바닥면, 4:서쪽면, 5:동쪽면
	static int[][] map;
	
	//사방탐색
	static int[] dy = {0,0,0,-1,1};
	static int[] dx = {0,1,-1,0,0};

	public static void rotation(int d) {	//d = 1~4: 동, 서, 북, 남
		//주사위 면 정보 복사
		int[] copy = Arrays.copyOf(dice, dice.length);
		
		switch (d) {
		case 1:	//동쪽으로 굴리기
			dice[1] = copy[4];	//서쪽면이 윗쪽면이 된다
			dice[5] = copy[1];	//상단면이 동쪽면이 된다
			dice[4] = copy[3];	//바닥면이 서쪽면이 된다
			dice[3] = copy[5];	//동쪽면이 바닥면이 된다.
			//북쪽면과 남쪽면은 그대로
			break;
		case 2:	//서쪽으로 굴리기
			dice[4] = copy[1];	//윗쪽면이 서쪽면이 된다
			dice[1] = copy[5];	//동쪽면이 상단면이 된다
			dice[3] = copy[4];	//서쪽면이 바닥면이 된다
			dice[5] = copy[3];	//바닥면이 동쪽면이 된다.
			//북쪽면과 남쪽면은 그대로
			break;
		case 3:	//북쪽으로 굴리기
			for (int i = 0; i < 4; i++) { 
				dice[i] = copy[(i+1)%4];	//북, 상단, 남, 바닥면이 북쪽으로 한칸씩 밀린다
			}
			//서쪽면과 동쪽면은 그대로
			break;
		case 4:	//남쪽으로 굴리기
			for (int i = 0; i < 4; i++) { 
				dice[i] = copy[(i+3)%4];	//북, 상단, 남, 바닥면이 북쪽으로 한칸씩 밀린다
			}
			//서쪽면과 동쪽면은 그대로
			break;
		default:
			break;
		}
	}
	
	public static void roll(int d) {	
		//이동할 좌표
		int nc = c + dx[d];
		int nr = r + dy[d];
		
		//경계체크
		if(nc <0 || nr <0 || nc >= M || nr >= N) return;	//만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.
		
		//이동하기
		c = nc; r = nr;
		rotation(d);	//주사위 방향 전환
		
		if(map[r][c] == 0) {	//주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면
			map[r][c] = dice[3];	//주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다
		}
		else {	//0이 아닌 경우에는
			dice[3] = map[r][c];	//칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며,
			map[r][c] = 0;		//칸에 쓰여 있는 수는 0이 된다.
		}
		
		System.out.println(dice[1]);	//이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다.
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dice = new int[6];
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			roll(Integer.parseInt(st.nextToken()));
		}
		
		
	}

}
