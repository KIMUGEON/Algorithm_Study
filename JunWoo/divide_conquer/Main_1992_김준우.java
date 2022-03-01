package _0218_분할정복;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_김준우 {
	static int N;
	static int[][] video;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		
		for(int i = 0;i<N;i++) {
			String str = br.readLine();
			for(int j = 0;j<N;j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}
		
		quadTree(N,0,0);
		System.out.println(sb);
	}
	
	public static void quadTree(int n, int r, int c) {
		if(n==1);
		boolean comp = true;	//압축할지 여부
		int[] dr = {0,0,n/2,n/2};
		int[] dc = {0,n/2,0,n/2};
		
		if(n == 1) {
			sb.append(video[r][c]);
			return;
		}
		
		//=======compression===========
		loop:
			for(int i = r;	i<r+n;	i++) {
				for(int j = c;	j<c+n;	j++) {
					if(video[i][j] != video[r][c]) {	//if every pixels of the range are same, compress them 
						comp = false;
						break loop;
					}
				}
			}
		if(comp) {
			sb.append(video[r][c]);
			return;
		}
		
		sb.append("(");
		for(int d = 0;d<4;d++) {
			comp = true;
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			quadTree(n/2,nr,nc);
		}
		sb.append(")");
	}

}
