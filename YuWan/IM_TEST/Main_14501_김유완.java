package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_김유완 {
	static int N,max;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		max = Integer.MIN_VALUE;
		StringTokenizer st;
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // 상담 걸리는 기간
			int p = Integer.parseInt(st.nextToken()); // 상담했을때 받을 수 있는 금액
			arr[i][0] = t;
			arr[i][1] = p;
		}
		dfs(0,0);
		System.out.println(max);
	}
	public static void dfs(int index,int cost) {
		if(index >= N) { // 선택하는 index값이 범위를 넘어서면 최대값 확인해보고 끝
			if(max<cost) max = cost;
			return;
		}
		// 6일째에 상담 1일이면 가능한데 합은 7
		if(index+arr[index][0]<=N) dfs(index+arr[index][0],cost+arr[index][1]);
		else dfs(index+arr[index][0], cost); // 선택안하기
		
		dfs(index+1,cost);
	}
}