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
 * 문제 링크 : https://www.acmicpc.net/problem/2252
 * 걸린 시간 : 30분
 * 위상 정렬 알고리즘 참고 링크 : https://codingnojam.tistory.com/66
*/
public class BOJ_2252_줄_세우기 {
	static int N;
	static int[] indegree, answer;
	static List<List<Integer>> outdegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 학생의 수
		int M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수
		indegree = new int[N+1]; // 노드의 진입차수 배열
		outdegree = new ArrayList<>(); // 각 노드의 진출 노드 번호 목록을 저장할 리스트
		answer = new int[N+1]; // 키 순서대로 줄을 세운 결과 (위상 정렬의 결과)
		
		// 진출 차수 리스트 노드 수만큼 초기화
		for (int i = 0; i <= N; i++) {
			outdegree.add(new ArrayList<>());
		}
		
		// 키 비교 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()); // 학생 A (노드 A)
			int B = Integer.parseInt(st.nextToken()); // 학생 B (노드 B)
			
			indegree[B] += 1; // B번 노드의 진입차수 1 증가
			outdegree.get(A).add(B); // A번 노드의 진출 노드 목록에 B 추가
		}
		
		topologySort(); // 위상 정렬 수행
		
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]+" ");
		}
		
		System.out.println(sb.toString());
	}

	private static void topologySort() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0; // 줄을 세운 수 카운트
		
		// 진입차수가 0인 노드 queue에 넣기
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int no = queue.poll(); // 현재 노드 번호
			
			answer[++cnt] = no; // cnt번째 줄에 현재 노드 번호의 학생 저장 
			
			// 현재 노드 번호의 진출 노드들 하나씩 꺼내기
			for (int nextNo : outdegree.get(no)) {
				indegree[nextNo] -= 1; // 진출 노드의 진입차수 1 감소
				
				// 갱신된 진출 노드의 진입차수가 0일 경우 queue에 넣기
				if (indegree[nextNo] == 0) {
					queue.add(nextNo);
				}
			}
		}
		
	}

}
