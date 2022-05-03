package 삼성_SW_역량테스트_기출.Gold4;

import java.util.Scanner;

public class Main_14499 {

	static int N, M, dice[], map[][], temp[];
	static int deltas[][] = { // 동 서 북 남, 0 사용x
			{0,0}, 
			{0,1}, 
			{0,-1}, 
			{-1,0}, 
			{1,0}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 지도 세로
		M = sc.nextInt(); // 지도 가로
		int x = sc.nextInt(); // 주사위 x좌표
		int y = sc.nextInt(); // 주사위 y좌표
		int K = sc.nextInt(); // 이동 명령어

		dice = new int[7]; // 0 사용 x
		map = new int[N][M]; // 지도

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < K; i++) { // 이동 명령어만큼 돌기
			int d = sc.nextInt(); // 1:동, 2:서, 3:북, 4:남
			int dx = x + deltas[d][0];
			int dy = y + deltas[d][1];

			if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
				Dice(d);// 주사위 굴리기
				
				Check(dx, dy);
				// 주사위 굴렸을때 이동한 칸에 쓰여있는 수가 0이면, 주사위 바닥면에 쓰여 있는 수가 칸에 복사된다.
				// 0이 아닌 경우에는 칸에 쓰여있는 수가 주사위 바닥면으로 복사되며 칸에 쓰여 있는 수는 0이 된다.

				x = dx;
				y = dy;
				System.out.println(dice[1]);//윗면 출력
			}
		}

	}

	private static void Check(int dx, int dy) {
		if (map[dx][dy] == 0) {
			map[dx][dy] = dice[6];
		} else {
			dice[6] = map[dx][dy];
			map[dx][dy] = 0;
		}
	}

	private static void Dice(int d) {
		temp = new int[7]; //임시 주사위
		copy(); //복사
		if (d == 1) {//동
			dice[1] = temp[4];
			dice[4] = temp[6];
			dice[6] = temp[3];
			dice[3] = temp[1];
		} else if (d == 2) {//서
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[6] = temp[4];
			dice[4] = temp[1];
		} else if (d == 3) {//북
			dice[1] = temp[5];
			dice[5] = temp[6];
			dice[6] = temp[2];
			dice[2] = temp[1];
		} else if (d == 4) {//남
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[6] = temp[5];
			dice[5] = temp[1];
		}

	}

	private static void copy() {
		for (int i = 0; i < 7; i++) {
			temp[i] = dice[i];
		}
	}

}
