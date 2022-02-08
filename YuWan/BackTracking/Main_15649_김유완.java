package study_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_김유완 {
	static int[] numbers; // 뽑은 수 저장
	static int N,M;
	static boolean[] is; // 중복수 확인하기
	// sb쓸때 260ms , print쓸때 2140ms
	public static StringBuilder sb = new StringBuilder(); // 문자열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		// N,M 자연수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 몇개만큼 뽑느냐
		numbers = new int[M]; // M개수 만큼 뽑아서 저장할 공간 만들어주기
		is = new boolean[N]; // 중복 숫자 거르기 위해 N만큼 만들기
		per(0);
		System.out.println(sb);
	}
	
	public static void per(int cnt) {
		// 각각 만족하는 값 출력
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		// 1부터N까지 모든 수를 현재 자리에 넣어보기
		for(int i=0;i<N;i++) {
			if(is[i]) continue;
			numbers[cnt]=i+1;
			is[i] = true; // 사용중임을 나타내기
			per(cnt+1);
			is[i] = false;
		}
	}
}
