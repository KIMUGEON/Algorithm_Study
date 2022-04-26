package study_0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058_김유완 {
	static int N,Q,R,iceSum,result,count;
	static int[][] arr,temp;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 전체 크기
		Q = Integer.parseInt(st.nextToken()); // 파이어 스톰 하는 개수
		R = (int)Math.pow(2,N); // 가로 세로 크기
		arr = new int[R][R];
		temp = new int[R][R];
		result = 0;
		iceSum = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < R; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			rotate(L);
		}
		sum(); // 얼음 합 구하기
		// 상하좌우에 얼음이 없는 칸이 2개 이상인 경우
		// 2번째 답 배열의 값이 1이상인걸 다 연결한 개수 - 집합 개수 - 덩어리 없으면 0
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < R; j++) {
				if(arr[i][j] > 0) {
					count = 1;
					bfs(i,j);
					if(count > result) result = count;
				}
			}
		}
		System.out.println(iceSum);
		System.out.println(result);
	}
	public static void rotate(int L) {
		
		int number = (int)Math.pow(2,L); // 돌리게 되는 칸 수
		int num = R/number; // 나누는 칸 수
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				int f = 1;
				for (int r = i*number; r < (i+1)*number; r++) {
					//System.out.println("처음 뭔가요"+r);
					int t = i*number;
					for (int c = j*number; c < (j+1)*number; c++) {
						temp[t][(j+1)*number-f] = arr[r][c];
						t++;
					}
					f++;
				}
			}
		}
		// 원래 배열에 저장하기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < R; j++) {
				arr[i][j] = temp[i][j];
			}
		}
		// 회전후 상하좌우 얼음이 인접해있는 칸 녹이기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < R; j++) {
				int count = 0; // 주변 얼음 있는 칸이 몇칸인지 확인
				for (int t = 0; t < 4; t++) {
					int nr = i + dx[t];
					int nc = j + dy[t];
					if(nr>=0 && nc>=0 && nr<R && nc<R && arr[nr][nc] > 0) count++; // 얼음있는 칸 확인
				}
				// 미리 값 바꾸면 안바뀌는 것도 바뀔수있음 - 예제 4,5,6틀리는 경우
				if(count < 3) temp[i][j] = temp[i][j] - 1; // 얼음 있는칸 3개또는 그 이상과 인접해있지 않으면
			}
		}
		// 원래 배열에 저장하기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < R; j++) {
				arr[i][j] = temp[i][j]; 
			}
		}
	}
	public static void sum() { // 남아있는 얼음 A[r][c]의 합
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < R; j++) {
				if(arr[i][j] > 0) iceSum+=arr[i][j];
			}
		}
	}
	public static void bfs(int r,int c) { // 남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[R][R];
		q.add(new int[] {r,c});
		visited[r][c] = true;
		while(!q.isEmpty()) {
			int[] node = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = node[0] + dx[i];
				int nc = node[1] + dy[i];
				if(nr>=0 && nc>=0 && nr<R && nc<R && arr[nr][nc]>0 && !visited[nr][nc]) {
					count++;
					q.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
