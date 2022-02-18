package _20_분할정복.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [입력]
첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.

  [출력]
첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
 */
public class Main_1629 {//곱셈

	static long A,B,C;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		===============================  입력   ======================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
//		===============================  풀이 & 출력   ======================================
		System.out.println(exp(A,B));
		
		
	}

//	==================  exp  ==================
	public static long exp(long a, long b) {
		if(b == 1) return a%C;
		
		long d = exp(a, b/2);
		
		//모듈러 합동 공식 : (a*b)%c = (a % C * b % C) % C
		return (b%2 == 0) ? d * d % C : (d * d % C) * a % C;
	}
}
