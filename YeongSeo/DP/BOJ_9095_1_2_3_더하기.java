package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/9095
 * 걸린 시간 : 30분
 * 리뷰 : 점화식을 f(n) = f(n-3) + f(n-2) + f(n-1) 로 세워서 dp 개념을 적용해서 풀었다.
 * 처음엔 만약 n이 10일 경우 f(9)+1, f(8)+2, f(7)+3 을 각각 자리를 바꿔줘서,
 * 1+f(9), 2+f(8), 3+f(7) 인 경우의 수도 더해줘야 하는게 아닌가 생각했지만 저렇게 하면 결국
 * 방법들이 전부 중복된다는걸 깨달았다. 쉽게 생각해도 되는걸 너무 어렵게 생각했던것 같다.
*/
public class BOJ_9095_1_2_3_더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[] memory = new int[11];
			
			memory[1] = 1;
			memory[2] = 2;
			memory[3] = 4;
			
			for (int i = 4; i <= n; i++) {
				memory[i] = memory[i-1] + memory[i-2] + memory[i-3];
			}
			
			System.out.println(memory[n]);
		}
		
	}

}
