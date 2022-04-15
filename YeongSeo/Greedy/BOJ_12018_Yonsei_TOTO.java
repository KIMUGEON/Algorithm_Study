package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/12018
 * 걸린 시간 : 20분
 */
public class BOJ_12018_Yonsei_TOTO {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 과목 수
		int m = Integer.parseInt(st.nextToken()); // 주어진 마일리지
		int[] min = new int[n]; // 각 과목당 최소로 필요한 마일리지를 저장할 배열
		
		// 과목 수 만큼 반복
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()); // 과목에 신청한 사람 수
			int limit = Integer.parseInt(st.nextToken()); // 과목의 수강인원
			int[] inputs = new int[num]; // 과목의 각 사람이 넣은 마일리지 배열
			
			// 각 사람의 마일리지 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < num; j++) {
				inputs[j] = Integer.parseInt(st.nextToken());
			}
			
			// 수강신청한 인원이 최대 수강인원보다 적을 경우
			if (num < limit) {	
				min[i] = 1; // 1 마일리지만 넣어도 수강신청 가능
			}
			// 수강신청한 인원이 최대 수강인원보다 많거나 같을 경우
			else if (num >= limit) {
				Arrays.sort(inputs); // inputs 배열 오름차순 정렬
				min[i] = inputs[num-limit]; // 수강 가능한 마일리지 중 가장 작은 마일리지 저장
			}
		}

		Arrays.sort(min); // min 배열 오름차순 정렬
		int ans = 0; // 최대로 들을 수 있는 과목 개수
		
		// 과목 몇개 들을 수 있는지 구하기
		for (int i = 0; i < n; i++) {
			// 과목을 신청한 후 남은 마일리지가 0 이상이면 -> 과목 듣기 가능
			if (m - min[i] >= 0) ans++;
			// 현재 과목을 듣지 못하면 뒤에 과목도 다 듣지 못함 -> 반복문 나가기
			else break;
			
			// 남은 마일리지 갱신
			m -= min[i];
		}
		
		// 결과 출력
		System.out.println(ans);
	}

}
