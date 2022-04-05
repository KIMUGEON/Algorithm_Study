import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] RGB = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			RGB[i][0] += Math.min(RGB[i-1][1], RGB[i-1][2]);
			RGB[i][1] += Math.min(RGB[i-1][0], RGB[i-1][2]);
			RGB[i][2] += Math.min(RGB[i-1][0], RGB[i-1][1]);
		}
		
		int Min = Math.min( Math.min(RGB[N-1][0], RGB[N-1][1]) , RGB[N-1][2] );
		
		System.out.println(Min);
	}
}
