package Brute_Force;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2231
 * 걸린 시간 : 30분
 * 느낀 점 : 생성자가 되는 조건을 생각하는게 약간 시간이 걸렸다.
 * 그리고 String, char[], int 변환이 자유자재로 되야하는데 익숙하지 않아서 이것도 좀 시간이 걸렸다.
 */
public class BOJ_2231_분해합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] nums = sc.next().toCharArray();
		int N = Integer.parseInt(String.valueOf(nums));
		int sum = 0; // 각 자리 수 더해서 저장하는 변수
		int result = 0; // 생성자 (0으로 초기화해서 생성자 없을 경우 0 프린트)

		// N부터 -1하여 모든 경우의 수를 계산
		for (int n = N - 1; n >= 0; n--) {
			char[] temp = Integer.toString(n).toCharArray();
			sum = 0;
			for (char num : temp)
				sum += num - '0';
			if (sum + n == N) { // 각 자리 수와 n을 더하여 N이 나올 시 n은 생성자
				result = n;
			}
		}
		System.out.println(result);
	}
}
