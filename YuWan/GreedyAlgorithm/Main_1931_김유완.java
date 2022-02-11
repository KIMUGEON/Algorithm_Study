package study_0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_김유완 {
	// 처음 코드 : 시작 시간으로 부터 오름차순을 차례로 해서 계속 비교 하면 메모리 초과, 시간 초과
	// comparator 사용해서 시작 시간으로부터 오름차순 -> 시간 초과
	// 끝나는 시간 체크할때 for문 중첩 -> 시간 초과
	// 끝나는 시간으로 오름차순을 해야 시간 초과 안뜸
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 회의 개수
		int[][] time = new int[N][2]; // 회의 시간 정보 저장하는 배열
		int end = 0;
		int max = 0; // 결과적으로 나올 수 있는 회의 수 최대값
		for(int n=0;n<N;n++) { // 회의 시작과 끝시간 정보를 저장하기
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[n][0] = Integer.parseInt(st.nextToken());
			time[n][1] = Integer.parseInt(st.nextToken());
		}
		// 오름차순으로 저장해서 시작 시간 부터 끝시간까지 얼마나 많은 회의가 사용할 수 있을지 확인
		// time을 오름차순으로 정렬
		Arrays.sort(time, new Comparator<int[]>() {			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1]; // 오름차순
			}
		});
		// 오름차순으로 끝나는 시간을 정렬
		// 끝나는 시간 가지고만 체크하기
		for(int i=0;i<N;i++) {
			if(end <= time[i][0]) {
				end = time[i][1];
				max++;
			}	
		}
		// 최대 개수 출력하기
		System.out.print(max);
	}
}