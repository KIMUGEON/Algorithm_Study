package 공부.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
  [입력]
입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스는 한 줄로 이루어져 있다. 
첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다. 
S의 원소는 오름차순으로 주어진다.
입력의 마지막 줄에는 0이 하나 주어진다. 

  [출력]
각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다.
각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.
 */
public class Main_6603 { // 로또

	static boolean visit[];
	static int k, arr[];

	public static void main(String[] args) throws IOException {
//		===============================  입력    =====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k==0)break; //마지막 줄 0
			
			arr = new int[k];
			visit = new boolean[k];

			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
//		===============================  풀이   =====================================
			comb(0, 0);
			
//		===============================  출력   =====================================
			System.out.println();
		}
	}

//	=====================  comb  ======================
	public static void comb(int cnt, int idx) {
		if (idx == 6) {
			for(int i=0; i<k; i++) {
				if(visit[i])
					System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}

		for (int i = cnt; i < k; i++) {
			if (!visit[i]) {
				visit[i] = true;
				comb(i + 1, idx + 1);
				visit[i] = false;
			}
		}

	}

}
