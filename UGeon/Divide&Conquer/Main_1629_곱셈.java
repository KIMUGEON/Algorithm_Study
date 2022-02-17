import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 출처 : 백준 알고리즘
 * 번호 : 1629번  
 * 제목 : 곱셈
 * 
 * 자연수  A를 B번 반복하여 곱하면 그 수가 큰 경우에는 감당할 수 없으므로
 * 수학적 공식을 사용하여 계산 과정을 줄인다
 * {(axb) mod c}는 {(a mod c)(b mod c) mod c}와 같다는 공식을 사용하여 문제를 푼다
 */


public class Main_1629_곱셈 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		long A = Integer.parseInt(st.nextToken()); // 자연수 A(밑)
		long B = Integer.parseInt(st.nextToken()); // 자연수 A를 곱하려는 횟수(지수)
		long C = Integer.parseInt(st.nextToken()); // 거듭제곱한 결과값을 나누려는 수
		
		System.out.println(getExtra(A, B, C)); // 결과 구하여 출력
		
		
	}
	
	public static long getExtra(long A, long B, long C) {
		if(B==1) // 지수가 1이면
			return A % C; // A mod C
		
		long half = getExtra(A, B/2, C); // 밑^(지수/2)로 나눠서 구하기
		
		if(B%2==0) // 지수가 짝수이면
			return half * half % C; // (A mod C)*(A mod C) mod C;
		else // 지수가 홀수이면
			return (half * half % C) * A % C; // ((A mod C)*(A mod C) mod C) * A mod C;
	}
}
