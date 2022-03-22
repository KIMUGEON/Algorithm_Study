package study_0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_김유완 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		// n은 양수 11보다 작음
		// 1 = 1 (1)
		// 2 = 1+1 / 2 (2) 
		// 3 = 1+2 / 1+1+1 / 2+1 / 3 (4)
		// 4 = 1+3 / 1+1+2 / 1+1+1+1 / 1+2+1 / 2+1+1 / 3+1 / 2+2 (7)
		// 5 = 1,1,1,1,1 / 2,1,1,1(4) / 2,2,1(3) / 2,3(2) / 3,1,1(3) -> (13)
		// 6 = 1,1,1,1,1,1 / 2,1,1,1,1(5) / 2,2,1,1(6) / 2,2,2(1) / 3,3(1) / 2,3,1(6) / 3,1,1,1(4) -> (24)
		int[] count = new int[12];
		count[1] = 1;
		count[2] = 2;
		count[3] = 4;
		for (int i = 4; i < 12; i++) {
			count[i] = count[i-1]+count[i-2]+count[i-3];
		}
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(count[N]).append("\n");
		}
		System.out.print(sb);
	}
}