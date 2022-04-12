package _0412_DFSBFS;

public class Solution_network_김준우 {
	
	public static void dfs(int node, int[][] computers, boolean[] visited) {
		visited[node] = true;
		
		int len = computers[node].length;
		for(int i = 0; i<len; i++) {
            if(node == i) continue;
			if(computers[node][i] == 0) continue;
			if(visited[i]) continue;
			dfs(i, computers, visited);
		}
		
	}
	
	public static int solution(int n, int[][] computers) {
        boolean visited[] = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i<n; i++) {
        	if(visited[i])continue;
        	dfs(i, computers, visited);
        	answer++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		//*
		int n = 4;
		int[][] computers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
		//*/
		
		System.out.println(solution(n, computers));
	}
}
