package DFS_BFS;
/*
 * 문제 출처 : 프로그래머스
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43163
 * 걸린 시간 : 30분
*/
class PROGRAMMERS_단어_변환 {
    static String begin, target;
    static String[] words;
    static int N, answer;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE; // 문제의 답 -> 가장 큰 수로 초기화
        this.begin = begin; // 시작 단어
        this.target = target; // 타겟 단어
        this.words = words; // 단어집합
        N = words.length; // 단어집합의 단어 개수
        visited = new boolean[N]; // 단어집합 방문체크 배열
        
        // 단어집합 안에 target 단어가 있는지 체크
        for (int i = 0; i < N; i++) {
        	// target 단어가 있으면 break
            if (words[i].equals(target)) break;
            
            // target 단어가 마지막까지 없으면 0 리턴
            if (i == N-1) return 0;
        }
        
        bfs(begin, 0);
        
        return answer;
    }
    
    // current: 현재 단어 cnt: 현재까지 거쳐온 단계
    private static void bfs(String current, int cnt) {
    	// 현재 단어가 target 단어이면 bfs탐색 종료
        if (current.equals(target)) {
        	// 현재까지 거쳐온 단계가 최소값이면 갱신
            answer = Math.min(answer, cnt);
            return;
        }
        
        // 단어집합을 하나씩 방문하면서 변환가능한지 체크
        for (int i = 0; i < N; i++) {
        	// 아직 방문하지 않은 단어이고 변환가능할 경우
            if (!visited[i] && isConvertible(current, words[i])) {
                visited[i] = true; // 방문체크
                bfs(words[i], cnt+1); // 다음 bfs 탐색으로 이동
                visited[i] = false; // 방문체크 해제
            }
        }
    }
    
    // begin 단어를 target 단어로 변환할 수 있는지 여부를 반환하는 함수
    private static boolean isConvertible(String begin, String target) {
        char[] beginArray = begin.toCharArray(); // begin 단어 char배열로 변환
        char[] targetArray = target.toCharArray(); // target 단어 char배열로 변환
        int cnt = 0; // 두개 단어에서 서로 다른 알파벳 철자 개수
        
        // 단어 처음부터 끝까지 서로 철자가 몇개 다른지 계산
        for (int i = 0; i < beginArray.length; i++) {
            if (beginArray[i] != targetArray[i]) cnt++;
        }
        
        // 철자가 하나만 다르면 true 반환, 그렇지 않으면 false 반환
        return cnt == 1 ? true : false;
    } 
    
}