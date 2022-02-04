package Brute_Force;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1436
 * 걸린 시간 : 30분
 * 느낀 점 : 처음엔 666이 연속으로 있어야 한다는줄 모르고 풀었다가 이상함을 발견했다.. 문제를 잘 읽어야할듯!!
 * 오류를 발견한 뒤에는 연속된 문자열이 있는지 확인하는 contains를 써서 간단하게 풀었다.
 */
public class BOJ_1436_영화감독_숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 666; // 결과값 (N이 1이면 답은 666이므로 666으로 초기화)

		// N만큼 탐색
		for (int i = 1; i < N; i++) {
			int title = result; // 탐색을 시작해야하는 초기값을 title로 초기화

			while (true) { // 연속된 666 문자열이 포함된 num을 찾을때까지 탐색값을 +1 하며 반복
				String num = Integer.toString(++title);
				if (num.contains("666")) {
					result = title;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
