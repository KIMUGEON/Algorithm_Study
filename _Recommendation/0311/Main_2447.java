package etc.분할정복.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
  [입력]
첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.

  [출력]
첫째 줄부터 N번째 줄까지 별을 출력한다.
 */
public class Main_2447 { //별 찍기 - 10

	static char arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
//		==================================  입력   ==================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N번줄 까지 별 출력하기

		arr = new char[N][N];

//		==================================  풀이   ==================================
		star(0, 0, N, false);

//		==================================  출력   ==================================
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

//	========================== star ==============================
	private static void star(int x, int y, int n, boolean check) {

		if (check) { //공백
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		if (n == 1) { //분할 불가능일때
			arr[x][y] = '*';
			return;
		}

		int size = n / 3; //분할해주기
		int cnt = 0; //공백칸 체크해주기 위한 카운트
		for (int i = x; i < x + n; i += size) { 
			for (int j = y; j < y + n; j += size) {
				cnt++;
				if (cnt == 5) { //별 4번 찍고 5번재는 공백
					star(i, j, size, true); //공백칸 true
				} else {
					star(i, j, size, false); //별칸 false
				}

			}
		}

	}
}
