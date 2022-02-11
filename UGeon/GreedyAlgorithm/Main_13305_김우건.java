import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13305_김우건 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		// 배열로 구현하려다 큐를 사용하는게 편할 것 같아서 큐로 구현
		Queue<Integer> distance = new LinkedList<Integer>(); // 이동간 거리를 입력받을 distance 큐
		Queue<Integer> oilPrice = new LinkedList<Integer>(); // 도시의 리터당 기름 가격을 입력받을 oilPrice 큐
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N-1;i++) {
			distance.add(Integer.parseInt(st.nextToken())); // distance 큐에 정보 저장
		}
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			oilPrice.add(Integer.parseInt(st.nextToken())); // oilPrice 큐 정보 저장
		}
		
		long sum =0; // 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소 비용
		
		while(oilPrice.size()>1) { // oilPrice 큐의 제일 마지막 값이 사라지기 전까지. 즉, 제일 오른쪽 도시 이전까지 실행
			long tempO = oilPrice.poll(); // 현재 도시의 기름 가격 임시 저장 및 삭제
			long tempD = distance.poll(); // 현재 도시에서 다음 도시로 이동할 거리 임시 저장 및 삭제
			while(tempO<oilPrice.peek()) { // 이후 도시의 기름 가격이 현재 도시의 기름 가격보다 저렴할 때까지 실행/ 예제 입력2와 같은 상황을 고려해서 <= 대신 <로 교체
				oilPrice.poll(); // 현재 도시의 기름 가격보다 비싼 이후 도시의 기름 가격 정보 삭제
				tempD+=distance.poll(); // 이후 도시에서 그 다음 도시로 이동할 거리 더하기
			}
			sum += tempO*tempD; // 더 저렴한 기름 가격이 나올때까지 이동한 비용 더하기
		}
		
		System.out.println(sum); // 최소 비용 출력
	}

}
