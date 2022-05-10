package _0510_Class4_김준우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1043_김준우 {
	static int N, M, cnt;
	static boolean[][] graph;	//멤버별 만나는지 여부
	static boolean[] truth;		//진실을 아는사람 체크
	static boolean[] visited;	//dfs용 방문체크
	static ArrayList<ArrayList<Integer>> party;	//파티별 방문객 정보
	
	public static void dfs(int n) {
		visited[n] = true;
		truth[n] = true;
		
		for (int j = 1; j <= N; j++) {
			if(visited[j]) continue;
			if(!graph[n][j]) continue;
			dfs(j);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫번째줄 입력 및 선언
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;	//거짓말 가능한 파티 수
		graph = new boolean[N+1][N+1];	//멤버별 만나는지 여부
		truth = new boolean[N+1];	//진실을 아는사람 체크
		visited = new boolean[N+1];	//dfs용 방문체크
		party = new ArrayList<ArrayList<Integer>>();	//파티별 방문객 정보
		
		//진실을 아는 사람 입력
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			int temp = Integer.parseInt(st.nextToken());
			truth[temp] = true;
		}
		
		//파티별 방문객 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int visitor = Integer.parseInt(st.nextToken());	//파티의 방문객수
			
			//파티 방문객 정보를 party리스트에 저장한다.
			party.add(new ArrayList<Integer>());
			for (int j = 0; j < visitor; j++) {
				int temp = Integer.parseInt(st.nextToken());
				party.get(i).add(temp);
			}
			
			//파티의 멤버별 관계를 그래프에 표기한다.
			for (int j = 0; j < visitor; j++) {
				for (int k = 0; k < visitor; k++) {
					if(j==k) continue;
					int p1 = party.get(i).get(j);
					int p2 = party.get(i).get(k);
					graph[p1][p2] = true;
					graph[p2][p1] = true;
				}
			}
		}
		
		//진실을 아는사람과 같은 파티에 참여하는 사람도 진실을 알게 될 사람이므로 truth[index] 값을 true로 지정함
		for (int i = 1; i <= N; i++) {
			if(!truth[i]) continue;
			if(visited[i]) continue;
			dfs(i);
		}
		
		//파티를 탐색하며 진실을 알거나 알게 될 사람이 있는 경우를 제외하고 값을 구한다.
		loop:
		for (int i = 0; i < party.size(); i++) {
			for (int j = 0; j < party.get(i).size(); j++) {
				int temp = party.get(i).get(j);
				if(truth[temp]) continue loop;
			}
			//진실을 알게될 사람이 없으므로 거짓말한다
			cnt++;
		}

		System.out.println(cnt);
		
	}
}
