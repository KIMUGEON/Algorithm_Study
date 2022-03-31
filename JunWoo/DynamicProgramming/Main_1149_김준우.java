package _0322_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_김준우 {
	static int N;
	static int[][] costs, mins;
	
	public static int solution(int cnt, int color) {
		if(mins[cnt][color] == 0) {
			switch (color) {
			case 0:
				mins[cnt][color] = costs[cnt][color] + Math.min(solution(cnt-1,1), solution(cnt-1,2));
				break;
			case 1:
				mins[cnt][color] = costs[cnt][color] + Math.min(solution(cnt-1,0), solution(cnt-1,2));
				break;
			case 2:
				mins[cnt][color] = costs[cnt][color] + Math.min(solution(cnt-1,0), solution(cnt-1,1));
				break;
			default:
				break;
			}
			
		}
		return mins[cnt][color];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//input 1st line
		N = Integer.parseInt(br.readLine());
		
		//input rest of lines
		costs = new int[N][3];
		mins = new int[N][3];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int j = 0; j < 3; j++) {
			mins[0][j] = costs[0][j];
		}
		
		int r = solution(N-1, 0);
		int g = solution(N-1, 1);
		int b = solution(N-1, 2);
		System.out.println(Math.min(Math.min(r, g),b));
	}

}
