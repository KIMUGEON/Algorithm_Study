import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157_김세진 {
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[R][C];
		int cnt=1;
		int x=0,y=0;
		int idx=0;
		int target = Integer.parseInt(br.readLine());
		if(target > R*C)
		{
			System.out.println(0);
			return;
		}
		while(cnt!=target)
		{
			map[x][y]=cnt;
			cnt++;
			if(cnt == R*C+1)
				break;
			if(x+dx[idx] < 0 || y+dy[idx] < 0 || x+dx[idx] > R-1 || y+dy[idx] > C-1  || map[x+dx[idx]][y+dy[idx]] != 0)
			{
				idx++;
				idx%=4;
			}
			x = x+dx[idx];
			y = y+dy[idx];
		
		}
		System.out.println((y+1)+" "+(x+1));
	}

}
