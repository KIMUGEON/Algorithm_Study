import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, n, d;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(bf.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			map = new int[n][n];
			
			for (int r = 0; r < n; r++) {
				st = new StringTokenizer(bf.readLine());
				for (int c = 0; c < n; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			if (d>0) dirR(d); // 시계 방향
			else dirL(d); // 반시계 방향
			
			for (int r = 0; r < n; r++) { // 출력
				for (int c = 0; c < n; c++) {
					System.out.print(map[r][c]+" ");
				} System.out.println();
			}
			

		}

	}

	public static void dirR(int dir) { // 시계 방향
		int[][] copy = copy(map); // 배열 복사
		
		for (int cnt = 0; cnt < dir / 45; cnt++) { // 회전 수
			for (int i = 0; i < n; i++) { // 복사한 배열에 45° 돌린 값 넣기
				copy[i][i] = map[n / 2][i];
				copy[i][n / 2] = map[i][i];
				copy[i][n - i -1] = map[i][n / 2];
				copy[n / 2][i] = map[n - i -1][i];
			}
			map=copy(copy); // 기존 배열에 돌린 결과 값 복사
			
		}
	}

	public static void dirL(int dir) { // 반시계 방향
		int[][] copy = copy(map);
		for (int cnt = 0; cnt < Math.abs(dir) / 45; cnt++) {
			for (int i = 0; i < n; i++) {
				copy[i][i] = map[i][n / 2];
				copy[i][n / 2] = map[i][n - i -1];
				copy[i][n - i -1] = map[n / 2][n - i -1];
				copy[n / 2][i] = map[i][i];
			}
			map=copy(copy);
		}
	}
	
	public static int[][] copy(int[][] arr) { // 배열 복사
		int[][] copy = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				copy[r][c] = arr[r][c];
			}
		}
		return copy;
	}
}
