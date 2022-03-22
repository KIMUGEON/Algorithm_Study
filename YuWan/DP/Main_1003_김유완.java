package study_0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_김유완 {
		public static void main(String[] args) throws NumberFormatException, IOException {
		// 2이면 1+0이니까 1 1번 0 1번
		// 3이면 2+1=1+0+1 이니까 1 2번 0 1번
		// N은 40보다 작거나 같은 자연수 또는 0
		// 호출 수
		// 숫자N	0호출   1호출
		//  0	 1     0
		//  1    0     1
		//  2    1     1
		//  3    1     2
		//  4    2     3
		//  5    3     5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케 수
		int[] zero = new int[41]; // 0호출 수
		int[] one = new int[41]; // 1호출 수
		zero[1] = one[0] = 0;
		zero[0] = one[1] = 1;
		for (int i = 2; i < 41; i++) {
			zero[i] = zero[i-1] + zero[i-2];
			one[i] = one[i-1] + one[i-2];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine()); // 주어지는 값		
			// 주어진값에서 부터 내려가면서 값이 체크되어있는지 확인하기
			sb.append(zero[N]).append(" ").append(one[N]).append("\n");
		}
		System.out.print(sb);
	}
	
}
