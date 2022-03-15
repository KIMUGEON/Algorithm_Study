import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
/*
  [입력]
첫째 줄에 지름길의 개수 N과 고속도로의 길이 D가 주어진다. 
N은 12 이하인 양의 정수이고, D는 10,000보다 작거나 같은 자연수이다. 
다음 N개의 줄에 지름길의 시작 위치, 도착 위치, 지름길의 길이가 주어진다. 
모든 위치와 길이는 10,000보다 작거나 같은 음이 아닌 정수이다. 
지름길의 시작 위치는 도착 위치보다 작다.

  [출력]
세준이가 운전해야하는 거리의 최솟값을 출력하시오.
 */
public class Main_1446 {//지름길

	public static void main(String[] args) throws IOException {
//		===============================  입력   ===================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		List<Way> shortcut = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			if(to>D) continue; //역주행 불가
			if(to-from<=dist) continue; //지름길 아니면 패스
			shortcut.add(new Way(from, to, dist));
		}
//		===============================  풀이   ===================================
		
		Collections.sort(shortcut, new Comparator<Way>(){ //길 정렬해주기

			@Override
			public int compare(Way o1, Way o2) {
				if(o1.from == o2.from) return o1.to - o2.to;
				return o1.from - o2.from;
			}
		});
		
		int move = 0;
		int idx = 0;
		int distance[] = new int[D+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		
		while(move<D) {
			if(idx < shortcut.size()) {
				Way way = shortcut.get(idx);
				
				if(move == way.from) {
					distance[way.to] = Math.min(distance[move] + way.dist, distance[way.to]);
					idx++;
				}else {
					distance[move+1] = Math.min(distance[move+1], distance[move] + 1);
					move++;
				}
			}else {
				distance[move+1] = Math.min(distance[move+1], distance[move] + 1);
				move++;				
			}
		}
//		===============================  출력   ===================================
		System.out.println(distance[D]);
	}
	
//		===============================  Way   ===================================
	public static class Way{
		int from, to, dist;

		public Way(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
	}

}
