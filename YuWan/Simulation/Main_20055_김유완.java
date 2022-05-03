package study_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 칸의 수
		int K = Integer.parseInt(st.nextToken()); // 내구도가 0인칸의 수가 K개 이상이면 과정 종료
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N*2]; // 벨트 나타내기
		boolean[] arrR = new boolean[N]; // 로봇 위치
		int result = 0;
		for (int i = 0; i < N*2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		while(true) {
			result++; // 단계 증가
			
			// 벨트 회전
			int belt = arr[0]; // 첫칸
			for (int i = N*2-1; i > 0; i--) {
				int temp = (i+1)%(N*2);
				arr[temp] = arr[i];
			}
			arr[1] = belt;
			
			// 로봇이랑 회전
			for (int i = N-1; i >= 1; i--) {
				arrR[i] = arrR[i-1];
			}
			arrR[0] = false;
			arrR[N-1] = false; // 내리는 위치
			
			// 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다
			for (int i = N-2; i > 0; i--) {
				if(arrR[i]) {
					if(arr[i+1] >= 1 && !arrR[i+1]) {
						arr[i+1]--; // 내구도 감소
						arrR[i+1] = true;
						arrR[i] = false;
					}
				}
			}
			arrR[N-1] = false; // 내리는 위치
			
			// 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if(arr[0] != 0) {
				arrR[0] = true;
				arr[0]--;
			}
			
			// 내구도가 0인 칸의 개수가 K개 이상이면 과정 종료
			int count = 0;
			for (int i = 0; i < N*2; i++) {
				if(arr[i]==0) count++;
			}
			if(count >= K) break;
		}
		System.out.println(result);
	}
}
