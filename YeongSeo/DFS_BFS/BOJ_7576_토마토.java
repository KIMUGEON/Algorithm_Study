package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2606
 * 걸린 시간 : 60분
 * 리뷰 : 백준 2667번 문제와 비슷한 문제이지만, bfs를 진행할 때 현재 너비를 생각해서 탐색을 진행해야 한다는 점이 중요한 문제였다.
 * 같은 너비의 토마토를 다 탐색하면 다음 너비로 넘어가고 하루를 더해줘야 하는게 핵심포인트였다.
 * 또한 익지 못하는 토마토가 있을 경우 -1을 출력해줘야 하기 때문에,
 * 익은 토마토 개수와 전체 토마토 개수를 따로 구해서 변수에 저장해야하고 출력하기 전에 이를 비교해주는 것도 중요한 사항이었던 것 같다.
*/
public class BOJ_7576_토마토 {
	static int N, M, K;
	static int[][] map;
	static List<int[]> start;
	static Queue<int []> queue;
	static int cnt = 0; // 익은 토마토 개수
	static int day = 0; // 토마토가 모두 익을 때까지 걸리는 최소 날짜 (결과값)
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
		map = new int[N][M]; // 토마토가 들어있는 상자
		start = new ArrayList<>(); // 맨 처음 시점의 익은 토마토 위치
		queue = new LinkedList<>(); // 탐색 순서를 저장할 Queue
		K = M*N; // 상자에 들어있는 토마토의 개수 (처음은 최대 개수로 초기화)
		
		// 상자 칸에 토마토 상태 입력 (1: 익은 토마토, 0: 익지 않은 토마토, -1: 빈 칸)
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				
				// -1이면(토마토가 들어있지 않은 칸이면) 토마토 개수 1개 빼기
				if(temp == -1) K--;
				// 1이면(익은 토마토이면) 탐색을 시작할 시작위치(i,j) 저장
				else if(temp == 1) {
					start.add(new int[] {i, j});
					cnt++; // 익은 토마토 개수 1 증가
				}
			}
		}
		
		// 너비 우선 탐색 시작
		bfs();
		
		// 익은 토마토 개수가 전체 토마토 개수보다 적으면 토마토가 모두 익지 못했으므로 -1 저장
		if(cnt < K) day = -1;
		
		System.out.println(day); // 결과 출력
	}
	
	// 너비 우선 탐색 함수
	static void bfs() {
		
		// 맨 처음 시점의 익은 토마토 위치 queue에 넣기
		for(int i=0; i<start.size(); i++) {
			queue.add(start.get(i));
		}
		
		while(!queue.isEmpty()) {
			
			// 전체 토마토 개수와 익은 토마토 개수가 같으면 return
			if(cnt == K) return;
			
			// 하루 증가
			day++;
			
			// 같은 너비의 토마토들 모두 탐색
			int size = queue.size(); // 하루(같은 너비)동안 탐색해야할 토마토 개수
			while(--size >= 0) {
				int[] temp =  queue.poll();
				int curX = temp[0]; // 현재 주목하고 있는 토마토의 행 위치
				int curY = temp[1]; // 현재 주목하고 있는 토마토의 열 위치
				
				// 왼쪽이 익지 않은 토마토이면 queue에 추가
				if(curY-1 >= 0 && map[curX][curY-1] == 0) {
					queue.offer(new int[]{curX, curY-1});
					map[curX][curY-1] = 1; // 익은 토마토로 바꾸기
					cnt++; // 익은 토마토 개수 1증가
				}
				// 오른쪽이 익지 않은 토마토이면 queue에 추가
				if(curY+1 < M && map[curX][curY+1] == 0) {
					queue.offer(new int[]{curX, curY+1});
					map[curX][curY+1] = 1;
					cnt++;
				}
				// 위쪽이 익지 않은 토마토이면 queue에 추가
				if(curX-1 >= 0 && map[curX-1][curY] == 0) {
					queue.offer(new int[]{curX-1, curY});
					map[curX-1][curY] = 1;
					cnt++;
				}
				// 아래쪽이 익지 않은 토마토이면 queue에 추가
				if(curX+1 < N && map[curX+1][curY] == 0) {
					queue.offer(new int[]{curX+1, curY});
					map[curX+1][curY] = 1;
					cnt++;
				}
			}
			
		}
	}
	
	

}
