package Greedy;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/12927
 * 걸린 시간 : 30분
 */
public class BOJ_12927_배수_스위치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next(); // 입력받은 문자열
		int N = input.length(); // 전구의 개수
		boolean[] bulb = new boolean[N+1]; // 전구의 상태를 저장하는 배열
		boolean[] allOff = new boolean[N+1]; // 전부 꺼져있는 전구를 나타내는 배열
		int cnt = 0; // 스위치를 누른 횟수 (결과값)
		
		// 전구 상태 boolean 배열로 저장
		for (int i = 1; i <= N; i++) {
			if(input.charAt(i-1) == 'Y') bulb[i] = true; // Y이면 true로 저장
			else bulb[i] = false; // N이면 false로 저장
		}
		
		// 1번 전구부터 차례대로 켜져있으면 스위치 누르기
		for (int i = 1; i <= N; i++) {
			if(!bulb[i]) continue; // i번째 전구 꺼져있으면 pass
			
			int j = i; // i번째 전구의 배수를 저장할 변수
			cnt++; // 스위치 누른 횟수 1 증가
			
			while(j <= N) {
				bulb[j] = !bulb[j]; // 전구 상태 반전
				j += i; // 배수만큼 다음 전구로 이동
			}
		}
		
		if(Arrays.equals(bulb, allOff)) System.out.println(cnt); // 전구가 전부 꺼져 있으면 스위치 누른 횟수 출력
		else System.out.println(-1); // 모든 전구를 끄지 못했으면 -1 출력
	}

}
