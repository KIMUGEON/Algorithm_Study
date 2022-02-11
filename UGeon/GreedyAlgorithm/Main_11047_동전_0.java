import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.xml.sax.InputSource;

/* 출처 : 백준 알고리즘
 * 번호 : 11047번  
 * 제목 : 동전 0
 * 
 * K원을 만드는데 필요한 최소 동전 개수를 구하는 문제이므로
 * 배열에 저장된 가장 가치가 높은 동전으로 K원을 넘지않는 최소 필요 개수를 구하고
 * 그 다음으로 가치가 높은 동전으로 남은 금액을 넘지않는 최소 필요 개수를 구하여
 * 최종적으로 K원을 만들떄까지 배열을 탐색하며 위와 같은 방법 반복
 */

public class Main_11047_동전_0 {

	static int N,K,Cnt, Sum;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 동전의 종류 개수
		K = Integer.parseInt(st.nextToken()); // 만들려는 가치의 합
		arr = new int[N]; // 동전 종류 정보 저장 배열
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Cnt =0; // 필요한 최소 동전 개수
		Sum=0; // 
		for(int i=N-1;i>-1;i--) {
			
			int cnt=1;
			while(Sum+arr[i]<=K) { // 해당 가치의 동전으로 K-Sum 금액을 넘지 않을 때까지 반복
				Sum+=arr[i]*cnt;
				Cnt++;
		    }
			if(Sum==K) // K원을 만드는데 성공했으면 for문 탈출
				break;
		}
		
		System.out.println(Cnt); // 출력

	}
	
}