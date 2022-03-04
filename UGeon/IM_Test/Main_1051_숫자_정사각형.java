import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051_숫자_정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (int)str.charAt(j);
			}
		}
		
		int size = Math.min(N, M);
		
		out:
		while (size>=1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(i+size-1>=N || j+size-1>=M) continue;
					if(map[i][j]==map[i][j+size-1] && map[i][j]==map[i+size-1][j] && map[i][j]==map[i+size-1][j+size-1]) {
						break out;
					}
				}
			}
			size--;
		}
		System.out.println(size*size);
	}
}