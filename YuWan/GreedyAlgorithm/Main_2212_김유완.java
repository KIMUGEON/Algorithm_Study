package study_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212_김유완 {
	// 문제 예시로 보면
	// 1,3,6,6,7,9 이렇게 순서대로 놓여져있을텐데
	// 1-3,3-6,6-6,6-7,7-9이렇게 서로 간의 거리가 계산될텐데 
	// 2개로 나눌수있으니 가장 거리차이가 큰 3-6부분을 중심으로 나누고
	// 그럼 [1,3] [6,6,7,9] 이렇게 두묶음인데 2+3으로 5가 수신가능영역 거리 합의 최솟값
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 센서 개수
		int K = Integer.parseInt(br.readLine()); // 집중국 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0; // 결과 (수신가능 영역의 길이의 합의 최소)
		int[] arr = new int[N];
		int[] distance = new int[N-1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
 		}
		Arrays.sort(arr); // 오름차순으로 일단 정렬
		// 각각 거리 차이를 구하기
		int count = 0;
		for (int i = 0; i < N-1; i++) {
			distance[i] = arr[i+1] - arr[i];
			if(distance[i] == 0) count++; // 같은 값
 		}
		if(N-count+1 <= K) result = 0; // 집중국 개수가 더 많거나 같을때
		else { // 어차피 합을 구하는 거니까 오름차순에서 앞에 작은 값만 더하자
			Arrays.sort(distance);
			for (int i = 0; i < N-K; i++) {
				result += distance[i];
			}
		}
		System.out.println(result);
	}

}