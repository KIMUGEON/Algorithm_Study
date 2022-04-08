import java.util.Scanner;

public class Main_1389 { // 케빈베이컨의 6단계 법칙

	static final int INF = 9999999;
	static int N, M, arr[][], min, idx;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		min = Integer.MAX_VALUE;
		idx = -1;

		set(); //초기값
		floyd(); //플로이드 와샬
		// test();
		search(); //케빈베이컨 수가 가장 작은 사람 찾기

		System.out.println(idx);

	}

	private static void search() {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += arr[i][j];
			}
			if (min > sum) {
				min = sum;
				idx = i;
			}
		}
	}

	private static void test() {
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void floyd() {
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			arr[A][B] = arr[B][A] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
	}

	private static void set() {
		arr = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i != j && arr[i][j] == 0) {
					arr[i][j] = INF;
				}
			}
		}
	}
}
