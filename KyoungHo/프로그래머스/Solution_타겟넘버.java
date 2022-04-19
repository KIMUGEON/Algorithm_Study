package DFS_BFS;

class Solution_타겟넘버 {
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers,target,0,0);
        answer = cnt;
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int idx, int sum){ //idx : 인덱스, sum : 인덱스까지 결과값 합
        if(idx == numbers.length){ //탐색 완료
            if(sum==target){
                cnt++;
            }
            return;
        }
        
        dfs(numbers, target, idx+1, sum+numbers[idx]); //더하기
        dfs(numbers, target, idx+1, sum-numbers[idx]); //빼기
        
    }
}