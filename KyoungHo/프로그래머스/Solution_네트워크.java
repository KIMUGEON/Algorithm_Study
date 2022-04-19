package DFS_BFS;

class Solution_네트워크 {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean visit[] = new boolean[n];
		for(int i=0; i<n; i++) {
			if(visit[i] == false) {
				dfs(i,computers,visit,n);
				answer++;
			}
		}
		
		return answer;
	}

	public void dfs(int idx, int[][] computers, boolean[] visit, int n) {
		visit[idx] = true;
		
		for(int i=0; i<n; i++) {
			if(visit[i] == false && computers[idx][i] ==1) {
				dfs(i,computers,visit,n);
			}
		}
	}
}
