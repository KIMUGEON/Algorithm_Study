package Brute_Force;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/14501
 * 걸린 시간 : 100분
 * 리뷰 : 처음엔 dfs를 적용할 생각을 못하고 반복문으로 하나하나 모든 경우의 수를 다 선택해보려다, 
 * 반복문으로 이를 구현하기에는 불가능하다는 생각이 들었다.
 * 그러다 dp 개념을 적용해보려 했지만, 아직 배우지 않은 개념을 적용하려니 이해도 안되고 너무 어려워서
 * 결국 익숙한 dfs 개념을 적용해서 풀게됐다. 다음번에 dp를 공부하고 나서 dp로 다시 풀어봐야겠다.
 */
public class BOJ_14501_퇴사 {
	static int N;
	static int[][] consult;
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 상담을 할 수 있는 총 기간
		consult = new int[N+1][2]; // 상담 일정 정보를 저장하는 배열
		
		// 상담 일정 정보 입력
		for (int i = 1; i <= N; i++) {
			consult[i][0] = sc.nextInt(); // 상담 기간 저장
			consult[i][1] = sc.nextInt(); // 상담 수익 저장
		}

		res = 0; // 최대 이익(결과값)

		// 1일부터 차례대로 선택 -> 모든 경우의 수 다 해보기
		for (int i = 1; i <= N; i++) {
			dfs(i, consult[i][1]); // i일 상담을 시작으로 탐색 시작
		}
		
		System.out.println(res); // 결과 출력
	}

	/**
	 * @param preDay : 직전에 했던 상담 날짜
	 * @param sum : 현재까지의 상담 수익
	 */
	private static void dfs(int preDay, int sum) {
		int time = consult[preDay][0]; // 직전에 했던 상담에 걸리는 시간
		
		// 직전에 했던 상담이 끝나는 날이 N일을 넘을 경우
		if(preDay+time-1 > N) {
			sum -= sum+consult[preDay][1]; // 직전에 했던 상담은 못한다는 뜻이므로 상담 비용 빼기
			res = Math.max(res, sum); // 상담 수익이 최대 수익인지 체크 및 갱신
			return;
		}
		
		// 직전에 했던 상담이 끝나는 날을 시작으로 그 이후의 상담 전부 해보기
		for(int i = preDay+time; i <= N; i++) {
			dfs(i, sum+consult[i][1]);
		}
		
		// 여기에 왔다는건 마지막날에 딱 상담이 끝난 경우
		res = Math.max(res, sum); // 상담 수익이 최대 수익인지 체크 및 갱신
	}

}
