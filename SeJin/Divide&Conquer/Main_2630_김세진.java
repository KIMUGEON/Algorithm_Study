import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_김세진 {

	static int map[][];
	static int blue_cnt=0;
	static int white_cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		recur(0,0,N);
		System.out.println(white_cnt);
		System.out.println(blue_cnt);
 		
	}

	public static void recur(int x, int y, int size)
	{
		if(size==1)
		{
			if(map[x][y]==0)
				white_cnt++;
			else
				blue_cnt++;
			return;
		}
		int first = map[x][y];
		for(int i=x; i<x+size;i++)
		{
			for(int j=y; j<y+size;j++)
			{
				if(map[i][j]!=first)
				{
					recur(x, y,size/2); //1사분면
					recur(x, y+size/2, size/2);//2사분면
					recur(x+size/2, y, size/2); //3사분면
					recur(x+size/2, y+size/2, size/2);
					return;
				}
			}
		}
		if(first == 0)
			white_cnt++;
		else
			blue_cnt++;
		
		
	}
}
