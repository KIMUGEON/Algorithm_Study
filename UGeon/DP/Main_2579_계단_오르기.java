import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_계단_오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] step = new int[N+1];
		int[] max = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			step[i] = Integer.parseInt(bf.readLine());
		}
		
		if (N==1 || N==2) {
			max[N] = step[N-1] + step[N];
		}
		else if (N==3) {
			max[N] = step[N] + Math.max(step[N-2], step[N-1]);
		}
		else {
			max[1] = step[1];
			max[2] = step[1] + step[2];
			max[3] = step[3] + Math.max(step[1], step[2]);
			for (int i = 4; i <= N; i++) {
				max[i] = Math.max(max[i-3]+step[i-1], max[i-2]) + step[i];
			}
		}
		
		System.out.println(max[N]);
	}

}
