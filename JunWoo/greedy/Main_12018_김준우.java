package _0415_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_12018_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int bet[] = new int[n];	//n번째 과목을 신청하기 위해 걸어야 하는 마일리지
		int subjects = 0;	//성준이가 들을 수 있는 과목수
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());	//신청인원
			int l = Integer.parseInt(st.nextToken());	//최대?수강인원
			
			//신청인원이 미달인 경우
			if(p<l) {
				br.readLine();
				bet[i] = 1;
				continue;
			}
			
			//현재 사람들이 배팅한 마일리지를 입력받아 정렬한다.
			int[] toto = new int[p];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < p; j++) {
				toto[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(toto);
			
			//l번째로 많이 배팅한 사람 만큼 배팅한다.
			bet[i] = toto[p-l];
		}
		Arrays.sort(bet);
		
		for(int i =0; i<n; i++) {
			if(m>=bet[i]) {
				m-= bet[i];
				subjects++;
			}
			else {
				break;
			}
		}
		System.out.println(subjects);
	}

}
