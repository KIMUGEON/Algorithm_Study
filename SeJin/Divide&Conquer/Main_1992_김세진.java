import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_김세진 {

	static int map[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++)
		{
			String temp = br.readLine();
			for(int j=0;j<N;j++)
			{
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		recur(0,0,N);
	}
	
	static void recur(int start_x, int start_y,int size)
	{
		int start = map[start_x][start_y];
		if(size==1)
		{
			System.out.print(start);
			return;
		}

		for(int x=start_x; x<start_x+size;x++)
		{
			for(int y=start_y; y<start_y+size; y++)
			{
				if(map[x][y]!=start)
				{
					System.out.print("(");
					recur(start_x, start_y,size/2);
					recur(start_x, start_y+size/2, size/2);
					recur(start_x+size/2, start_y, size/2);
					recur(start_x+size/2, start_y+size/2, size/2);
					System.out.print(")");
					return;
				}
			}
		}
		
		System.out.print(start);
	}

}
