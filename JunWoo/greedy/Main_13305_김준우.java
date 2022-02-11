//부분점수 17점

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_13305_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());//도시의 개수
		long[] price = new long[N];	//각 도시의 주유소별 리터당 가격
		long[] dist = new long[N-1];	//해당 인덱스 도시~ 다음 도시까지의 거리
		boolean[] expensive = new boolean[N-1];	//해당 인덱스 이전에 더 저렴한 주유소가 있으면 true
		long cost = 0;	//출력할 최소비용. 
		long rest_dist = 0;		//목적지 혹은 다음 주유할 주유소까지 남은 거리
		
		//=========가격과 거리 입력 받기=====================
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N-1;i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		//======마지막 주유소와 첫번째 주유소를 제외하고 탐색==========================
		for(int i = N-2;i>0;i--) {	
			long cur_price = price[i];	//현재 주유소 가격
			boolean fill = false;
			rest_dist += dist[i];		//목적지 혹은 다음 주유할 주유소까지 남은 거리
			
			if(!expensive[i]) {
				for(int j = i-1;j>=0;j--) {
					long ex_price = price[i-1];	//이전 주유소 가격
					if(cur_price < ex_price) {
						expensive[j] = true;
						fill = true;
					}
					else {
						break;
					}
				}
				
				if(fill) {		//이전 주유소 보다 현재 주유소가 싼 경우에만 주유
					cost += rest_dist * cur_price;	//(남은 거리*주유소가격) 만큼 증가
					rest_dist = 0; 	//여기서 주유했으므로 남은 거리 초기화
				}
			}
		}
		
		//======첫번째 주유소에서 주유하기=============
		rest_dist += dist[0];		//목적지 혹은 다음 주유할 주유소까지 남은 거리
		cost += rest_dist * price[0]; //남은거리 만큼 주유
		
		System.out.println(cost);
	}
}
