import java.util.Scanner;

public class Main_2798_블랙잭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N+1];

		// 카드에 쓰여 있는 수를 arr[] 배열에 저장
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		int temp = 0;

		// M을 넘지 않는 3장의 카드 합 구하기                                                       ex) 5  6  7  8  9
		for (int i = 1; i <= N - 2; i++) {                 // S     E
			for (int j = i + 1; j <= N - 1; j++) {         //    S     E
				for (int k = j + 1; k <= N; k++) {         //       S     E
					temp = arr[i] + arr[j] + arr[k];
					if (temp <= M && temp > sum) { 
						sum = temp;
					}
				}
			}
		}

		// 결과 출력
		System.out.println(sum);
	}

}