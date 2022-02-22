package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/12100
 * 걸린 시간 : 120분
 */
public class BOJ_12100_2048_Easy {
	static int N;
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 보드의 크기
		int[][] map = new int[N][N]; // 게임판의 블록값을 저장하는 배열
		StringTokenizer st;
		
		int max = Integer.MIN_VALUE; // 현재 블록의 값중 가장 큰값
		
		// 게임판의 초기 상태 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]); // 가장 큰 블록값 구하기
			}
		}

		res = Integer.MIN_VALUE; // 얻을 수 있는 가장 큰 블록 (결과값)

		dfs(map, 0, max);
		
		System.out.println(res); // 결과 출력
	}

	/**
	 * @param map : 현재 게임판의 상태
	 * @param cnt : 직전까지 블록을 이동시킨 횟수
	 * @param max : 현재까지 게임판에서 가장 큰 블록값
	 */
	private static void dfs(int[][] map, int cnt, int max) {	
		if(cnt == 5) { // 5번 이동했으면 게임판에서 가장 큰 블록값 비교하기
			res = Math.max(res, max);
			return;
		}

		// 가지치기 -> 남은 이동수동안 현재까지 가장 큰 블록값을 넘어설 수 있는지 판단
		if(res >= max*Math.pow(2, 5-cnt)) { // 5-cnt : 남은 이동수
			return;
		}

		int[][] copy; // 임시배열 (현재 게임판 복사)
		int curMax; // 블록 이동이 끝난 후의 가장 큰 블록값
		
		// 오른쪽으로 이동
		copy = mapCopy(map);
		curMax = max;
		for(int i=0; i<N; i++) {
			boolean[] isChecked = new boolean[N]; // 이미 블록이 합쳐졌는지를 체크하는 배열
			
			for(int j=N-1; j>0; j--) {
				if(copy[i][j] == 0) { // 타겟 블록이 0인 경우(비어있는 경우)
					// 0이 아닌 블록을 만날때까지 탐색
					for(int k=j-1; k>=0; k--) {
						if(copy[i][k] != 0) { 
							// 0이 아닌 블록을 만났으면 타겟 블록 자리에 탐색한 블록 끌어오기
							copy[i][j] += copy[i][k];
							// 탐색한 블록은 숫자를 끌어와서 비어있는 상태니 0으로 바꾸기
							copy[i][k] = 0;
							curMax = Math.max(curMax, copy[i][j]); // 가장 큰 블록값인지 체크
							// 현재 합쳐진 타겟 블록과 그 이전의 블록을 합칠 수 있는지 체크
							if(j+1 < N && !isChecked[j+1] && copy[i][j+1] == copy[i][j]) {
								copy[i][j+1] += copy[i][j];
								copy[i][j] = 0;
								curMax = Math.max(curMax, copy[i][j+1]); // 가장 큰 블록값인지 체크
								isChecked[j+1] = true; // 중복으로 합쳐지지 않게 합쳐진 위치 체크
								j++; // j번째 위치는 합쳐져서 0이 되었으니 다시 블록 끌어오기 위해 위치 초기화
							}
							break;
						}
					}
				}
				else { // 타겟 블록에 숫자가 있는 경우
					for(int k=j-1; k>=0; k--) {
						if(copy[i][k] == 0) continue; // 0은 타겟 블록과 합쳐질 수 없으니 pass
		
						if(copy[i][j] == copy[i][k]) { // 타겟 블록과 같은 값의 블록을 발견하면 합치기
							copy[i][j] += copy[i][k];
							copy[i][k] = 0;
							curMax = Math.max(curMax, copy[i][j]); // 가장 큰 블록값인지 체크
							isChecked[j] = true; // 중복으로 합쳐지지 않게 합쳐진 위치 체크
						}
						break;
					}
				}
			}
		}
		dfs(copy, cnt+1, curMax); // 다음 이동하러 가기
		
		// 왼쪽으로 이동
		copy = mapCopy(map);
		curMax = max;
		for(int i=0; i<N; i++) {
			boolean[] isChecked = new boolean[N];
			
			for(int j=0; j<N-1; j++) {
				if(copy[i][j] == 0) {
					for(int k=j+1; k<N; k++) {
						if(copy[i][k] != 0) { 
							copy[i][j] += copy[i][k];
							copy[i][k] = 0;
							curMax = Math.max(curMax, copy[i][j]);
							if(j-1 >= 0 && !isChecked[j-1] && copy[i][j-1] == copy[i][j]) {
								copy[i][j-1] += copy[i][j];
								copy[i][j] = 0;
								curMax = Math.max(curMax, copy[i][j-1]);
								isChecked[j-1] = true;
								j--;
							}
							break;
						}
					}
				}
				else {
					for(int k=j+1; k<N; k++) {
						if(copy[i][k] == 0) continue;
						
						if(copy[i][j] == copy[i][k]) {
							copy[i][j] += copy[i][k];
							copy[i][k] = 0;
							curMax = Math.max(curMax, copy[i][j]);
							isChecked[j] = true;
						}
						break;
					}
				}
			}
		}
		dfs(copy, cnt+1, curMax);
		
		// 아래쪽으로 이동
		copy = mapCopy(map);
		curMax = max;
		for(int i=0; i<N; i++) {
			boolean[] isChecked = new boolean[N];
			
			for(int j=N-1; j>0; j--) {
				if(copy[j][i] == 0) {
					for(int k=j-1; k>=0; k--) {
						if(copy[k][i] != 0) { 
							copy[j][i] += copy[k][i];
							copy[k][i] = 0;
							curMax = Math.max(curMax, copy[j][i]);
							if(j+1 < N && !isChecked[j+1] && copy[j+1][i] == copy[j][i]) {
								copy[j+1][i] += copy[j][i];
								copy[j][i] = 0;
								curMax = Math.max(curMax, copy[j+1][i]);
								isChecked[j+1] = true;
								j++;
							}
							break;
						}
					}
				}
				else {
					for(int k=j-1; k>=0; k--) {
						if(copy[k][i] == 0) continue;
						
						if(copy[j][i] == copy[k][i]) {
							copy[j][i] += copy[k][i];
							copy[k][i] = 0;
							curMax = Math.max(curMax, copy[j][i]);
							isChecked[j] = true;
						}
						break;
					}
				}
			}
		}
		dfs(copy, cnt+1, curMax);
		
		// 위쪽으로 이동
		copy = mapCopy(map);
		curMax = max;
		for(int i=0; i<N; i++) {
			boolean[] isChecked = new boolean[N];
			
			for(int j=0; j<N-1; j++) {
				if(copy[j][i] == 0) {
					for(int k=j+1; k<N; k++) {
						if(copy[k][i] != 0) { 
							copy[j][i] += copy[k][i];
							copy[k][i] = 0;
							curMax = Math.max(curMax, copy[j][i]);
							if(j-1 >= 0 && !isChecked[j-1] && copy[j-1][i] == copy[j][i]) {
								copy[j-1][i] += copy[j][i];
								copy[j][i] = 0;
								curMax = Math.max(curMax, copy[j-1][i]);
								isChecked[j-1] = true;
								j--;
							}
							break;
						}
					}
				}
				else {
					for(int k=j+1; k<N; k++) {
						if(copy[k][i] == 0) continue;
						
						if(copy[j][i] == copy[k][i]) {
							copy[j][i] += copy[k][i];
							copy[k][i] = 0;
							curMax = Math.max(curMax, copy[j][i]);
							isChecked[j] = true;
						}
						break;
					}
				}
			}
		}
		dfs(copy, cnt+1, curMax);
	}

	// 배열을 복사하는 함수
	private static int[][] mapCopy(int[][] map) {
		int[][] temp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		return temp;
	}

}
