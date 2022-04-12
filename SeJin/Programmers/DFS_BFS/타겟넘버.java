class Solution {
    static int result=0;
    static void dfs(int[] numbers, int target, int cnt, int temp)
    {
        if(cnt==numbers.length)
        {
            if(temp == target)
                result++;
            return;
        }
        
        dfs(numbers, target, cnt+1, temp+numbers[cnt]);
        dfs(numbers, target, cnt+1, temp-numbers[cnt]);
        
        
        
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers,target,0,0);
        
        return result;
    }
}
