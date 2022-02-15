package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2667
 * 걸린 시간 : 60분
 * 리뷰 : 너비 우선 탐색을 적용해서 현재 위치의 양쪽에 집이 존재하는지 체크하고, 그 후 위 아래를 체크하도록 하였다.
 * 방문 순서를 관리하기 위해 Queue 자료구조를 사용하였고, 이미 방문한 집은 방문하지 않기 위해 visited boolean 배열을 이용하여
 * 한번이라도 방문한 집은 true로 표시해주었다.
*/
public class BOJ_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static Queue<int[]> queue;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 지도의 크기
		map = new int[N][N]; // 지도 배열
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		queue = new LinkedList<>(); // bfs 탐색 방문 순서 관리를 위한 queue
		visited = new boolean[N][N]; // 집 방문 체크 배열
		
		int cnt = 0; // 총 단지 수
		
		List<Integer> list = new ArrayList<>(); // 단지내 집 수를 저장하는 리스트
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 배열값이 1이고 그 집을 방문한적이 없으면 너비 우선 탐색 시작
				if(map[i][j] == 1 && visited[i][j] == false) {
					list.add(bfs(i, j)); // 탐색 후 반환된 값(단지 내 집수) 저장
					cnt++; // 단지 수 1 증가
				}
			}
		}
		
		Collections.sort(list); // 단지내 집 수 오름차순 정렬
		
		System.out.println(cnt); // 단지 수 출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i)); // 단지내 집 수 출력
		}
		
	}
	
	static int bfs(int i, int j) { // i: 탐색 시작 지점의 행 j: 탐색 시작 지점의 열
		queue.offer(new int[]{i, j}); // 탐색 시작 지점을 queue에 추가
		visited[i][j] = true; // 탐색 시작 지점 방문 체크
		
		int cnt = 0; // 단지내 집 수
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int curX = temp[0]; // 현재 방문하고 있는 집의 행 위치
			int curY = temp[1]; // 현재 방문하고 있는 집의 열 위치
			
			cnt++; // 단지내 집 수 1 증가
			// 왼쪽 지점 queue에 추가
			if(curY-1 >= 0 && visited[curX][curY-1] == false && map[curX][curY-1] == 1) {
				queue.offer(new int[]{curX, curY-1});
				visited[curX][curY-1] = true;
			}
			// 오른쪽 지점 queue에 추가
			if(curY+1 < N && visited[curX][curY+1] == false && map[curX][curY+1] == 1) {
				queue.offer(new int[]{curX, curY+1});
				visited[curX][curY+1] = true;
			}
			// 위쪽 지점 queue에 추가
			if(curX-1 >= 0 && visited[curX-1][curY] == false && map[curX-1][curY] == 1) {
				queue.offer(new int[]{curX-1, curY});
				visited[curX-1][curY] = true;
			}
			// 아래쪽 지점 queue에 추가
			if(curX+1 < N && visited[curX+1][curY] == false && map[curX+1][curY] == 1) {
				queue.offer(new int[]{curX+1, curY});
				visited[curX+1][curY] = true;
			}
		}
		
		return cnt; // 단지내 집 수 반환
	}

}
