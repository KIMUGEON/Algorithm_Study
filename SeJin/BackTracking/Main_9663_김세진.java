import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_김세진 {

	static int map[][];
	static int result;
	static int N;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		result = 0;
		
		dfs(0,0);
		System.out.println(result);
	}
	
	public static void dfs(int x, int cnt)
	{
		if(cnt==N)
		{
			result++;
			return;
		}
		
		for(int i=0;i<N;i++)
		{
			if(check(x, i))
			{
				map[x][i]=1;
				dfs(x+1,cnt+1);
				map[x][i]=0;
			}
		}
	}
	
	public static boolean check(int x,int y)
	{
		//가로
		for(int j=0;j<N;j++)
		{
			if(map[x][j]!=0)
				return false;
		}
	
		//세로
		for(int i=0;i<N;i++)
		{
			if(map[i][y]!=0)
				return false;
		}
		//좌상우하 대각
		for(int i=1;i<N;i++)
		{
			if(x+i < N && y+i < N)
				if(map[x+i][y+i]!=0)
					return false;
		}
		for(int i=1;i<N;i++)
		{
			if(x-i >= 0 && y-i >= 0)
				if(map[x-i][y-i]!=0)
					return false;
		}
		
		//우상좌하 대각
		for(int i=1;i<N;i++)
		{
			if(x+i < N && y-i >= 0)
				if(map[x+i][y-i]!=0)
					return false;
		}
		for(int i=1;i<N;i++)
		{
			if(x-i >= 0 && y+i < N)
				if(map[x-i][y+i]!=0)
					return false;
		}
		return true;
	}

}
