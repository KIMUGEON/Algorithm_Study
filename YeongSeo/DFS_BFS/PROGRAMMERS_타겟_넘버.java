package DFS_BFS;
/*
 * 문제 출처 : 프로그래머스
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43165
 * 걸린 시간 : 20분
*/
class PROGRAMMERS_타겟_넘버 {
    static boolean[] isPlus;
    static int[] numbers;
    static int N, answer, target;
    
    public int solution(int[] numbers, int target) {
        answer = 0; // 문제의 답
        this.numbers = numbers; // 주어지는 숫자
        this.target = target; // 타겟 넘버
        N = numbers.length; // 주어지는 숫자의 개수
        isPlus = new boolean[N]; // 더하기 연산을 수행할 숫자를 체크할 배열
        
        subset(0);
        
        return answer;
    }
    
    // isPlus 배열을 true, false하는 부분집합을 구할 함수
    private static void subset(int cnt) {
        if(cnt == N) {
        	// N개를 모두 고려했으면 계산하러 가기
            calculate();
            return;
        }
        
        isPlus[cnt] = true;
        subset(cnt+1);
        
        isPlus[cnt] = false;
        subset(cnt+1);
    }
    
     private static void calculate() {
         int result = 0; // 연산 결과
         
         for (int i = 0; i < N; i++) {
        	 // isPlus가 true이면 더하기 연산 수행
             if(isPlus[i]) {
                 result += numbers[i];
             }
             // isPlus가 false이면 더하기 연산 수행
             else {
                 result -= numbers[i];
             }
         }
         
         // 연산 결과가 타겟 넘버와 같으면 문제의 답 1 증가
         if (result == target) answer++;
     }
}
