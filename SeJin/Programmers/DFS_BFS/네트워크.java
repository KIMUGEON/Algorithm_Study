import java.util.*;

class Solution {
    static boolean visited[];
    static int answer=0;
    static int N;
    public int solution(int n, int[][] computers) {
        //다 연결되어 있지 않을경우 check
        boolean check=false;
        visited = new boolean[n];
        N=n;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                if(visited[i]==false && i!=j)
                {
                    //연결된 컴퓨터가 있을경우 check true
                    check=true;
                    //현재 컴퓨터 탐색했다고 표시
                    visited[i]=true;
                    //현재 컴퓨터와 연결되어 있는 컴퓨터 모두 탐색dfs
                    dfs(i,computers);
                    //현재 컴퓨터와 연결된 네트워크 개수 추가
                    answer++;
                }
        }
        if(check==false)
            answer=n;
        return answer;
    }
    
    static void dfs(int start, int computers[][])
    {
        for(int i=0;i<N;i++)
        {
            //현재 컴퓨터와 같은 i 건너뛰기
            if(start==i) continue;
            
            //현재 컴퓨터와 연결되어 있으면서 한번도 탐색하지 않은 컴퓨터 dfs
            if(computers[start][i] == 1 && visited[i]==false)
            {
                //새로운 컴퓨터 탐색했다고 체크
                visited[i]=true;
                dfs(i,computers);
            }
        }
    }
    
}
