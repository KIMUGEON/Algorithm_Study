package DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2606
 * 걸린 시간 : 20분
*/
public class BOJ_2606_바이러스 {
	static int N, M;
	static Map<Integer, List<Integer>> hMap;
	static int cnt = 0;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 컴퓨터의 수
		M = sc.nextInt(); // 연결되어 있는 컴퓨터 쌍의 수
		hMap = new HashMap<Integer, List<Integer>>(); // 서로 연결되어 있는 컴퓨터를 관리하기 위한 HashMap
		visited = new boolean[N+1]; // 방문 체크를 위한 배열
		
		// key: 컴퓨터 번호 value: 각 컴퓨터에 연결된 다른 컴퓨터 번호 리스트
		for(int i=1; i<=N; i++) {
			hMap.put(i, new ArrayList<>());
		}
		
		// 컴퓨터 서로 연결
		for(int i=0; i<M; i++) {
			int com1 = sc.nextInt(); // 서로 연결할 컴퓨터1
			int com2 = sc.nextInt(); // 서로 연결할 컴퓨터2
			
			hMap.get(com1).add(com2); // 컴퓨터1에 컴퓨터2 연결
			hMap.get(com2).add(com1); // 컴퓨터2에 컴퓨터1 연결
		}
		
		dfs(1); // 깊이 우선 탐색 시작 (1번 컴퓨터부터 탐색 시작)
		
		System.out.println(cnt); // 결과 출력
	}

	// 깊이 우선 탐색
	private static void dfs(int current) { // current: 현재 주목하고 있는 컴퓨터 번호
		visited[current] = true; // 현재 컴퓨터 방문 체크
		
		if(current != 1) cnt++; // 감염된 컴퓨터 수 1 증가 (컴퓨터 번호가 1일 때는 제외)
		
		int size = hMap.get(current).size(); // 현재 컴퓨터와 연결된 컴퓨터 수
		
		for(int i=0; i<size; i++) {
			// 이미 방문한 컴퓨터는 이동 제외
			if(visited[hMap.get(current).get(i)]) continue;
			
			// 연결된 다른 컴퓨터로 이동
			dfs(hMap.get(current).get(i));
		}
	}
	
}
