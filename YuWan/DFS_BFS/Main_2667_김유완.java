package study_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2667_김유완 {
	// 출력 할때 단지내 집의 수를 오름 차순으로 정렬해야함!!
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr; // 아파트 저장하는 배열
	static boolean[][] is; // 방문여부
	static int count; // 단지 내 아파트 개수를 위한 변수
	static int N; // 정사각형 길이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>(); // 오름 차순으로 정렬해야함
		String st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		is = new boolean[N][N];
		int countAll = 0;
		for(int i=0;i<N;i++) {
			st = br.readLine();
			for(int j=0;j<N;j++) { // 입력받는게 빈칸없음 확인!!!!
				arr[i][j] = st.charAt(j)-'0'; // 집 입력받기
			}
		}
		// 돌면서 인접한 곳 확인하기
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				count = 1;  // 자기 자신도 포함하니까
				if(arr[i][j]==1 && is[i][j]==false) {
					is[i][j]= true;
					countAll++;
					dfs(i,j);
					list.add(count);
				}
			}
		}
		Collections.sort(list); // 정렬!!
		sb.append(countAll).append('\n');
		for(int i : list) sb.append(i).append('\n');
		System.out.print(sb);
	}
	public static void dfs(int row, int column) {
		for(int i=0;i<4;i++) {
			int nr = row + dx[i];
			int nc = column + dy[i];
			if(nr>=0 && nc>=0 && nr<N && nc<N && is[nr][nc]==false && arr[nr][nc]== 1) {
				is[nr][nc] = true;
				count++; // 단지 내 집 개수
				dfs(nr,nc);
			}
		}
	}
}