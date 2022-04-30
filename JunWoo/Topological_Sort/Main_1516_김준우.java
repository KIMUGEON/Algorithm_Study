package _0425_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1516_김준우 {
	static int N;
	static boolean[][] dependency;	//건물간의 의존성
	static int[] time;	//각 건물만을 짓는데 걸리는 시간
	static int[] totaltime;	//각 건물을 의존성 고려하여 짓는데 걸리는 시간
	
	public static int getTime(int n) {
		int ETA = time[n];	//예상 시간은 그 건물만을 짓는데 걸리는 시간으로 초기화
		int Max = 0;	//미리 지어야하는 건물중에 가장 오래 걸리는거
		
		//먼저 지어야할 건물 체크
		for (int i = 1; i <= N; i++) {
			if(!dependency[n][i]) continue;	//i번 건물이 먼저 지을 필요 없는 경우 컨티뉴
			
			if(totaltime[i] >= 0) {	//미리지어야하는 건물의 시간이 기록된 경우
				if(totaltime[i] > Max) Max = totaltime[i];
			}
			else {
				int pre = getTime(i);
				if(pre > Max) Max = pre;
			}
		}
		
		ETA += Max;
		totaltime[n] = ETA;
		
		return ETA;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dependency = new boolean[N+1][N+1];
		time = new int[N+1];	//각 건물만을 짓는데 걸리는 시간
		totaltime = new int[N+1];	Arrays.fill(totaltime, -1);	//각 건물을 의존성 고려하여 짓는데 걸리는 시간 -1로 초기화
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());	//입력받은 건물을 짓는데 걸리는 시간
			while(true) {
				int pre_build = Integer.parseInt(st.nextToken());	//먼저 지어야할 건물의 종류
				if(pre_build < 0) break;	//-1입력받으면 다음줄로 넘어가기
				dependency[i][pre_build] = true;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(totaltime[i]>=0) {System.out.println(totaltime[i]);continue;}	//이미 짓는 시간이 기록된 경우 패스
			System.out.println(getTime(i));
		}
		
	}

}
