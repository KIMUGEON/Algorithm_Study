package case_14.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 { //N과 M(1)
	public static int N,M;
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];	//재귀시 수행여부 체크

		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if(depth == M) {	//재귀 끝 조건
			for(int value : arr){
				sb.append(value).append(' ');
			}sb.append('\n');
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visit[i] = false;	//false 안해줄 경우 if(!visit[]에서 걸림)
			}
		}
	}

}
