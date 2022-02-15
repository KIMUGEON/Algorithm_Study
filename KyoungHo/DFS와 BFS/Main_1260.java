package Silver2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
  [입력]
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
입력으로 주어지는 간선은 양방향이다.
 */
public class Main_1260 {// DFS와 BFS

	static int N, M, V, arr[][];
	static boolean visit[];
	static Queue<Integer> queue = new LinkedList<>();	//bfs는 큐 사용

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//정점 개수
		M = sc.nextInt();	//간선 개수
		V = sc.nextInt();	//탐색 시작 정점 번호
		arr = new int[N + 1][N + 1];	//0 사용 안함
		visit = new boolean[N + 1];		//방문 체크

		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			arr[r][c] = 1;	//양방향 그래프
			arr[c][r] = 1;	//양방향 그래프
		}
		sc.close();

		dfs(V);	//시작 정점번호 = V
		System.out.println();
		Arrays.fill(visit, false); //배열 초기화

		bfs(V);
		System.out.println();
		visit = new boolean[N + 1];	//배열 초기화, 위에 초기화랑 같음

	}

	public static void dfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");

		for (int i = 1; i <= N; i++) {
			if (arr[v][i] == 1 && !visit[i]) { //연결되어있고 방문 X
				dfs(i);
			}
		}
	}

	public static void bfs(int v) {
		queue.add(v);
		visit[v] = true;

		while (!queue.isEmpty()) {

			v = queue.poll();
			System.out.print(v + " ");

			for (int i = 1; i <= N; i++) {
				if (arr[v][i] == 1 && !visit[i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
		queue.clear();
	}
}
