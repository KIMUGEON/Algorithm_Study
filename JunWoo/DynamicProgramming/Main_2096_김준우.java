package _0510_Class4_김준우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2096_김준우 {
	static int N;
	static int[][] Num, max, min;
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Num = new int[N][3];
		max = new int[N][3];
		min = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				Num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				//첫번째 줄은 그 줄에 적힌 숫자가 최대값이자 최소값
				if(i == 0) {
					max[i][j] = Num[i][j];
					min[i][j] = Num[i][j];
				}
				else {
					//각 줄의 최대및 최소값은 바로 윗칸과 인접한 칸의 최대 최소값 + 현재 위치의 적힌 값
					int max_val = max[i-1][j];
					int min_val = min[i-1][j];
					for (int k = -1; k <= 1; k+=2) {
						if(j+k <0 || j+k >= 3) continue;
						if(max[i-1][j+k] > max_val) max_val = max[i-1][j+k];
						if(min[i-1][j+k] < min_val) min_val = min[i-1][j+k];
					}
					
					max[i][j] = Num[i][j] + max_val;
					min[i][j] = Num[i][j] + min_val;
				}
			}
		}
		
		int max_val = 0; int min_val = Integer.MAX_VALUE;
		for (int j = 0; j < 3; j++) {
			if(max[N-1][j] > max_val) max_val = max[N-1][j];
			if(min[N-1][j] < min_val) min_val = min[N-1][j];
		}
		System.out.println(max_val + " " + min_val);
		
		
		
	}

}
