package study_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157_김유완 {
	// 방법 1.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로가 C 세로가 R
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[R][C];
		// 결과 배정되는  좌표값
		int r = 0;
		int c = 0;
		int min = 0;
		int count = 0;
		// 모든 좌석이 배정되어 해당 대기번호의 관객에게 좌석을 배정할 수 없는 경우
		if(num>C*R) {
			System.out.println(0);
			System.exit(0);
		}
		// 안에 돌아가는 회전수는 (MIN+1)%2
		if(C>=R) min = R;
		else min = C;

		for (int i = 0; i < (min+1)/2; i++) {
			// 왼쪽
			for (int j = R-1-i; j >=i ; j--) {
				int k = i;
				if(arr[j][k]==0) {
				count++;
				arr[j][k] = count;
				if(count == num) { // 찾던 번호인지 확인
					r = k+1; // 내가 설정한건 배열 좌표 문제에서 나온 좌표로 바꿔줘야함
					c = R-j;
				}
				}
				
			}
			// 위쪽
			for (int k = i+1; k < C; k++) {
				int j = i;
				if(arr[j][k]==0) {
				count++;
				arr[j][k] = count;
				if(count == num) { // 찾던 번호인지 확인
					r = k+1;
					c = R-j;
				}
				}
				
			}
			// 오른쪽
			for (int j = i+1; j < R; j++) {
				int k = C-1-i;
				if(arr[j][k]==0) {
				count++;
				arr[j][k] = count;
				if(count == num) { // 찾던 번호인지 확인
					r = k+1;
					c = R-j;
				}
				}
			}
			// 아래쪽
			for (int k = C-2-i; k >=i+1 ; k--) {
				int j = R-1-i;
				if(arr[j][k]==0) {
				count++;
				arr[j][k] = count;
				if(count == num) { // 찾던 번호인지 확인
					r = k+1;
					c = R-j;
				}
				}
			}
		}
		// 좌표출력
		System.out.println(r+" "+c);
	}
}
//		// 방법 2. dx,dy로 풀어보기
//public class Main_10157_김유완 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		// 가로가 C 세로가 R
//		int C = Integer.parseInt(st.nextToken());
//		int R = Integer.parseInt(st.nextToken());
//		int num = Integer.parseInt(br.readLine());
//		int[] dx = {-1,0,1,0}; // 상 우 하 좌
//		int[] dy = {0,1,0,-1};
//		int[][] arr = new int[R][C];
//		// 시작점
//		int count = 1;
//		int r = R-1;
//		int c = 0;
//		int i = 0; // 방향 전환
//		if(num>C*R) {
//			System.out.println(0);
//			System.exit(0);
//		}
//		while(num!=count) {
//			arr[r][c] = count;
//			int nr = r + dx[i];
//			int nc = c + dy[i];
//			// 범위가 벗어나거나 이미 채워진 곳이라면 방향 바꿔주기
//			if(nr<0 || nc<0 || nr>=R || nc>=C || arr[nr][nc]!=0 ) {
//				i++; // 방향 전환
//				if(i==4) i = 0;
//				nr = r + dx[i];
//				nc = c + dy[i];
//			}
//			r = nr;
//			c = nc;
//			count++;
//		}
// 		// 좌표 재설정
//		int temp = r;
//		r = c + 1;
//		c = R - temp;
//		System.out.println(r+" "+c);
//	}
//}