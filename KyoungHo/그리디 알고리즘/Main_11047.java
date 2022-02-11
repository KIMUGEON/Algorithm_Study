package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 */

public class Main_11047 { // 동전0

	public static void main(String[] args) throws IOException {
//		============================  입력   ========================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 동전의 종류
		int K = Integer.parseInt(st.nextToken()); // 만들어야 하는 합
		int money[] = new int[N]; // 동전배열
		int count = 0; // 동전 카운트

		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
//		============================  풀이   =======================================

		for (int i = N - 1; i >= 0; i--) { // 큰 동전부터 선택해야 최소값 나옴
			if (money[i] <= K) { // K보다 작은 동전 선택
				count += (K / money[i]); // 동전 몇개 사용하는지
				K = K % money[i]; // 남은 돈
			}
		}
//		===========================  출력    =========================================
		System.out.println(count);
	}

}
