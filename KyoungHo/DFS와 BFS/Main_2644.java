package etc.DFS와_BFS.Silver2;

import java.util.Scanner;
/*
  [입력]
사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 
입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 
둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 
그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 
넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 
이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
각 사람의 부모는 최대 한 명만 주어진다.

[출력]
입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 
어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 이때에는 -1을 출력해야 한다.
 */
public class Main_2644 { //촌수계산
	
	static int n, ans, x, y, m, arr[][];
	static boolean visited[];
	
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //전체 사람 수
		arr = new int[n+1][n+1]; //인접행렬 0 사용안함
		x = sc.nextInt(); //서로다른
		y = sc.nextInt(); //두사람의 번호
		m = sc.nextInt(); //관계 개수
		
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();//부모
			int b = sc.nextInt();//자식
			
			arr[a][b] = arr[b][a] = 1; //부모 자식관계는 1로 표시
		}
		ans=-1; //촌수 없으면 -1
		dfs(y,0); //dfs로 탐색 시작
		
		System.out.println(ans);
	}

	private static void dfs(int a, int d) {
		visited[a] = true;
		
		if(a==x) {
			ans=d;
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(arr[a][i] == 1 && !visited[i]) {
				dfs(i, d+1);
			}
		}
	}

}
