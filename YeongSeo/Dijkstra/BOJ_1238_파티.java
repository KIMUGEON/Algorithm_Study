package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1238
 * 걸린 시간 : 60분
*/
public class BOJ_1238_파티 {
	public static class Vertex implements Comparable<Vertex>{ // 정점(마을) 객체
		int no, cost; // 정점 번호, 출발지에서 자신으로까지의 최소소요시간(최소비용)

		public Vertex(int no, int cost) {
			super();
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) { // 소요시간을 기준으로 오름차순
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생, 마을의 개수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수
		int X = Integer.parseInt(st.nextToken()); // 파티를 열 마을(목적지)
		
		List<List<Vertex>> adjList = new ArrayList<List<Vertex>>(); // 정점(마을) 인접리스트 (인덱스는 시작정점번호)
		
		// 인접리스트 마을 개수만큼 초기화
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		// 도로 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 도로의 시작점
			int to = Integer.parseInt(st.nextToken()); // 도로의 끝점
			int cost = Integer.parseInt(st.nextToken()); // 소요시간
			
			adjList.get(from).add(new Vertex(to, cost)); // 인접리스트에 추가
		}
		
		int res = Integer.MIN_VALUE; // 가장 오래 걸리는 학생의 소요시간 (결과값)
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>(); // 최소비용인 정점부터 탐색하기위한 우선순위큐
		boolean[] visited = new boolean[N+1]; // 최소비용 확정여부
		int[] backCost = new int[N+1]; // X번 마을에서 자신으로 오는 최소비용 (=집으로 돌아갈 때의 최소시간)
		
		Arrays.fill(backCost, Integer.MAX_VALUE); // backCost 초기화
		
		backCost[X] = 0; // 시작점 최소비용 0으로 초기화
		pQueue.offer(new Vertex(X, backCost[X])); // 시작점 정점 넣어주기
		
		// X번 마을에서 집으로 돌아갈 때의 최소시간 구하기
		while(!pQueue.isEmpty()) {
			Vertex current = pQueue.poll(); // 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			
			if(visited[current.no]) continue; // 이미 최소비용이 확정된 정점이면 pass
			
			visited[current.no] = true; // 최소비용 확정 체크
			
			// 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른정점의 최소비용을 고려
			for(Vertex temp : adjList.get(current.no)) {
				if(!visited[temp.no] && backCost[temp.no] > backCost[current.no] + temp.cost) {
					backCost[temp.no] = backCost[current.no] + temp.cost;
					pQueue.offer(new Vertex(temp.no, backCost[temp.no]));
				}
			}
		}
		
		int[] cost = new int[N+1]; // 출발지에서 자신으로 오는 최소비용
		
		// N명의 학생 마을 모두 한번씩 출발지로 지정하여 각 학생의 소요시간 구하기
		for (int start = 1; start <= N; start++) { // start: 출발지
			if(start == X) continue; // 출발지가 X일 경우 pass
			
			// 필요한 메모리들 초기화
			Arrays.fill(cost, Integer.MAX_VALUE);
			Arrays.fill(visited, false);
			pQueue.clear();
			
			// 출발지점 세팅
			cost[start] = 0;
			pQueue.offer(new Vertex(start, cost[start]));
			
			// 최소시간 구하기
			while(!pQueue.isEmpty()) {
				Vertex current = pQueue.poll();
				
				if(visited[current.no]) continue;
				// 현재 위치가 X이면 출발지에서 X로의 최소시간을 구했다는 뜻이므로 나머지는 안해도됨
				else if(current.no == X) break;
				
				visited[current.no] = true;
				
				for(Vertex temp : adjList.get(current.no)) {
					if(!visited[temp.no] && cost[temp.no] > cost[current.no] + temp.cost) {
						cost[temp.no] = cost[current.no] + temp.cost;
						pQueue.offer(new Vertex(temp.no, cost[temp.no]));
					}
				}
			}
			
			// cost[X]: 출발지에서 X로 가는 최소시간
			// backCost[start]: X에서 출발지로 다시 되돌아가는 최소시간
			res = Math.max(res, cost[X]+backCost[start]);
		}
		
		System.out.println(res); // 결과 출력
	}

}
