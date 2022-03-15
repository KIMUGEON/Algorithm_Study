package study_0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_김유완 {
	static int N,M,result;
	static ArrayList<ArrayList<Node>> list;
	static int[] distance;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static class Node implements Comparable<Node>{
		int e,c;

		public Node(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.c - o.c;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 도시 개수
		M = Integer.parseInt(br.readLine()); // 버스 개수
		list = new ArrayList<>();
		distance = new int[N+1]; // 출발지에서 자신으로 오는 최소비용
		visited = new boolean[N+1]; // 최소비용 확정여부
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		// 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(start).add(new Node(end,cost));
		}
		// 시작도시와 끝도시 알기
		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());	
		Arrays.fill(distance,Integer.MAX_VALUE);
		dijkstra(startCity,endCity);
		System.out.println(result);
		
	}
	static void dijkstra(int start, int end) {
		pq.offer(new Node(start,0));
		distance[start] = 0; // 시작점 0
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(!visited[current.e]) {
				visited[current.e] = true;
				// 경유가 좋은지 아닌지 확인
				for(Node node : list.get(current.e)) {
					if(!visited[node.e] && distance[node.e] > distance[current.e] + node.c) {
						distance[node.e] = distance[current.e] + node.c;
						pq.add(new Node(node.e,distance[node.e]));
					}
				}
			}
			result = distance[end]; // 마지막 결과 result에 넣기
		}
	}
}
