package study_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12018_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 과목수
		int m = Integer.parseInt(st.nextToken()); // 주어진 마일리지
		int[] result = new int[n]; // 과목별로 마일리지 얼마 써야하는지 구해서 넣기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 과목에 신청한 사람수
			int l = Integer.parseInt(st.nextToken()); // 수강인원
			int[] arr = new int[p];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < p; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr); // 오름차순해놓고 과목 신청한 사람수랑 수강인원비교
			// 최소 1이고 최대가 36..
			if(p < l) result[i] = 1;
			else if(p == l) {
				if(arr[0] > 36) result[i] = -1;
				else result[i] = arr[0]; // 같으면 우선순위가 주어짐
			}
			else {
				int index = p - l;
				if(arr[index] > 36) result[i] = -1;
				else result[i] = arr[index];
			}
		}
		Arrays.sort(result);
		int i = 0;
		int sum = 0;
		int count = 0; // 들을 수 있는 과목수
		while(true) {
			if(i == n) break; // i n보다 작게 제한 두기
			if(result[i] != -1) { // 어차피 못들을 경우 제외
				sum += result[i];
				count++;
			}
			else sum += 1; // 최소 1점은 넣어야하는데 대신 count는 변함 없게
			if(sum > m) { // 더했는데 넘는다? count뺴고 나오기
				count--;
				break;
			}
			i++;
		}
		System.out.println(count);
	}
}