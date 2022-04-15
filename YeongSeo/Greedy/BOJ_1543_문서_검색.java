package String;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1543
 * 걸린 시간 : 10분
 */
public class BOJ_1543_문서_검색 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String doc = sc.nextLine(); // 문서 문자열
		String target = sc.nextLine(); // 타겟 문자열
		int docLen = doc.length(); // 문서의 길이
		int targetLen = target.length(); // 타겟 문자열 길이
		int ans = 0; // 문제의 답
		
		// 문서 문자열 처음부터 끝까지 탐색
		for (int i = 0; i < docLen; i++) {
			// 검색하려는 마지막 위치가 문서의 길이를 넘지 않는지 체크
			// 검색한 문자열이 타겟 문자열과 같은지 체크
			if (i+targetLen <= docLen &&
					doc.substring(i, i+targetLen).equals(target)) {
				ans++; // 문제의 답 1 증가
				i = i+targetLen-1; // 검색 시작 위치를 현재 검색한 문자열의 마지막 위치로 변경
			}
		}

		// 결과 출력
		System.out.println(ans);
	}

}
