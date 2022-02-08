package case_14.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 { //연산자 끼워넣기
	public static int N;		//수의 개수
	public static int arr[];	//수 개수 배열
	public static int oper[];	//연산자 개수 배열
	public static int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N  = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr = new int[N];
		oper = new int[4];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr[0],1);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	public static void dfs(int number, int idx) { //idx = 1부터, 0은 number라서
		if(idx == N) {
			MAX = Math.max(MAX, number);
			MIN = Math.min(MIN, number);
			return;
		}
		for(int i=0; i<4; i++) {
			if(oper[i]>0) { //연산자 수가 1 이상일 경우
				oper[i]--;
				if(i==0) {	//더하기
					dfs(number + arr[idx], idx+1);
				}else if(i==1) {//빼기
					dfs(number - arr[idx], idx+1);
				}else if(i==2) {//곱하기
					dfs(number * arr[idx], idx+1);
				}else if(i==3) {//나누기
					dfs(number / arr[idx], idx+1);
				}
				oper[i]++;
			}
		}
	}

}
