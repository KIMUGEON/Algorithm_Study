package study_0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_김유완 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 동전의 종류수
		int K = Integer.parseInt(st.nextToken()); // 동전의 합
		int result = 0; // 결과최소값
		int[] coin = new int[N]; // 동전의 종류마다 얼마짜리인지 넣는 배열
		int[] count = new int[N]; // 각각의 동전 종류마다의 개수를 넣을 배열
		for(int i=0;i<N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		// 동전 개수가 최소이려면  가격 높은 동전이 우선시
		// 가격 높은 동전 개수를 가격내에서 최대로 
		for(int i=N-1;i>=0;i--) {
			if(K==0) break;
			else {
				count[i] = K/coin[i];
				K = K - count[i]*coin[i];
			}
		}
		for(int i=0;i<N;i++) {
			result += count[i];
		}
		System.out.print(result);
	}
}