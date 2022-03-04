import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157_자리배정 {

	static int[] deltaX = new int[] {0,1,0,-1};
	static int[] deltaY = new int[] {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(bf.readLine());
		
		int[][] arr = new int[C][R]; 
		int x = 0, y = 0, d = 0, cnt = 1;
		
		if(R*C<K) 
			System.out.println(0);
		else {
			while (true) {
				
				arr[x][y] = cnt;
				
				if(cnt==K) break;
				
				int nextX = x + deltaX[d];
				int nextY = y + deltaY[d];
				
				if(nextX<0 || nextX>=C || nextY<0 || nextY>=R || arr[nextX][nextY]!=0) {
					d = (d+1)%4;
					nextX = x + deltaX[d];
					nextY = y + deltaY[d];
				}
				
				x = nextX;
				y = nextY;
				
				cnt++;
			}
			System.out.println((x+1)+" "+(y+1));
		}
	}
}