import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580_김세진 {

	static int map[][]=new int[9][9];
	static int result;
	static int N;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<9;i++)
		{
			 st = new StringTokenizer(br.readLine()," ");
			 for(int j=0;j<9;j++)
				 map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		
		
	}
	public static boolean check2()
	{
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(map[i][j]==0)
					return false;
		
		return true;
	}
	public static void dfs(int x, int y)
	{
		if(y==9)
		{
			dfs(x+1,0);
			return;
		}
		if(x==9)
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(map[x][y]==0)
		{
			for(int i=1;i<=9;i++)
			{
				if(check(x,y,i))
				{
					map[x][y]=i;
					dfs(x,y+1);
				}
			}
			map[x][y]=0;
			return;
		}
		dfs(x,y+1);
	}
	
	public static boolean check(int x,int y,int value)
	{
		//가로
		for(int j=0;j<9;j++)
		{
			if(map[x][j]==value && y!=j)
				return false;
		}
	
		//세로
		for(int i=0;i<9;i++)
		{
			if(map[i][y]==value && x!=i)
				return false;
		}
		int where_x = x/3;
		int where_y = y/3;
		for(int i=where_x*3;i<(where_x+1)*3;i++)
		{
			for(int j = where_y*3;j<(where_y+1)*3;j++)
			{
				if(map[i][j] == value && (x!=i || y!=j))
				{
					return false;
				}
			}
		}
		return true;
	}

}
