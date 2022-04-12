package _0408_플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11403_김준우 {
	static int N, INF = 10000000;
	static int a[][];
	
	public static void floydWarshall() {
		/*/ 결과 그래프를 초기화합니다. 
		int[][] d = new int[N][N];
		
		// 결과 그래프를 초기화합니다. 
		for(int i = 0; i < N; i++){
			d[i] = Arrays.copyOf(a[i], N);
		}*/
		
		// k = 거쳐가는 노드
		for(int k = 0; k < N; k++) {
			// i = 출발 노드
			for(int i = 0; i < N; i++) {
				// j = 도착 노드 
				for(int j = 0; j < N; j++) {
					if(a[i][k] == 1 && a[k][j] == 1) {
						a[i][j] = 1;
					}
					/*if(d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}*/
				}
			}
		}
		
		// 결과를 출력합니다. 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		} 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		a= new int[N][N];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		floydWarshall();
	}

}

