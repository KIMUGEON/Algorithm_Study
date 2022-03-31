package _0225_IM대비;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Main_14501_김준우 {
	static int N;
	static int[][] jobs;
	static boolean[] schedule;
	static boolean[][] graph;	// 각 상담간 겹치는지 여부
	static boolean[] overlap, visited;	//다른 일정과 겹쳤는지 여부, 탐색시 방문여부
	
	public static void sol() {
		boolean isend = true;
		for(int i = 0;i<N;i++) {
			if(!visited[i]) {
				isend = false;
				break;
			}
		}
		if(isend) {
			//System.out.println(Arrays.toString(schedule));
			int result = 0;
			for(int i = 0;i<N;i++) {
				if(schedule[i]) {
					result += jobs[i][1];
				}
			}
			System.out.println(result);
		}
		
		for(int i = 0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			schedule[i] = true;
			for(int j = 0;j<N;j++) {
				if(graph[i][j]) {
					visited[j] = true;
				}
			}
			sol();
			//visited[i] = false;
			//schedule[i] = false;
			for(int j = 0;j<N;j++) {
				if(graph[i][j]) {
					//visited[j] = false;
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		jobs = new int[N][2];
		graph = new boolean[N][N];	// 각 상담간 겹치는지 여부
		schedule = new boolean[N];
		overlap = new boolean[N];
		visited = new boolean[N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			//상담일정이 퇴사 이후까지 진행되는 경우
			if(i+T-1 >= N) {
				for(int j = 0; j<i; j++ ) {
					graph[i][j] = false;	//이전의 어떤 일정과도 겹치지 않기때문에 false로 값을 바꾼다.
					graph[j][i] = false;
				}
				continue;	//일정을 저장할 필요가 없기때문에 continue 로 넘어간다.
			}
			
			//
			for(int j = 1; j<T; j++ ) {
				graph[i][i+j] = true;	//해당 날짜와 일정이 겹치므로 true
				graph[i+j][i] = true;
			}
			jobs[i][0] = T;
			jobs[i][1] = P;
		}
		
		for(int i = 0;i<N;i++) {
			overlap[i] = false;
			for(int j = 0; j<N; j++ ) {
				if(graph[i][j]) {
					overlap[i] = true;
				}
			}
		}
		
		
		sol();
		
		
		
		
		/*
		for(int i = 0;i<N;i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		for(int i = 0;i<N;i++) {
			System.out.println(Arrays.toString(jobs[i]));
		}
		*/
		
	}

}
