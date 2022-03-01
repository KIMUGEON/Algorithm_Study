package _0301_IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] rec = new int[N][M];
		int max = 0;
		
		for( int i = 0;i<N;i++) {
			String str = br.readLine();
			for( int j = 0;j<M;j++) {
				rec[i][j] = str.charAt(j);
			}
		}
		
		for( int i = 0;i<N;i++) {
			for( int j = 0;j<M;j++) {
				int k = max;
				while(i+k<N && j+k<M) {
					if(rec[i][j] == rec[i+k][j] && rec[i][j] == rec[i][j+k] && rec[i][j] == rec[i+k][j+k]) {
						if(max<k) {
							max = k;
						}
					}
					k++;
				}
			}
		}
		System.out.println((max+1)*(max+1));
		
		
	}

}
