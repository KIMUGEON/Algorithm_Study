package etc.DFS와_BFS.Silver1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_9205 {// 맥주 마시면서 걸어가기

	static int map[][], n;
	static ArrayList<Node> list;
	static int INF = 999999;
	static Scanner sc = new Scanner(System.in);

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			input();
			search();
			floyd();
			output();

		}
	}

	private static void output() {
		if (map[0][n + 1] > 0 && map[0][n + 1] < INF) {
			System.out.println("happy");
		} else {
			System.out.println("sad");
		}
	}

	private static void floyd() {//플로이드 와샬
		for (int k = 0; k < n + 2; k++) {
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					if (i != j && k != j && map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
	}

	private static void search() {//맥주 1병에 50m, 총 20병이므로 1000m, 1000m이하 찾기
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				if (i == j)
					continue;

				Node cur = list.get(i);
				Node next = list.get(j);
				int dis = Math.abs(cur.x - next.x) + Math.abs(cur.y - next.y);

				if (dis <= 1000)
					map[i][j] = 1;
			}
		}
	}

	private static void input() {
		n = sc.nextInt();
		map = new int[n + 2][n + 2];
		list = new ArrayList<>();

		for (int i = 0; i < n + 2; i++) {
				Arrays.fill(map[i], INF);
		}

		for (int i = 0; i < n + 2; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Node(x, y));
		}

	}

}
