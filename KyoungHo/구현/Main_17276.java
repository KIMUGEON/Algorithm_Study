
import java.util.Scanner;

public class Main_17276 { //배열 돌리기

	static int n, map[][], map2[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			int d = sc.nextInt();
			map = new int[n][n];
			map2 = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map2[i][j] = map[i][j] = sc.nextInt();
				}
			}
			
			if(d<0) d += 360;
			int num = d/45;
			
			while(num>0) {
				num--;
				right();
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(map[i][j]+" ");
				}System.out.println();
			}
		}
	}

	private static void right() {
		
		for(int i=0; i<n; i++) {
			map2[i][n/2] = map[i][i];
			map2[i][i] = map[n/2][i];
			map2[n/2][i] = map[n-i-1][i];
			map2[n-i-1][i] = map[n-i-1][n/2];
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = map2[i][j];
			}
		}
		
	}

}
