import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_1_2_3_더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			int n = Integer.parseInt(bf.readLine());
			
			int[] num = new int[12];
			
			num[1] = 1; // 1
			num[2] = 2; // 1+1   2
			num[3] = 4; // 1+1+1   1+2   2+1   3
			
			for (int i = 4; i <= n; i++) {
				num[i] = num[i-3] + num[i-2] + num[i-1];
			}
			
			System.out.println(num[n]);
		}
	}
}