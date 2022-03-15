package study_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2304_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[N][2]; // 기둥들의 정보 받기
		int max = Integer.MIN_VALUE; // 가장 높은 기둥값
		int maxIndex = 0;
		int result = 0; // 전체 면적 계산하기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		// 정렬하기
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1] - o2[1];
				else return o1[0] - o2[0];
			}		
		});
		// 최대값 미리 찾아두기
		for (int i = 0; i < N; i++) {
			if(max<arr[i][1]) {
				max = arr[i][1];
				maxIndex = i;
			}
		}
		int h = 0; // 높이
		int curMax = 0;
		// 최대값 있는 곳까지 앞에서부터는 갱신해주면서 확인하면됨
		for (int i = 0; i <= maxIndex; i++) {
			h = arr[i][1];
			if(curMax < h) curMax = h;
			else arr[i][1] = curMax;
			// 넓이 구하기
			if(i == maxIndex) result += max;
			else result += (arr[i+1][0] - arr[i][0])*curMax;
		}
		// 뒤쪽부분 반대로 오기
		curMax = 0;
		for (int i = N-1; i > maxIndex; i--) {
			h = arr[i][1];
			if(curMax < h) curMax = h;
			else arr[i][1] = curMax;
			// 넓이 구하기
			result += (arr[i][0] - arr[i-1][0])*curMax;
		}
		System.out.println(result);
	}

}
