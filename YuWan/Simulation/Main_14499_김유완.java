package study_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_김유완 {
	static StringBuilder sb = new StringBuilder();
	static int N,M,r,c,K;
	static int[][] arr;
	static int[] dice = new int[6];
	static int[] dx = {0,0,-1,1}; // 동,서,북,남순으로
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		r = Integer.parseInt(st.nextToken()); // 주사위 놓은 좌표
		c = Integer.parseInt(st.nextToken()); // 주사위 놓은 좌표
		K = Integer.parseInt(st.nextToken()); // 명령의 개수
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(st.nextToken());
			// 범위 들어가는지 확인하기 - 범위 벗어나면 해당 명령 무시
			int nr = r + dx[n-1];
			int nc = c + dy[n-1];
			if(nr>=0 && nc>=0 && nr<N && nc<M) {
				rotate(n-1,nr,nc); // 1씩 빼기
			}
		}
		System.out.print(sb);
	}
	public static void rotate(int num,int nr,int nc) {
		// 새로운 좌표 다시 설정 
		// 동쪽은 0, 서쪽은 1, 북쪽은 2, 남쪽은 3
		// 문제 주사위 번호 그대로 -1 5가 바닥면  복사되는것 / 0이 윗면 출력될것
		int bottom = arr[nr][nc]; // 이동할 칸의 수
		int temp = 0;
		// 다시 r,c재정의해놓기
		r = nr;
		c = nc;
		// 일단 회전하고 temp에 바닥에 내려갈 값을 저장해놓기
		switch(num) {
		case 0:{ // 동
			temp = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			break;
		}
		case 1:{ // 서
			temp = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			break;
		}
		case 2:{ // 북
			temp = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			break;
		}
		case 3:{ // 남
			temp = dice[4];
			dice[4] = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			break;
		}
		}
		// 바닥면이랑 주사위 바닥이랑 확인하기
		if(bottom == 0) { // 1. 이동한 칸 수가 0 이면 주사위 바닥에 있는 수를 칸에 복사
			arr[r][c] = temp;
			dice[5] = temp; // 2. 주사위 바닥값은 그대로 유지됨
		}
		else {
			arr[r][c] = 0; // 칸에 씌여진 수 0
			dice[5] = bottom; // 칸에 써진 수 그대로 복사됨
		}
		sb.append(dice[0]).append("\n"); // 윗면 출력
	}
}