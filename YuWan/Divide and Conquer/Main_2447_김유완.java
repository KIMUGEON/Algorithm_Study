package study_0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2447_김유완 {
	static int N;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 한변 길이 
		arr = new char[N][N];
		// 다 빈칸으로 채우기
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], ' ');
		}
		check(0,0,N);
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	public static void check(int r,int c,int num) {
		int n = num/3;
		if(num == 1) {
			arr[r][c] = '*';
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i != 1 || j != 1) { // 가운데 부분만 제외해야하니까
					// 새로운 네모의 시작점
					check(i*n+r,j*n+c,n);
				}
			}
		}
		
	}
}