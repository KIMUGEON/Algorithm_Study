import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(bf.readLine());

			int[][] stickers = new int[2][n+1];
			int[][] select = new int[2][n+1];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 1; j < n+1; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			select[0][1] = stickers[0][1];
			select[1][1] = stickers[1][1];
			
			for (int i = 2; i < n+1; i++) {
				select[0][i] = Math.max(select[1][i-1], select[1][i-2])+stickers[0][i];
				select[1][i] = Math.max(select[0][i-1], select[0][i-2])+stickers[1][i];
			}
			
			System.out.println(Math.max(select[0][n], select[1][n]));

		}
	}

}
