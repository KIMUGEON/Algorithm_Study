import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_2xn_타일링 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] way = new int[n+1];
		
		way[0] = 1;
		way[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			way[i] = way[i-1] + way[i-2];
			way[i] %= 10007;
		}
		
		System.out.println(way[n]);
	}
}
