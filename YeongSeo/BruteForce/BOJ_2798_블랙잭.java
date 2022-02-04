package Brute_Force;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2798
 * 걸린 시간 : 15분
 * 느낀 점 : 생성자가 되는 조건을 생각하는게 약간 시간이 걸렸다.
*/
public class BOJ_2798_블랙잭 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //카드의 개수
		int M = sc.nextInt(); //카드 합
		
		int[] cards = new int[N];
		
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		int max = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					int sum = cards[i]+cards[j]+cards[k];
					if(sum > max && sum <= M)
						max = sum;
				}
			}
		}
		System.out.println(max);
	}

}
