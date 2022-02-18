package study_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_김유완 {
	// 근데 시간 너무 많이 걸림 1020ms 더 좋은 방법있나..?
	static int N,zeroCount,oneCount,minusCount;
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
		check(0,0,N);
		System.out.println(minusCount);
		System.out.println(zeroCount);
		System.out.println(oneCount);
	}
	public static void check(int row,int column,int n) {
		if(!is(row,column,n)) { // 값이 다 같지 않다? 또 나누기
			// 9분할
			check(row,column,n/3);
			check(row,column+n/3,n/3);
			check(row,column+(2*n)/3,n/3);
			check(row+n/3,column,n/3);
			check(row+n/3,column+n/3,n/3);
			check(row+n/3,column+(2*n)/3,n/3);
			check(row+(2*n)/3,column,n/3);
			check(row+(2*n)/3,column+n/3,n/3);
			check(row+(2*n)/3,column+(2*n)/3,n/3);
		}
	}
	// 압축, 색종이 처럼 안에 내용들이 다 같은 값이 맞는지 확인하기
	public static boolean is(int x,int y,int num) {
		int temp = arr[x][y]; // 처음값이랑 비교
		for(int i=x;i<x+num;i++) {
			for(int j=y;j<y+num;j++) {
				if(arr[i][j]!=temp) return false;
			}
		}
		if(temp == -1) minusCount++;
		else if(temp == 0) zeroCount++;
		else oneCount++;
		return true;
	}
}