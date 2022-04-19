package etc.그리디_알고리즘.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12018 { //Yonsei TOTO

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int res[] = new int[n];
		int cnt =0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			if (P >= L) {
				int mileage[] = new int[P];
				for (int j = 0; j < P; j++) {
					mileage[j] = Integer.parseInt(st.nextToken());
				}
				Arrays.sort(mileage);
				res[i] = mileage[P-L];
			} else {
				res[i] = 1;
			}
		}
		Arrays.sort(res);
		for(int i=0; i<n; i++) {
			if(res[i]>m) break;
			m -= res[i];
			cnt++;
		}
		System.out.println(cnt);
	}

}
