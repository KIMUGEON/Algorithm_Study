package _0412_DFSBFS;


public class Solution_targetnumber_김준우 {
	static int answer = 0;
			
	public static void dfs(int[] numbers, int sum, int cnt, int target) {
		if(cnt == numbers.length) {
			if(sum != target) return;
			answer++;//System.out.println(sum);
			return;
		}
		dfs(numbers, sum+numbers[cnt], cnt+1, target);
		dfs(numbers, sum-numbers[cnt], cnt+1, target);
		return;
	}
	
    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0,0, target);
        
        return answer;
    }
	
	public static void main(String[] args) {
		//*
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		//*/
		/*
		int[] numbers = {4,1,2,1};
		int target = 4;
		/*/
		
		System.out.println(solution(numbers, target));
		
		return;
	}

}
