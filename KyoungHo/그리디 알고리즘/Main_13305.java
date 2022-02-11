package Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
표준 입력으로 다음 정보가 주어진다. 첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)이 주어진다. 
다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수로 주어진다. 
다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다. 
제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 
리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다. 
 */

public class Main_13305 { // 주유소

	public static void main(String[] args) throws NumberFormatException, IOException {
//		============================  입력   ======================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long distance[] = new long[N - 1]; // 거리
		long price[] = new long[N]; // 가격

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N - 1; i++) { // 거리 입력
			distance[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) { // 가격 입력
			price[i] = Integer.parseInt(st.nextToken());
		}
//		=============================  풀이   =======================================
		long sum = 0;
		long min = price[0]; // 기름 최저값 = 초기값:처음 도시의 기름값

		for (int i = 0; i < N - 1; i++) { // 마지막 도시의 기름값은 필요없음
			if (min > price[i]) { // 최저값 갱신
				min = price[i];
			}
			sum += (min * distance[i]); // 비용 계산
		}
//		=============================  출력   =======================================
		System.out.println(sum);
	}

}
