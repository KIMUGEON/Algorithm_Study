package Silver3;

import java.util.Scanner;
/*
  [입력]
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
 */
public class Main_2606 {//바이러스, 1260 dfs와 풀이 비슷

	static int N,M,link[][],count;
	static boolean visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //컴퓨터의 수
		M = sc.nextInt(); //연결된 컴퓨터 수
		link = new int [N+1][N+1]; //연결된 컴퓨터 배열(0 사용 안함)
		visit = new boolean[N+1]; //방문체크
		
		for(int i=0; i<M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			link[r][c] = 1;
			link[c][r] = 1;
		}
		count = 0;
		dfs(1);
		System.out.println(count);
	}
	
	public static int dfs(int idx) {
		visit[idx] = true;
		
		for(int i=1; i<=N; i++) {
			if(link[idx][i] == 1 && !visit[i]) {
				count++;
				dfs(i);
			}
		}
		return count;
	}

}
