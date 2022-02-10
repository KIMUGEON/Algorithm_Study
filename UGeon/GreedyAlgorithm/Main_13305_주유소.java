import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13305_주유소 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		long tempO = 1000000001; // 리터당 가격이 1 이상 1,000,000,000 이하의 자연수이므로
		long sum = 0; // 최소 비용 초기 설정
		StringTokenizer st1 = new StringTokenizer(bf.readLine()); // 인접한 두 도시를 연결하는 도로의 길이 정보를 입력 받으려고
		StringTokenizer st2 = new StringTokenizer(bf.readLine()); // 각 도시 주유소의 리터당 가격 정보를 입력 받으려고
		for(int i=0;i<N-1;i++) {
			int distance = Integer.parseInt(st1.nextToken()); // 이동 길이 정보
			int oilPrice = Integer.parseInt(st2.nextToken()); // 기름 가격 정보
			if(oilPrice<tempO) { // 현재 도시의 기름 가격이 이전 도시의 기름 가격보다 저렴하면
				tempO = oilPrice; // tempO에 현재 도시의 기름 가격을 저장
				sum += tempO*distance; // (인접 도시까지의 이동 길이)*(현재 도시의 기름 가격)을 최소 비용에 더하기
			}
			else sum += tempO*distance; // 현재 도시의 기름 가격이 이전 도시의 기름 가격보다 비싸면 (인전 도시까지의 이동 길이)*(이전 도시의 기름 가격)을 최소 비용에 더하기
		}
		
		System.out.println(sum); // 최소 비용 출력
	}

}
