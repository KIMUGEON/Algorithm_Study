package Backtracking;

import java.util.Scanner;

public class BOJ_14889_스타트와_링크 {
	static int N;
	static int[][] ablity;
	static boolean[] teamCheck;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ablity = new int[N][N];
		teamCheck = new boolean[N]; // true이면 스타트팀, false이면 링크팀
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ablity[i][j] = sc.nextInt();
			}
		}
		pickTeam(0, 0);
		System.out.println(ans);
	}
	
	// team 멤버 뽑기 -> N개의 false 중에서 N/1개의 true 뽑는 함수
	static void pickTeam(int cnt, int start) {
		if(cnt == N/2) {
			// true가 3개 뽑혔으면 점수 차이 계산하기
			calDiff();
			return;
		}
		
		for(int i=start; i<N; i++) {	
			// false이면 true로 바꾸기
			if(!teamCheck[i]) {
				teamCheck[i] = true;
				pickTeam(cnt+1, i+1);
				teamCheck[i] = false;
			}

		}
	}
	
	// 스타트팀과 링크팀의 점수 차를 계산하는 함수
	static void calDiff() {
		int startScore = 0; // 스타트팀 점수
		int linkScore = 0; // 링크팀 점수
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(teamCheck[i] == true && teamCheck[j] == true) {
					// 인덱스 i와 j가 true이면 스타트팀의 S(i,j)와 S(j,i) 구하기
					startScore += ablity[i][j];
					startScore += ablity[j][i];
				}
				else if(teamCheck[i] == false && teamCheck[j] == false) {
					// 인덱스 i와 j가 true이면 링크팀의 S(i,j)와 S(j,i) 구하기
					linkScore += ablity[i][j];
					linkScore += ablity[j][i];
				}
			}
		}
		int diff = Math.abs(startScore - linkScore); // 두 팀의 점수 차이 계산
		
		ans = Math.min(ans, diff); // 최솟값 업데이트
	}

}
