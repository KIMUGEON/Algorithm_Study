package study_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_김유완 {
	static int N; // 숫자개수
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] numbers; // 숫자 저장하기
	static int[] op = new int[4]; // +-*/ 개수 저장하기
	static boolean[] is; // 숫자가 사용되었는지 확인
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 수의 개수
		StringTokenizer st;
		numbers = new int[N];
		// 개수만큼 입력된 값 저장하기
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		count(1,numbers[0]);
		System.out.println(max);
		System.out.println(min);
	}
	public static void count(int cnt, int num) {
		if(cnt == N) { // 최대최소값 출력하기
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0;i<4;i++) { // 연산자를 여러 조합으로 확인하기
			// 연산자 있는지 확인하고 각각 계산하기
			if(op[i]>0) {
				op[i]--;
			switch(i) {
				case 0 : count(cnt+1,num+numbers[cnt]);
					break;
				case 1 : count(cnt+1,num-numbers[cnt]);
					break;
				case 2 : count(cnt+1,num*numbers[cnt]);
					break;
				case 3 : count(cnt+1,num/numbers[cnt]);
					break;
				}
			op[i]++;
			}
		}
	}
}