import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값은 입력받은 배열을 정렬 후
		// 배열[0]부터 배열[현재 위치]까지의 배열 값을 모두 더하여
		// 더해진 값을 최종적으로 모두 더하여 출력
		int N = Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(bf.readLine());
		
		int[] arr = new int[N]; // 사람의 수
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 돈을 인출하는데 걸리는 시간이 빠른 순서대로 정렬
		
	
		int sum = 0;
		
		for(int i=N-1;i>=0;i--) { // 배열 끝 부분부터
			int j = i;
			while(j>=0) { // (본인이 인출하는데 걸리는 시간 + 대기하는 시간)을 sum에 더하기 
				sum += arr[j];
				j--;
			}
		}
		
		System.out.println(sum); // 출력

	}

}
