
package _0428;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_김준우 {
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] edgeCount = new int[N+1];
		//edgeCount[0] = -1;	//맨 첫번째 인덱스는 비활성화
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int shorter = Integer.parseInt(st.nextToken());
			int taller = Integer.parseInt(st.nextToken());
			edgeCount[taller] ++;
			graph.get(shorter).add(taller);
			//System.out.println(pre);
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		// 진입차수가 0인 값 큐에 넣기
		for (int i = 1; i < edgeCount.length; i++) {
			if (edgeCount[i] == 0) {
			q.offer(i);
			}
		}
		
		// 큐가 빌 때까지 반복
		while (!q.isEmpty()) {
			// 큐에서 노드번호 꺼내기
			int nodeNo = q.poll();
			// 꺼낸 노드번호 정렬 결과값에 저장
			bw.write(String.valueOf(nodeNo) + " ");
			// 꺼낸 노드의 인접한 노드들 찾기
			List<Integer> list = graph.get(nodeNo);
			// 인접한 노드의 개수만큼 반복문 실행
			for (int i = 0; i < list.size(); i++) {
				// 인접한 노드 진입차수 갱신
				edgeCount[list.get(i)] -- ;
				// 갱신된 노드의 진입차수가 0이면 큐에 노드 넣기
				if (edgeCount[list.get(i)] == 0) {
					q.offer(list.get(i));
				}
			}
		}
		// 위상정렬 수행 결과 값 출력
		bw.flush();

	}

}


/*
package _0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2252_김준우 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> comps;
	static boolean[] visited;
	static LinkedList<Integer> list;
	
	public static void makeLine(int n) {
		//방문체크
		visited[n] = true;
		
		//n번째 학생과 다른 학생들을 비교
		for (int j = 1; j < N+1; j++) {
			//자신과 자신을 비교하는 경우 제외
			if(n == j) continue;
			
			//자신보다 앞에 있어야 하며 아직 방문하지 않은 학생이 있으므로 그 학생부터 리스트에 담기
			if(comps.get(n).contains(j) && !visited[j]) makeLine(j);
		}
		list.add(n);
	}
	
	public static void print() {
		for (int i = 1; i <= N; i++) {
			System.out.print(list.poll() + " ");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		comps = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N+1; i++) {
			comps.add(new ArrayList<Integer>());
		}
		
		visited = new boolean[N+1];
		list = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			int post = Integer.parseInt(st.nextToken());
			
			comps.get(post).add(pre);
		}
		
		//첫번째부터 N번째 학생까지 탐색
		for (int i = 1; i < N+1; i++) {
			if(visited[i]) continue;
			makeLine(i);
			
		}
		
		print();
	}

}*/

/*
package _0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2252_김준우 {
	static int N, M;
	static int[][] comp;
	static boolean[] visited;
	static LinkedList<Integer> list;
	
	public static void makeLine(int n) {
		//방문체크
		visited[n] = true;
		
		//n번째 학생과 다른 학생들을 비교
		for (int j = 1; j < N+1; j++) {
			//자신과 자신을 비교하는 경우 제외
			if(n == j) continue;
			
			//자신보다 앞에 있어야 하며 아직 방문하지 않은 학생이 있으므로 그 학생부터 리스트에 담기
			if(comp[n][j] == -1 && !visited[j]) makeLine(j);
		}
		list.add(n);
	}
	
	public static void print() {
		for (int i = 1; i <= N; i++) {
			System.out.print(list.poll() + " ");
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		comp = new int[N+1][N+1];
		visited = new boolean[N+1];
		list = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			int post = Integer.parseInt(st.nextToken());
			
			comp[pre][post] = 1;
			comp[post][pre] = -1;
		}
		
		//첫번째부터 N번째 학생까지 탐색
		for (int i = 1; i < N+1; i++) {
			if(visited[i]) continue;
			makeLine(i);
			
		}
		
		print();
	}

}
*/