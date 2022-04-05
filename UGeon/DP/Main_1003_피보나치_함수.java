import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.net.ssl.SSLContext;

public class Main_1003_피보나치_함수 {

	static int N;
	static int[] cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(bf.readLine());
			cnt = new int[2];
			
			fibo(N);
			
			System.out.println(cnt[0] + " " + cnt[1]);
		}
	}
	
	public static int fibo(int n) {
		if (n == 0) {
			cnt[0]++;
			return 0;
		}
		else if (n == 1) {
			cnt[1]++;
			return 1;
		}
		else {
			return fibo(n-1) + fibo(n-2);
		}
	}
}