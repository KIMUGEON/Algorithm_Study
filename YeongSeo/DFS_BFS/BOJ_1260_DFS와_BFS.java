package DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1260
 * 걸린 시간 : 40분
 * 리뷰 : 각 정점에 연결된 간선을 표시하기 위해 hashMap을 이용하여 Key를 정점번호 Value를 간선으로 연결된 정점번호 리스트로 표현하였다.
 * 그리고 정점 번호가 작은 것부터 먼저 방문하기로 하였으므로 hashMap의 간선정보 리스트를 오름차순 정렬해주었고,
 * 이미 방문한 정점은 방문하지 않도록 visited 배열을 이용하여 방문체크를 해주었다.
 * 그리고 dfs는 재귀를 이용하여 깊이를 타고 가도록 구현하였고, bfs는 큐 자료구조를 이용하여 방문순서를 관리하였다.
*/
public class BOJ_1260_DFS와_BFS {
	static int N, M, V;
	static Map<Integer, List<Integer>> hMap;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 개수
		M = sc.nextInt(); // 간선의 개수
		V = sc.nextInt(); // 탐색을 시작할 정점의 번호
		hMap = new HashMap<Integer, List<Integer>>(); // 정점 정보를 관리하기 위한 hashMap
		
		// key: 정점 번호 value: 각 정점에 연결된 정점 번호
		for(int i=1; i<=N; i++) {
			hMap.put(i, new ArrayList<Integer>());
		}
		
		// 간선 연결 -> 양방향이라 하였으므로 두 정점을 서로 연결
		for(int i=0; i<M; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			hMap.get(node1).add(node2);
			hMap.get(node2).add(node1);
		}
		
		// 정점 번호가 작은 것부터 방문할 수 있도록 오름차순 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(hMap.get(i));
		}
		
		// dfs 시작
		visited = new boolean[N+1];
		dfs(V);
		
		System.out.println();
		
		// bfs 시작
		visited = new boolean[N+1];
		bfs();
	}
	
	// 깊이 우선 탐색
	static void dfs(int current) { // current: 현재 방문하고 있는 정점 번호
		visited[current] = true; // 방문함 체크
		System.out.print(current + " ");
		
		// 현재 방문하고 있는 정점에 연결된 정점을 방문
		for(int i=0; i<hMap.get(current).size(); i++) {
			int node = hMap.get(current).get(i);
			if(!visited[node]) {
				dfs(node);
			}
		}
	}
	
	// 너비 우선 탐색
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(V); // 최초로 탐색을 시작할 정점 번호 넣기
		visited[V] = true; // 방문함 체크

		while(!queue.isEmpty()) {
			int current = queue.poll(); // 현재 방문하고 있는 정점 번호
			System.out.print(current + " ");
			
			// 현재 방문하고 있는 정점에 연결되어 있는 정점을 queue에 넣기
			for(int i=0; i<hMap.get(current).size(); i++) {
				int node = hMap.get(current).get(i);
				if(!visited[node]) {
					queue.offer(node);
					visited[node] = true;
				}
			}
		}
	}

}
