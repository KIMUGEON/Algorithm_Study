package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1446
 * 걸린 시간 : 180분
 * 리뷰 : 처음에는 DP로 접근해보려했지만 2시간 걸리고 답지를 봤는데도 도저히 이해가 안가서 DP로 푸는 방법은 포기했다..
 * DP 개념을 배울 때까지는 자중해야겠다는 생각이 들었다.. 그리고 다익스트라로 다시 풀어봤는데,
 * 최소거리 배열을 만들어둔 뒤, 최소거리가 갱신될 때마다 그 위치를 기준으로 다음 위치들의 최소거리를 전부 갱신해주는 방법으로
 * 간단하게 풀 수 있었다. 다음엔 꼭 DP로 다시 풀어봐야겠다.
*/
public class BOJ_1446_지름길 {
	public static class Road implements Comparable<Road>{ // 지름길 객체
		int from, to, distance; // 시작 위치, 도착 위치, 지름길의 길이

		public Road(int from, int to, int distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Road o) {
			// from과 to 둘 다 같으면 distance 오름차순, to는 다르면 to 오름차순
			if(this.from == o.from) {
				return this.to == o.to ? this.distance - o.distance : this.to - o.to;
			}
			// from이 같지 않을 시 from 오름차순
			else {
				return this.from - o.from;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 지름길의 개수
		int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이
		List<Road> roads = new ArrayList<>(); // 지름길 객체를 저장할 리스트
		
		// 지름길 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()); // 시작 위치
			int to = Integer.parseInt(st.nextToken()); // 도착 위치
			int distance = Integer.parseInt(st.nextToken()); // 지름길의 길이
			
			// 지름길 거리가 고속도로로 가는 거리보다 크거나 같으면 고려하지 않기
			if(to-from <= distance) continue;
			// 시작 위치와 도착 위치가 고속도로의 길이보다 크면 고려하지 않기
			else if(from > D || to > D) continue;
			
			roads.add(new Road(from, to, distance));
		}
		
		Collections.sort(roads); // 지름길 객체리스트 정렬
		int[] distance = new int[D+1]; // 출발지에서 자신으로 오는 최소거리
		
		// distance 초기화 -> 지름길로 가지 않고 고속도로만 쭉 달렸을 때의 거리로 초기화
		for (int i = 0; i <= D; i++) {
			distance[i] = i;
		}
		
		// 지름길 객체를 하나씩 꺼내며 최소거리 갱신
		for (Road current: roads) {
			// 도착 위치의 최소거리가 지름길로 갔을때보다 작거나 같으면 최소거리 갱신 X
			if(distance[current.to] <= distance[current.from] + current.distance) continue;
			// 도착 위치 최소거리 갱신
			distance[current.to] = distance[current.from] + current.distance;
			// 도착 위치의 다음 위치부터 1씩 증가해가면서 최소거리 갱신
			for (int i = 1, dis = D-current.to; i <= dis; i++) {
				if(distance[current.to + i] <= distance[current.to] + i) break; // 더 이상 다음위치가 최소거리가 아니면 break
				distance[current.to + i] = distance[current.to] + i;
			}
		}
		
		// 결과 출력
		System.out.println(distance[D]);
	}
}
