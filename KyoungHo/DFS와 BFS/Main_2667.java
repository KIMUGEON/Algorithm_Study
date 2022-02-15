package Silver1;

import java.util.Arrays;
import java.util.Scanner;
/*
  [입력]
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 
그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

  [출력]
첫 번째 줄에는 총 단지수를 출력하시오. 
그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 */
public class Main_2667 {//단지번호붙이기

	static int N,map[][],count;
	static boolean visit[][];
	static int deltas[][] = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //지도 크기
		map = new int[N][N]; //지도 배열
		String line = ""; 
		visit = new boolean[N][N]; //방문체크
		count = 1;
		for(int i=0; i<N; i++) {
			line = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) { //단지 발견하고 방문 안한경우
					dfs(i,j);
					count++; //단지에 번호 매기기
				}
			}
		}
		
		System.out.println(count-1); //총 단지 수
		
		int result[] = new int[count]; //결과배열 크기 => 총 단지 수 크기
		for(int i=0; i<N; i++) {//맵 탐색하면서 0이 아닌경우 단지 번호 별로 ++해줌
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0) {
					result[map[i][j]]++;
				}
			}
		}
		
		Arrays.sort(result);
		for(int i=1; i<result.length; i++) { //0은 사용 안했음
			System.out.println(result[i]);
		}
	} 
	
	public static void dfs(int i, int j) {
		visit[i][j] = true; //방문 체크하고
		map[i][j] = count; //단지에 번호 매기기
		
		for (int d = 0; d < 4; d++) {
			int dx = i+deltas[d][0];
			int dy = j+deltas[d][1];
			
			if(dx>=0 && dx<N && dy>=0 && dy<N) {				
				if (map[dx][dy] == 1 && !visit[dx][dy]) {
					dfs(dx,dy);
				}
			}
		}
	}

}
