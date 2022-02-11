package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/13305
 * 걸린 시간 : 40분
 * 리뷰 : 최대한 주유 가격이 가장 작은 도시에서 주유할 수 있도록 알고리즘을 설계하는 것이 핵심이었던 문제였다.
 * 입력값의 범위가 커 최대한 O(n)을 만족하도록 현재 도시의 위치를 저장하는 location 변수를 썼다.
 * 하지만 계속 부분점수 58점만 나오고 만점이 나오지 않아 여러 시도를 해보았는데,
 * 입력 제약조건을 보니 도시간의 거리와 주유 가격이 1 이상 1억 이하의 자연수라는 것을 간과하였다.
 * int의 범위는 약 2억까지니 범위 초과 가능성이 있어 int 변수를 long으로 바꿔주었더니 해결할 수 있었다.
 * 입력 조건의 범위도 정말 중요함을 느꼈다.
 */
public class BOJ_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		int[] road = new int[N-1]; // 도로의 길이를 저장하는 배열
		int[] oil = new int[N]; // 주유소의 리터당 가격을 저장하는 배열
		long res = 0L; // 결과값 -> 거리와 가격이 1억 이하 자연수 이므로 int는 범위 초과 가능성 있음
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N-1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0L; // 도시 간의 거리의 합 -> 범위 초과 가능성이 있으므로 long으로 선언
		int location = 0; // 현재 위치한 도시의 인덱스
		
		for(int i=0; i<N-1; i++) {
			if(oil[location] >= oil[i+1]) { 
				// 현재 위치의 주유 가격이 다음 도시의 주유 가격보다 크거나 같으면 
				// 현재 위치에서 주유하고 다음 도시로 감
				sum += road[i];
				res += (long) (sum * oil[location]); // 도시 간의 거리합 * 현재 위치한 도시의 주유 가격
				sum = 0; // 도시 간의 거리합 0으로 초기화
				location = i+1; // 현재 위치한 도시를 다음 도시로 바꿈
			}
			else if(oil[location] < oil[i+1]) {
				// 현재 위치의 주유 가격이 다음 도시의 주유 가격보다 작으면
				// 다음 도시에서 주유하지 않고 현재 위치에서 계속 대기
				sum += road[i]; // 다음 도시까지의 거리는 도시 간의 거리에 합해줌
				if(i == N-2) { 
					// i가 N-2이면 무조건 다음 도시는 마지막 도시이므로 현재 위치에서 바로 주유 
					res += (long) (sum * oil[location]);
				}
			}
		}
		
		System.out.println(res);

	}

}
