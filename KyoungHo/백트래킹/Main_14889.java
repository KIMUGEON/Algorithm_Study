package case_14.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889 { //스타트와 링크

	public static int N;
	public static int MIN = Integer.MAX_VALUE;
	public static int state[][];
	public static boolean visit[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		state = new int[N][N];	//능력치 표
		visit = new boolean[N];	//방문여부 체크
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				state[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		team(0,0);
		System.out.println(MIN);
	}

	public static void team(int idx, int depth) {
		if(depth == N/2) {	//팀원 수 = N/2,
			int start = 0;
			int link = 0;
			for(int i=0; i<N-1; i++) { //i,j쌍이 중복되지 않게 범위 설정
				for(int j=i+1; j<N; j++) {
					if(visit[i] && visit[j]) { //방문한 팀, 방문 안한 팀 나눠서 각 팀 점수 더하기
						start += state[i][j];
						start += state[j][i];
					}else if(!visit[i] && !visit[j]) {
						link += state[i][j];
						link += state[j][i];
					}
				}
			}
			int diff = Math.abs(start-link);
			
			MIN= Math.min(MIN, diff);
			
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				team(i+1,depth+1);
				visit[i] = false;
			}
		}
	}
}
