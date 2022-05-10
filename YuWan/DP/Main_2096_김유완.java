package study_0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] dpMin = new int[N][3]; // 최소값 구하려는 애
		int[][] dpMax = new int[N][3]; // 최대값 구하려는 애
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0) {
					dpMin[i][j] = arr[i][j];
					dpMax[i][j] = arr[i][j];
				}
			}
		}
		// 0번쨰는 0,1번쨰 수랑 합한거랑 비교해보고 
		// 1번째는 0,1,2번째 수랑 합한거랑 비교해보고
		// 2번째는 1,2번째 수랑 합한거랑 비교해보기
		for (int i = 1; i < N; i++) {
			dpMin[i][0] = Math.min(arr[i][0] + dpMin[i-1][0], arr[i][0] + dpMin[i-1][1]);
			dpMin[i][1] = Math.min(Math.min(arr[i][1] + dpMin[i-1][0], arr[i][1] + dpMin[i-1][1]),arr[i][1] + dpMin[i-1][2]);
			dpMin[i][2] = Math.min(arr[i][2] + dpMin[i-1][1], arr[i][2] + dpMin[i-1][2]);
			dpMax[i][0] = Math.max(arr[i][0] + dpMax[i-1][0], arr[i][0] + dpMax[i-1][1]);
			dpMax[i][1] = Math.max(Math.max(arr[i][1] + dpMax[i-1][0], arr[i][1] + dpMax[i-1][1]),arr[i][1] + dpMax[i-1][2]);
			dpMax[i][2] = Math.max(arr[i][2] + dpMax[i-1][1], arr[i][2] + dpMax[i-1][2]);
		}
		int min = Math.min(Math.min(dpMin[N-1][0], dpMin[N-1][1]), dpMin[N-1][2]);
		int max = Math.max(Math.max(dpMax[N-1][0], dpMax[N-1][1]), dpMax[N-1][2]);
		System.out.println(max + " " + min);
	}

}
