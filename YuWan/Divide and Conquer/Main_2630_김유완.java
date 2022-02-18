package study_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_김유완 {
	static int N,zeroCount,oneCount;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 한변 길이
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) { // 입력받아오기
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0,0 부터 확인하기
		quadTree(0,0,N);
		System.out.println(zeroCount);
		System.out.println(oneCount);
	}
	// 돌면서 확인
	public static void quadTree(int row,int column, int n) {
		if(is(row,column,n)==false) { // 다시 또 나눠야함
			n = n/2;
			// 4분면으로 나눠서 확인
			quadTree(row,column,n);
			quadTree(row,column+n,n);
			quadTree(row+n,column,n);
			quadTree(row+n,column+n,n);
		}
	}
	public static boolean is(int x,int y,int num) {
		int temp = arr[x][y]; // 처음값이랑 비교
		for(int i=x;i<x+num;i++) {
			for(int j=y;j<y+num;j++) {
				if(arr[i][j]!=temp) return false;
			}
		}
		// 어차피 여기 다 돌아서 나왔다?
		// 한묶음이라는거고 즉 색종이 한장이라는 거
		if(temp == 1) oneCount++; // 1일때
		else zeroCount++;
		return true;
	}
}