package _0308_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5972_김준우 {
	static int N, M;	//(헛간)정점, (길)간선의 개수
	static int[] dist;	//여물을 줘야하는 수[해당 정점까지의 비용]
	static ArrayList<Node>[] list;
	static boolean[] visited;
	
	//ㅣist[i]인 경우 i에서 d로 가는길 에 먹이를 주어야 할 소의 수
	public static class Node implements Comparable<Node> {
		int d;		//타겟 헛간
		int cost;	//현재 길에 있는 소의 수
		
		public Node(int d, int cost) {
			this.d = d;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}
		
	public static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		dist[1] = 0;
		q.offer(new Node(1, 0));

		while(!q.isEmpty()) {
			Node current = q.poll();
			
			if(visited[current.d]) continue;
			visited[current.d] = true;
			
			for(int i = 0; i < list[current.d].size(); i++) {
				Node next = list[current.d].get(i);	
				if(dist[next.d] > dist[current.d] + next.cost) {	//현재
					dist[next.d] = dist[current.d] + next.cost;
					q.offer(new Node(next.d, dist[next.d]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//===Input 1st Line=================
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//====list 배열의 i번째 항목은 i헛간에서 출발하는 경우========
		list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		        
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
	
		visited = new boolean[N + 1];	//방문체크
		dist = new int[N + 1];			//누적 여물을 주어야할 소의 수
		Arrays.fill(dist, Integer.MAX_VALUE); //최대값으로 초기화
		
		dijkstra();
		
		//출력
		System.out.println(dist[N]); 
	}
}
