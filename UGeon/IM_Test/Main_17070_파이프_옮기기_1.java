import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 출처 : 백준 알고리즘
 * 번호 : 17070번  
 * 제목 : 파이프 옮기기
 * 
 * 현재 파이프가 놓여진 방향에 따라 이동할 수 있는 해당 구역을 탐색한다
 * 탐색할 때 배열의 범위를 벗어나지 않고 벽이 아닌지 확인한다
 * 이동 가능한 모든 경로로 순차 이동한다
 * 최종 위치에 도착하면 count++
 */

public class Main_17070_파이프_옮기기_1 {

	static int N, Cnt = 0; // 집의 크기 N
	static int[] deltaX1 = new int[] {0,1,1}; // 가로 방향인 경우
	static int[] deltaY1 = new int[] {1,0,1};
	static int[] deltaX2 = new int[] {1,0,1}; // 세로 방향인 경우
	static int[] deltaY2 = new int[] {0,1,1};
	static int[][] Map; // 집의 상태를 저장할 Map
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		Map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		search(0, 0, 0, 1);
		
		System.out.println(Cnt);
	}
	
	public static void search(int r1, int c1, int r2, int c2) {
		if (r2 == N-1 && c2 == N-1) {
			Cnt++;
			return;
		}
		
		if (r1 == r2 && c1+1 == c2) { // 가로
			int add = 0;
			
			for (int i = 0; i < 3; i++) { // 탐색
				int nextR = r2 + deltaX1[i];
				int nextC = c2 + deltaY1[i];
				
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N || Map[nextR][nextC] == 1) continue; // 범위 및 벽 확인
				else add++;
				
				if (i == 0 || add == 3) { // 이동할 수 있는 경우
					search(r2, c2, nextR, nextC);
				}
			}
		}
		else if (r1+1 == r2 && c1 == c2) { // 세로
			int add = 0;
			
			for (int i = 0; i < 3; i++) {
				int nextR = r2 + deltaX2[i];
				int nextC = c2 + deltaY2[i];
				
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N || Map[nextR][nextC] == 1) continue;
				else add++;
				
				if (i == 0 || add == 3) {
					search(r2, c2, nextR, nextC);
				}
			}
		}
		else if (r1+1 == r2 && c1+1 == c2) { // 대각선
			int add = 0;
			
			for (int i = 0; i < 3; i++) {
				int nextR = r2 + deltaX1[i];
				int nextC = c2 + deltaY1[i];
				
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N || Map[nextR][nextC] == 1) continue;
				else add++;
				
				if (i == 0 || i == 1 || add == 3) {
					search(r2, c2, nextR, nextC);
				}
			}
		}
	}
}
