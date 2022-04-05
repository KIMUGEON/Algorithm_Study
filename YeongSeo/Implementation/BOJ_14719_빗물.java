package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/14719
 * 걸린 시간 : 60분
 */
public class BOJ_14719_빗물 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken()); // 세로 길이
		int W = Integer.parseInt(st.nextToken()); // 가로 길이
		int[][] map = new int[H][W]; // 2차원 세계 배열
		int[] height = new int[W]; // 블록의 높이를 저장할 배열
		
		// 블록의 높이 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < W; i++) {
			int temp = Integer.parseInt(st.nextToken());
			height[i] = temp;
			// 2차원 세계에 블록이 존재하는 칸 1로 저장
			for (int j = H-1; j >= H-temp; j--) {
				map[j][i] = 1;
			}
		}		
		
		int ans = 0; // 문제의 답 (빗물의 총량)
		
		// 각 열의 블록을 시작으로 고이는 빗물 계산하기
		for (int i = 0; i < W; i++) {
			// i열의 높이가 0이면 빗물이 고일 수 없으므로 pass
			if (height[i] == 0) continue;
			
			// i열의 블록을 높은 순서부터 하나씩 내려가면서 같은 높이의 블록을 만날때까지 실행
			outer:for (int j = 0; j < H; j++) {
				if (map[j][i] == 0) continue;
				
				int row = j; // 탐색 시작할 높이(행)
				int col = i; // 탐색 시작할 열
				int sum = 0; // 현재 탐색 블록에 고이는 빗물의 양
				
				// 옆으로 1칸씩 이동하면서 같은 높이의 블록 찾기
				while (++col < W) {
					// 탐색위치가 빈칸일 경우
					if (map[row][col] == 0) {
						// 현재 위치가 마지막 열이면 현재 높이에서는 빗물이 고이지 않는다는 뜻
						if (col == W-1) break;
						
						// 현재 열에 고이는 빗물량 계산해서 더하기
						sum += (H-height[col])-row;
					}
					// 탐색위치에 블록이 있을 경우
					else if (map[row][col] == 1) {
						ans += sum; // 현재까지 더한 빗물을 총량에 누적하기
						i = col-1; // 다음으로 탐색을 시작할 블록의 열 지정
						break outer;
					}
				}
			}
		}
		
		// 결과 출력
		System.out.println(ans);
	}
	
}
