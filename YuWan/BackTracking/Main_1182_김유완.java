package study_0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_김유완 {
	static int N,S,result;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정수개수
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N]; // 배열을 잘 만들자 
		result = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		check(0,0,0); // 모든 경우의 수 세야함
		System.out.println(result);
	}
	public static void check(int count,int sum,int index) {
		// 끝내는 조건 N개까지 다 뽑았을때 그리고 합이 맞는지 확인해서 개수 세기
		// 길이 양수인 집합 - 처음에 고려안함 문제를 잘읽자
		// index 변수 추가해서 진짜 몇개 뽑았는지 확인
		if(count == N) {
			if(sum == S && index>0) result++;
			return;
		}
		check(count+1,sum+arr[count],index+1); // 뽑는 경우
		check(count+1,sum,index); // 안뽑는 경우
	}
}