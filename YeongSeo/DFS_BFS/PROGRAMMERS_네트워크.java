package DFS_BFS;

import java.util.*;
/*
 * 문제 출처 : 프로그래머스
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43162
 * 걸린 시간 : 30분
*/
class PROGRAMMERS_네트워크 {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        answer = bfs(n, computers);
        
        return answer;
    }
    
    // 네트워크 개수를 bfs로 탐색하여 반환하는 함수
    private static int bfs(int n, int[][] computers) {
        int cnt = 0; // 네트워크의 수
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n]; // 컴퓨터 방문 체크 배열
        
        // 각 컴퓨터 정점을 시작으로 bfs탐색 실행
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue; // 이미 방문한 컴퓨터이면 pass
            
            // 방문체크 및 queue에 넣기
            visited[i] = true;
            queue.offer(i);
            
            while(!queue.isEmpty()) {
                int current = queue.poll();
                
                // 현재 컴퓨터 정점과 이어진 컴퓨터 탐색
                for (int j = 0; j < n; j++) {
                	// 방문하지 않은 컴퓨터 정점이고, 이어져 있을 경우
                    if(!visited[j] && computers[current][j] == 1) {
                    	// 방문체크하고 queue에 넣기
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
            
            // 네트워크 수 1 증가
            cnt++;
        }

        return cnt;
    }
}