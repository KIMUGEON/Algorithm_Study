package Sort;

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
 * 문제 링크 : https://www.acmicpc.net/problem/1516
 * 걸린 시간 : 180분
 * 위상 정렬 알고리즘 참고 링크 : https://codingnojam.tistory.com/66
*/
public class BOJ_1516_게임_개발 {
	public static class Building { // 건물 객체
		int time; // 건물을 짓는데 걸리는 시간
		List<Integer> outdegree; // 진출 차수 리스트
		
		public Building(int time, List<Integer> adjList) {
			super();
			this.time = time;
			this.outdegree = adjList;
		}
	}
	
	static int N;
	static int[] answer, indegree;
	static Building[] buildings;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 건물의 종류 수
		buildings = new Building[N+1]; // 각 건물의 객체를 저장할 배열
		answer = new int[N+1]; // 먼저 지어져야할 건물들의 시간을 저장할 배열
		indegree = new int[N+1]; // 각 건물(노드)의 진입 차수를 저장할 배열
		
		// 각 건물의 객체 생성 및 초기화
		for (int i = 1; i <= N; i++) {
			Building building = new Building(0, new ArrayList<>());
			buildings[i] = building;
		}
		
		// 각 건물의 정보 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			buildings[i].time = Integer.parseInt(st.nextToken()); // 각 건물을 짓는데 걸리는 시간
			
			indegree[i] = st.countTokens() - 1; // 각 건물의 진입 차수
			
			while(st.hasMoreTokens()) {
				int value = Integer.parseInt(st.nextToken());
				// 입력값이 -1이 아닐 경우
				if (value != -1) {
					buildings[value].outdegree.add(i); // value번째 건물의 진출 차수에 i번째 건물 추가
				}
			}
		}
		
		topologySort(); // 위상 정렬 함수 실행
		
		// 결과 출력
		for (int i = 1; i <= N; i++) {
			// 미리 지어져야 하는 건물들 시간 + 자기 자신을 짓는데 걸리는 시간
			System.out.println(answer[i] + buildings[i].time);
		}
	}
	
	// bfs로 위상 정렬 수행하는 함수 -> 건물의 선후관계 순서에 따라 방문 순서 정하기
	private static void topologySort() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 진입차수가 0인 건물(노드) 번호 queue에 넣기
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int no = queue.poll(); // 건물(노드) 번호 꺼내기
			
			List<Integer> outdegree = buildings[no].outdegree; // 현재 건물의 진출 차수 리스트
			
			for (int nextNo : outdegree) { // nextNo : 현재 건물 다음에 지어져야하는 건물 번호
				indegree[nextNo] -= 1; // 다음 건물의 진출 차수 1 감소
				
				// 
				answer[nextNo] = Math.max(answer[nextNo], answer[no] + buildings[no].time);
				
				// 갱신된 건물(노드)의 진입차수가 0이면 queue에 넣기
				if (indegree[nextNo] == 0) {
					queue.offer(nextNo);
				}
			}
		}
	}

	/*
	 * 처음 시도했던 dfs+dp 방법 -> 실패
	 * Why? 각 건물을 짓는데 선후관계, 즉 건물을 짓는 순서가 존재하기에 단순한 dfs로는
	 * 건물의 선후관계를 고려하여 방문할 수 없다.
	 * 따라서 위상 정렬로 건물의 방문 순서를 고려해야 한다.
	 */
//	private static int dfs(int idx) {
//		if (dp[idx] != 0) {
//			return dp[idx];
//		}
//		
//		dp[idx] = buildings[idx].time;
//
//		List<Integer> pre = buildings[idx].pre;
//	
//		if (pre.size() != 0) {
//			int max = 0;
//			for (int i = 0; i < pre.size(); i++) {
//				max = Math.max(max, buildings[pre.get(i)].rank);
//			}
//			
//			dp[idx] += dfs(max);
//		}
//
//		return dp[idx];
//	}

}
