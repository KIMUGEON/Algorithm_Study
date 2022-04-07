package study_0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_김유완 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()); // 세로길이
		int W = Integer.parseInt(st.nextToken()); // 가로길이
		int max = Integer.MIN_VALUE; // 가장 최고높이인 높이
		int maxIndex = 0; // 가장 최고 높이 일때 인덱스
		int result = 0;
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
		}
		int start = arr[0];
		// 최대 높이 앞쪽까지
		for (int i = 0; i <= maxIndex; i++) {
			if(start>= arr[i]) {
				result += start - arr[i];
			}
			else {
				start = arr[i];
			}
		}
		// 뒤쪽부터
		start = arr[W-1];
		for (int i = W-1; i > maxIndex; i--) {
			if(start>= arr[i]) {
				result += start - arr[i];
			}
			else {
				start = arr[i];
			}
		}
		System.out.println(result);
	}
}