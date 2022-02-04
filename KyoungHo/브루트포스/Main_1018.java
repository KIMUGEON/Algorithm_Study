package case_11.Silver5;

import java.util.Scanner;

public class Main_1018 { //체스판 다시 칠하기

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	
		int M = sc.nextInt();
		String line = "";
		int result;
		int min = 64; //8*8

		char map[][] = new char[N][M];
		for(int i=0; i<N; i++) {	//맵 입력
			line = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
			
			for(int i=0; i<N-7; i++) {
				for(int j=0; j<M-7; j++) {
					int countB = 0;	//[0,0]이 B일 경우
					int countW = 0;	//[0,0]이 W일 경우
					for(int r=i; r<i+8; r++) {
						for(int c=j; c<j+8; c++) {
							if((r+c)%2==0) {
								if(map[r][c]=='B') countW++; // [0,0] 이 B이면 countW 증가, W이면 CountB 증가
								else countB++;
							}else {
								if(map[r][c]=='W') countW++; // [0,0] 이 W이면 countW 증가, B이면 CountB 증가
								else countB++;
							}
						}
					}
					result = Math.min(countB, countW);
					min = Math.min(min, result);
				}
				
			}
			System.out.println(min);
			
			
			
		
	}

}
