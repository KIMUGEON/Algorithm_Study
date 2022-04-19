package etc.그리디_알고리즘.Gold5;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2212 { //센서

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int sensor[] = new int[N];
		int len[] = new int[N-1];
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			sensor[i] = sc.nextInt();
		}
		
		Arrays.sort(sensor);
		
		for(int i=0; i<N-1; i++) {
			len[i] = sensor[i+1] - sensor[i];
		}
		
		Arrays.sort(len);
		
		for(int i=0; i<N-K; i++) { //len.length - (K - 1)
			ans += len[i];
		}
		System.out.println(ans);
	}
}
//tc 2 : [3~3] [6~8] [10~12] [14~15] [18~20] => 7
 
