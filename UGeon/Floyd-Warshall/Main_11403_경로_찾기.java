import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403_경로_찾기 {

	static int N;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		map = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N+1; i++) { // 경유지
			for (int j = 1; j < N+1; j++) { // 출발지
				for (int k = 1; k < N+1; k++) { // 도착지
					if (map[j][i]==1 && map[i][k]==1) map[j][k] = 1;
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) { 
				System.out.print(map[i][j] +" ");
			} System.out.println();
		}
		

	}

}
