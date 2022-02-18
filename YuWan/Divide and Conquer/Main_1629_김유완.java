package study_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629_김유완 {
	static long A,B,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		// 나눠 보니까 0이 나오면 무조건 계산안해봐도 0
		// pow(대상 숫자,지수) double형태이다 -> 거듭제곱 구하는것
		System.out.println(pow(A,B,C));
	}
	public static long pow(long a,long b,long c) {
		// A를 C로 나눈 나머지
		// 지수가 홀수 짝수 구분하기
		// 10 2 4 이면 10%4=2 (2*2)%4=0 (10*10)%4=0
		if(b==0) return 1L; // 나누는게 0
		else if(b==1) return a%c; // 끝났다는것
		else if(b%2==0) { // 나누는거 짝수 ? 반틈만 해주면 됨
			long temp = pow(a,b/2,c); // 나눌 수 있으니까
			return (temp*temp)%c;
		}
		else { // 지수 홀수
			long temp = pow(a,b/2,c); // 나눌 수 있으니까
			long temp2 =  pow(a,b/2+1,c);
			return (temp*temp2)%c;
		}
	}
}