package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1368
 * 걸린 시간 : 120분+a
 * 리뷰 : 우선 물이 흐르는 경로를 싸이클이 생성되지 않도록 하나의 경로로 이어야 하므로 MST 최소신장트리 알고리즘을 이용하여야 했다.
 * 하지만 논에서 물을 끌어오는 경우와 해당 논에 직접 우물을 파는 경우 두개를 모두 고려해서 그래프를 연결 해야하는데,
 * 이를 하나의 그래프로 어떻게 표현해야할지의 아이디어를 생각하기가 어려운 문제였다.
 * 우물을 파는 경우의 0번째 가상의 노드를 만들면 최소 1개의 우물을 파서 물을 댈 수 있는 경로를 하나의 그래프로 연결할 수 있다.
 * 참고 링크 : https://conkjh032.tistory.com/386
*/
public class BOJ_1368_물대기 {
	static class Edge implements Comparable<Edge>{ // 간선 클래스
		int from, to, weight; // 시작점, 도착점, 가중치(비용)

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) { // 가중치 오름차순 정렬
			return this.weight - o.weight;
		}
	}
	
	static int N, ans;
	static int[] parents;
	static List<Edge> edgeList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 논의 수
		parents = new int[N+1]; // 각 정점의 부모를 저장하는 배열
		edgeList = new ArrayList<>(); // 간선 리스트
		
		// 우물 간선 정보 입력 -> 우물을 0번째 가상 노드로 정의
		for (int i = 1; i <= N; i++) {
			int weight = Integer.parseInt(br.readLine());
			edgeList.add(new Edge(0, i, weight));
		}
		
		// 간선 정보(논 연결 정보) 입력
		for (int i = 1; i <= N; i++) { // from
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) { // to
				int weight = Integer.parseInt(st.nextToken()); // 논 연결 비용
				if (i == j) continue; // 자기 자신으로의 연결이면 pass
				edgeList.add(new Edge(i, j, weight));
			}
		}
		
		Collections.sort(edgeList); // 간선비용을 기준으로 오름차순 정렬
		makeSet(); // 각 정점의 단위 집합 생성
		
		int ans = 0; // 결과값 (최소 신장 트리의 가중치 합)
		int cnt = 0; // 경로를 이은 횟수
		
		for (Edge edge : edgeList) { // 모든 간선을 하나하나 다 연결해보기 
			if(union(edge.from, edge.to)) { // 간선 연결이 되면 (싸이클이 만들어지지 않으면)
				ans += edge.weight; // 결과값에 연결된 간선의 가중치 더하기
				if(++cnt == N) break; // N개의 경로(우물 포함)가 다 이어졌으면 break
			}
		}
		
		System.out.println(ans); // 결과 출력
	}
	
	// 단위집합 생성
	private static void makeSet() {
		// 자신의 부모노드를 자신의 값으로 세팅
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	// a의 집합 찾기 : a의 대표자 찾기
	private static int findSet(int a) {
		if (a == parents[a]) return a;
		return parents[a] = findSet(parents[a]); // path compression
	}
	
	// a,b 두 집합 합치기 -> 같은 경로로 포함시키기
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		// a와 b 집합의 대표자가 같으면 이미 같은 경로에 포함된 집합이라는 뜻
		// 즉 경로를 이으면 싸이클이 생성된다는 뜻이므로 연결하지 않고 종료
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot; // b 집합의 대표자를 a 집합의 대표자로 바꾸기
		return true;
	}


}
