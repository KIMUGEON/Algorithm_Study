import java.util.*;
class Solution {
    static class word
    {
        String word; //단어
        int cnt; //몇단계
        
        word(String word, int cnt)
        {
            this.word = word;
            this.cnt = cnt;
        }
    }
    static boolean visited[];
    static boolean check=false;
    static int result=0;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int size = words.length;
        visited = new boolean[size]; //단어 개수만큼 visited생성
        bfs(begin, target, words); // 시작 단어부터 bfs탐색해 target찾기
        if(check==false) //찾지 못했을 경우
            result=0;
        return result;
    }
    
    static void bfs(String begin, String target, String[] words)
    {
        Queue<word> q = new LinkedList<>();
        q.offer(new word(begin,0)); //시작 단어와 0단계 넣고 bfs
        
        while(!q.isEmpty())
        {
            word temp = q.poll();
            String word = temp.word;
            int cnt = temp.cnt;
            if(word.equals(target))
            {
                check=true; //찾은경우 true체크
                result=cnt; //단계 result에 넣기
                return;
            }
            for(int i=0;i<words.length;i++) // 모든 단어 탐색
            {
                if(visited[i]==false) // 아직까지 1개차이가 나지 않았던 단어
                {
                    int dif=0; //차이를 체크하기 위함
                    for(int j=0;j<words[i].length();j++)
                    {
                        if(word.charAt(j)!=words[i].charAt(j))
                            dif++; // 다르면 dif++
                    }
                    if(dif==1) //하나만 다를경우 큐에 cnt+1해서 넣어주기
                    {
                        visited[i]=true;
                        q.offer(new word(words[i],cnt+1));
                    }
                }
            }
        }
    }
}
