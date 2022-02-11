package Greedy;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/11399
 * 걸린 시간 : 10분
 * 리뷰 : 인출 시간을 기준으로 오름차순 정렬한 뒤, 각 사람이 인출하기까지 걸린 시간(sum)과
 * 그 시간을 전부 더한 결과값(res) 변수를 두개 선언한 뒤 누적하면 되는 간단한 문제였다.
 */
public class BOJ_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람의 수
		int[] time = new int[N]; // 인출시간
		
		// 입력
		for(int i=0; i<N; i++) {
			time[i] = sc.nextInt(); // 인출 시간 저장
		}
		
		// 오름차순 정렬
		Arrays.sort(time);
		
		int sum = 0; // 각 사람이 기다린 시간 + 인출 시간
		int res = 0; // 결과값
		
		for(int i=0; i<N; i++) {
			sum += time[i];
			res += sum;
		}
		
		System.out.println(res);

	}

}
