import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_12018_Yonsei_TOTO {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
				
		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken()); // 성준이가 수강하려는 과목 수
		int m = Integer.parseInt(st.nextToken()); // 성준이에게 주어진 마일리지
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(); // 각 과목을 수강할 수 있는 최소 마일리지 정보
		
		for (int i = 0; i < n; i++) { // n개의 과목에 대한 정보
			st = new StringTokenizer(bf.readLine());

			int P = Integer.parseInt(st.nextToken()); // 해당 과목을 신청한 사람 수
			int L = Integer.parseInt(st.nextToken()); // 해당 과목의 최대 수강인원

			PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder()); // 해당 과목에 각 사람이 넣은 마일리지 정보. 가장 큰 마일리지 값부터 꺼내오기 위해 reverseOrder() 사용
			st = new StringTokenizer(bf.readLine());
			
			if (P >= L) { // 경쟁률이 1 이상이면
				for (int j = 0; j < P; j++) {
					que.add(Integer.parseInt(st.nextToken())); // 우선순위 큐에 사람들이 넣은 마일리지 add
				}
				for (int j = 0; j < L-1; j++) {
					que.poll(); // 최대 수강인원-1 번까지 poll
				}
				queue.add(que.poll()); // 최소한의 마일리지 사용. 마일리지가 같다면 성준이에게 우선순위가 주어지므로 즉, L번째로 많은 마일리지
			}
			else { // 경쟁률이 1 미만이면
				queue.add(1); // 최소한의 마일리지 사용. 즉, 1 마일리지
			}
		}
		

		int sum = 0;
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			sum += queue.poll(); // 가장 작은 마일리지부터 꺼내서 더하기
			if (m>=sum) cnt++; // 주어진 마일리지 이내이면 수강 가능 과목++
			else break; // 성준이에게 주어진 마일리지보다 많으면 종료
		}
		
		System.out.println(cnt); // 출력

	}

}
