package case_11.Silver5;

import java.util.Scanner;

public class Main_7568 { //덩치

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			int count = 1; //순위
			for (int j = 0; j < N; j++) {

				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) { //비교
					count++;
				}
			}
			System.out.print(count + " ");
		}

	}

}
