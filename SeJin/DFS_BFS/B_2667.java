

import java.util.*;
import java.io.*;

public class B_2667 {
	static int[][] map = new int[25][25];
	static boolean[][] visited = new boolean[25][25];
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt;
	public static void bfs(int x,int y)
	{
		for(int i=0;i<4;i++)
		{
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx >=0 && ny >=0 && nx < N && ny < N)
			{
				if(visited[nx][ny]==false && map[nx][ny]==1)
				{
					cnt++;
					visited[nx][ny]=true;
					bfs(nx,ny);
				}
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException{
		 String path = B_2667.class.getResource("").getPath()+"input.txt";
		 System.setIn(new FileInputStream(path));
		 Scanner sc = new Scanner(System.in);
		 
		 N = sc.nextInt();
		 
		 
		 int[] result = new int[N];
		 int idx=0;
		 for(int i=0;i<N;i++)
		 {
			 String temp = sc.next();
			 for(int j=0;j<N;j++)
			 {
				 map[i][j]= temp.charAt(j)-'0';
			 }
		 }
		 
		 for(int i=0;i<N;i++)
		 {
			 for(int j=0;j<N;j++)
			 {
				 if(map[i][j]!=0 && visited[i][j]==false)
				 {
					 cnt++;
					 visited[i][j]=true;
					 bfs(i,j);
					 result[idx]=cnt;
					 cnt=0;
					 idx++;
				 }
				 
			 }
			 
		 }
		 
		 System.out.println(idx);
		 Arrays.sort(result);
		 for(int i=0;i<result.length;i++) {
			 if(result[i]!=0)
				 System.out.println(result[i]);
		 
		 }
		 
	}

}
