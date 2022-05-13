import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한_배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게

		int[][] map = new int[N + 1][K + 1]; // 정보 저장 배열

		for (int i = 1; i < N + 1; i++) { // N개의 물품
			st = new StringTokenizer(bf.readLine());
			int W = Integer.parseInt(st.nextToken()); // 물건의 무게
			int V = Integer.parseInt(st.nextToken()); // 물건의 가치
			for (int j = 1; j < K + 1; j++) { // 버틸 수 있는 무게 K까지
				map[i][j] = map[i - 1][j]; // 이전 물건까지의 가치 현재 값에 저장
				if (j - W >= 0) { // 현재 버틸 수 있는 무게에서 현재 물건의 무게를 뺴고 무게가 남는다면
					map[i][j] = Math.max(map[i - 1][j], V + map[i - 1][j - W]); // 이전 무게까지의 가치 vs 현재 물건의 가치+이전 물건까지로 구한 남은 무게의 가치
				}
			}
		}

		System.out.println(map[N][K]); // 출력
/*		
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < K + 1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
*/
	}

}
