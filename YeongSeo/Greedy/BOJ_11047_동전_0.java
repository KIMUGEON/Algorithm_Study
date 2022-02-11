package Greedy;

import java.util.Scanner;
import java.util.Stack;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/11047
 * 걸린 시간 : 15분
 * 리뷰 : 그리디 알고리즘 중에서 가장 대표적인 동전 문제를 이미 풀어본 적이 있어서 금방 아이디어를 떠올릴 수 있었다.
 * 가장 큰 액수부터 먼저 몫을 구해주어야 하지만 입력은 오름차순으로 받기 때문에,
 * 후입선출인 스택을 이용해 입력을 받는 방식을 썼다.  
 */
public class BOJ_11047_동전_0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전 종류의 개수
		int K = sc.nextInt(); // 만들어야 하는 액수(K원)
		Stack<Integer> stack = new Stack<>(); // 동전 가치 저장하는 스택
		int cnt = 0; // 필요한 동전 개수
		
		for(int i=0; i<N; i++) {
			stack.push(sc.nextInt());
		}
		
		// 입력(스택)이 빌 때까지 반복
		while(!stack.isEmpty()) {
			int coin = stack.pop(); // 후입선출로 가장 큰 액수부터 pop
			if(K/coin > 0) { 
				// K를 동전 액수로 나눈 몫이 0보다 크면 몫만큼 동전 개수 카운트
				cnt += K/coin;
				// K를 업데이트
				K = K%coin;
			}
			if(K == 0) break; // K가 0이면 액수를 모두 계산하였으므로 break
		}
			
		System.out.println(cnt);
		
	}

}
