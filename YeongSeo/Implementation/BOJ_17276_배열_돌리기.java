package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/17276
 * 걸린 시간 : 60분
*/
public class BOJ_17276_배열_돌리기 {
	static int n;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); // 배열의 크기
			int d = Integer.parseInt(st.nextToken()); // 각도
			map = new int[n][n]; // 배열 초기화
			
			// 배열 값 입력
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int turnNum = Math.abs(d) / 45; // 회전 횟수
			
			// 각도가 양수이면 시계방향으로 회전
			if (d > 0) rotateRight(turnNum);
			// 각도가 음수이면 반시계방향으로 회전
			else if (d < 0) rotateLeft(turnNum);
			
			print(); // 회전이 끝난 배열의 상태 출력
		}

	}

	// turnNum번 만큼 시계방향으로 회전하는 함수
	private static void rotateRight(int turnNum) {
		int[][] temp = new int[n][n]; // 임시 배열
		int center = n / 2; // 배열의 가운데 인덱스
		
		copy(map, temp); // map을 temp에 복사
		
		while(--turnNum >= 0) {
			// 주 대각선 가운데 열로 옮기기
			for (int i = 0; i < n; i++) {
				temp[i][center] = map[i][i];
			}
			
			// 가운데 열 부 대각선으로 옮기기
			for (int i = 0; i < n; i++) {
				temp[i][n-1-i] = map[i][center];
			}
			
			// 부 대각선 가운데 행으로 옮기기
			for (int i = 0; i < n; i++) {
				temp[center][n-1-i] = map[i][n-1-i];
			}
			
			// 가운데 행 주 대각선으로 옮기기
			for (int i = 0; i < n; i++) {
				temp[i][i] = map[center][i];
			}
			
			// temp를 map에 덮어씌우기
			copy(temp, map);
		}
	}

	// turnNum번 만큼 반시계방향으로 회전하는 함수
	private static void rotateLeft(int turnNum) {
		int[][] temp = new int[n][n]; // 임시 배열
		int center = n / 2; // 배열의 가운데 인덱스

		copy(map, temp); // map을 temp에 복사
		
		while(--turnNum >= 0) {
			// 주 대각선 가운데 행으로 옮기기
			for (int i = 0; i < n; i++) {
				temp[center][i] = map[i][i];
			}
			
			// 가운데 열 주 대각선으로 옮기기
			for (int i = 0; i < n; i++) {
				temp[i][i] = map[i][center];
			}
			
			// 부 대각선 가운데 열로 옮기기
			for (int i = 0; i < n; i++) {
				temp[i][center] = map[i][n-1-i];
			}
			
			// 가운데 행 부 대각선으로 옮기기
			for (int i = 0; i < n; i++) {
				temp[n-1-i][i] = map[center][i];
			}
			
			// temp를 map에 덮어씌우기
			copy(temp, map);
		}
	}
	
	// origin 배열을 target 배열에 복사하는 함수
	private static void copy(int[][] origin, int[][] target) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				target[i][j] = origin[i][j];
			}
		}
	}

	// 배열을 출력하는 함수
	private static void print() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]+" ");
			}
			if(i != n-1) sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
