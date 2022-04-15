package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/12018
 * 걸린 시간 : 30분
 */
public class BOJ_2212_센서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 센서의 개수
		int K = Integer.parseInt(br.readLine()); // 집중국의 개수
		int[] sensors = new int[N]; // 센서의 위치 배열
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 센서 위치 입력
		for (int i = 0; i < N; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		
		// 집중국의 개수가 센서보다 많거나 같을 경우
		if (K >= N) {
			// 각 센서마다 집중국을 모두 배치할 수 있음 -> 수신 가능 영역 모두 0
			System.out.println(0);
			return;
		}
		
		Arrays.sort(sensors); // 센서 위치 오름차순 정렬
		
		int[] diff = new int[N-1]; // 각 센서끼리의 거리 차 배열
		
		// 거리 차 계산해서 저장
		for (int i = 0; i < N-1; i++) {
			diff[i] = sensors[i+1] - sensors[i];
		}
		
		Arrays.sort(diff); // 거리 차 배열 오름차순 정렬
		
		int ans = 0; // 문제의 답
		
		// 합할 거리 차 개수 -> 거리 차 배열의 크기에서 (집중국 개수 - 1)을 뺀 값
		// Why? (집중국 개수 - 1)만큼 센서와 센서 사이를 뛰어넘을 수 있기 때문
		int num = diff.length-(K-1); 
		
		// 거리 차 num개 합하기
		for (int i = 0; i < num; i++) {
			ans += diff[i];
		}
		
		// 결과 출력
		System.out.println(ans);
	}

}
