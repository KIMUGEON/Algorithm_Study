package study_0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		// 거리랑 기름값 범위가 커서 long으로 해주기
		long[] distance = new long[N-1]; // 왼쪽도시부터 도시까지의 거리
		long[] cost = new long[N]; // 각 도시별 기름값
		long min = Long.MAX_VALUE; // 기름값 최소 구하기
		long sum = 0; // 출력해야하는 최소 비용
		// 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		// 가격 넣어놓기
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		// 처음은 무조건 기름 넣고 마지막 도시 기름가격은 어차피 필요없으니 제외
		// 최소일때 넣어야하고 왼쪽부터 차가 오니까 왼쪽부터 계속 기름값이 최소인지 확인하고 가격 더하기
		for(int i=0;i<N-1;i++) {
			if(min>cost[i]) min = cost[i]; // 전 도시보다 현재 도시가 더 최소값인 경우
			sum = sum + distance[i]*min;
		}
		// 출력
		System.out.print(sum);
	}

}
