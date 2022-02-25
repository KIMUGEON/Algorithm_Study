package 공부.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 
둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 
주어지는 정수의 절댓값은 100,000을 넘지 않는다.

  [출력]
첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 */
public class Main_1182 { //부분수열의 합
	
	static int N,S,arr[],count,ans;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new boolean[N];

		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		subset(0);
		System.out.println(ans);
	}

	private static void subset(int cnt) {
		if(cnt == N) {
			
			int sum = 0;
			count = 0;
			for(int i = 0; i<N; i++) {
				if(visit[i]) {
					sum += arr[i];
					count++;
				}
			}
			
			if(sum == S && count > 0) {
				ans++;
			}
			return;
		}
		
		visit[cnt] = true;
		subset(cnt+1);
		visit[cnt] = false;
		subset(cnt+1);
		
		
	}

}
