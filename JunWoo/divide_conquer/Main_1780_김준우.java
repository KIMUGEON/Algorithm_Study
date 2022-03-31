package _0311_분할정복;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_김준우 {
	static int N;
	static int[][] paper;
	static int[] num;
	
	public static void separ(int r, int c, int l) {
		int nl = l/3;
		int[] dr = {0,0,0,nl,nl,nl,nl*2,nl*2,nl*2};
		int[] dc = {0,nl,nl*2,0,nl,nl*2,0,nl,nl*2};
		
		//System.out.println(r+" "+ c+" " + l);
		
		boolean allsame = true;
		for(int i = r;i<r+l;i++) {
			for(int j = c;j<c+l;j++) {
				if(paper[i][j] != paper[r][c]) {
					allsame = false;
				}
			}
		}
		
		if(allsame) {
			if(paper[r][c] == -1) num[0] += 1;
			else num[paper[r][c]+1] += 1;
			
			return;
		}
		
		for(int d = 0;d<9;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			separ(nr,nc,nl);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		num = new int[3];
		for(int n =0;n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int m =0;m<N;m++) {
				paper[n][m]= Integer.parseInt(st.nextToken());
			}
		}
		
		separ(0,0,N);
		for(int i = 0; i<3;i++) {
			System.out.println(num[i]);
		}
	}

}
