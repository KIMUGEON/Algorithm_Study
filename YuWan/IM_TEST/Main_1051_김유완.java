package study_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051_김유완 {
	static int N,M,length,min;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M]; // 전체 사각형
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		// 정사각형의 크기를 아는 것이니까 가로 세로 중 작은 값까지 검사하면 됨
		// 3 5 이면 최대 정사각형이 될수있는 가로 세로 길이가 3이니까
		if(N>=M) min = M;
		else min = N;
		length = Integer.MIN_VALUE;
		check();
		// 어차피 다 정사각형이 안된다면 최대 정사각형의 크기는 1일테니 그 이후부터 검사	
		if(length==Integer.MIN_VALUE) System.out.println(1);
		else System.out.println((length+1)*(length+1));
	}
	public static void check() {
		for (int t = 1; t < min; t++) { // 정사각형 가로세로크기 t
			for (int i = 0; i < N - t; i++) {
				for (int j = 0; j < M - t; j++) {
					// 꼭지점의 좌표 확인하기 같은지
					int a = arr[i][j];
					int b = arr[i][j+t];
					int c = arr[i+t][j];
					int d = arr[i+t][j+t];
					// 같으면 length 가로세로 길이 비교해서 더 큰것 넣어주기
					if(a==b && b==c && c==d && d==a) {
						if(length<t) length = t;
					}
				}
			}
		}
	}
}