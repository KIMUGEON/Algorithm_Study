package _20_분할정복.Silver3;

import java.util.Scanner;
/*
  [입력]
첫째 줄에는 전체 종이의 한 변의 길이 N이 주어져 있다. 
N은 2, 4, 8, 16, 32, 64, 128 중 하나이다. 
색종이의 각 가로줄의 정사각형칸들의 색이 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다. 
하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어지며, 각 숫자 사이에는 빈칸이 하나씩 있다.

  [출력]
첫째 줄에는 잘라진 햐얀색 색종이의 개수를 출력하고, 둘째 줄에는 파란색 색종이의 개수를 출력한다.
 */
public class Main_2630 {//색종이 만들기

	static int N,paper[][],white,blue;
	
	public static void main(String[] args) {
//		===============  입력   ================
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //색종이의 한 변의 길이
		white = 0;
		blue = 0;
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
//		===============  풀이   ================
		paper(0,0,N);	//r, c, N
		
//		===============  출력   ================
		System.out.println(white);
		System.out.println(blue);
	}

//	===================  paper  =====================
	public static void paper(int r, int c, int n) {
		
		//해당영역 색상 확인
		int sum = 0;
		
		for(int i = r; i<r+n; i++) {
			for(int j = c; j<c+n; j++) {
				sum += paper[i][j];
			}
		}
		
		//다 더한값이 종이 크기와 같으면 blue, 0이면 white, 아니면 섞여있음(재귀로 종이 나누기)
		if(sum == n*n) {
			blue++;
		}else if(sum == 0) {
			white++;
		}else { //색상이 섞여있는 경우
			int half = n/2;
			paper(r,c,half);
			paper(r,c+half,half);
			paper(r+half,c,half);
			paper(r+half,c+half,half);
		}
		
	}
	
	

}
