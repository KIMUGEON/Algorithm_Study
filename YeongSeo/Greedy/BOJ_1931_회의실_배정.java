package Greedy;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1541
 * 걸린 시간 : 70분
 * 리뷰 : 처음에는 회의시작 시간을 기준으로 오름차순 정렬하여
 * 회의시간이 짧은 순서대로 회의 시간이 겹치지 않게 가능한 것끼리 뽑으면 된다고 생각했다.
 * 하지만 그러기엔 예외와 반례가 너무 많고, 겹치는 회의시간을 계속 제외시키는 시간복잡도도 너무 컸다.
 * 결국 다른 사람의 풀이를 참고하여 힌트를 얻었고, 
 * '서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다'는
 * 힌트를 얻어 종료시간을 기준으로 정렬하여 풀었다.
 * 그리디 알고리즘은 현재 상황에서 가장 좋은 것을 고를 기준을 생각하는 것이 제일 중요한 것 같다.
 */
public class BOJ_1931_회의실_배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 회의 수
		int[][] meeting = new int[N][2];
		
		for(int i=0; i<N; i++) {
			meeting[i][0] = sc.nextInt(); // 시작 시간
			meeting[i][1] = sc.nextInt(); // 종료 시간
		}
		
		// 종료 시간을 기준으로 오름차순 정렬
		Arrays.sort(meeting, (o1, o2) -> { 
			if(o1[1] == o2[1]) { // 종료 시간이 같으면 시작 시간이 작은 순서대로 정렬
				return Integer.compare(o1[0],o2[0]);
			}
			else { 
				return Integer.compare(o1[1],o2[1]); 
			} 
		});
		
		int endTime = 0; // 이전에 진행했던 회의의 종료시간
		int cnt = 0; // 결과값
		
		for(int i=0; i<N; i++) {
			if(meeting[i][0] >= endTime) {
				endTime = meeting[i][1] ;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
