package study_0208;

import java.util.Scanner;

public class Main_14889_김유완 {
	static int N; // 사람수
	static int min = 2147483647; // 최소값
	static int[][] arr; // 능력치 저장하는 배열
	static boolean[] is; // 선택된것과 아닌것 구별하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 사람수
		arr = new int[N][N];
		is = new boolean[N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) { // 능력치 저장하기
				arr[i][j] = sc.nextInt();
			}
		}
		comb(0,0);
		System.out.println(min);
		sc.close();
	}
	// 각각 조합하기
	public static void comb(int cnt,int index) {
		if(cnt == N/2) { // 인원반틈 수의 조합을 뽑는 거니까
			// 스타트 팀과 링크 팀의 능력치의 차이의 최솟값
			int start=0; // 점수
			int link=0; // 점수
			for(int i=0;i<N;i++) { // 선택된 사람이랑 아닌 팀을 나눠서 더하기
				for(int j=i;j<N;j++) {
					if(is[i]==true && is[j]==true) {
						start=start+arr[i][j]+arr[j][i];
					}
					if(is[i]==false && is[j]==false) {
						link=link+arr[i][j]+arr[j][i];
					}
				}
			}
			// 점수차 절대값
			int num = Math.abs(start-link);
			// 최소값 출력
			min = Math.min(min,num);
			return;
		}
		
		// 조합되는 경우의 수 
		for(int i=index;i<N;i++) {
			if(!is[i]) {
				is[i] = true; // 사용한다고 표현
				comb(cnt+1,i+1);
				is[i] = false; // 다시 해제
			}
		}
	}
}
