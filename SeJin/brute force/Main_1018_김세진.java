


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class B_1018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char B_start_map[][] = new char[8][8];
		char W_start_map[][] = new char[8][8];
		
		for(int i=0;i<8;i++)
		{
			if(i%2==0)
			{
				for(int j=0;j<8;j+=2)
				{
					B_start_map[i][j]='B';
					B_start_map[i][j+1]='W';
					W_start_map[i][j]='W';
					W_start_map[i][j+1]='B';
				}
			}
			else
			{
				for(int j=0;j<8;j+=2)
				{
					B_start_map[i][j]='W';
					B_start_map[i][j+1]='B';
					W_start_map[i][j]='B';
					W_start_map[i][j+1]='W';
				}
			}
		}
		char map[][] = new char[N][M];
		for(int i=0;i<N;i++)
		{
			String temp=sc.next();
			for(int j=0;j<M;j++)
			{
				map[i][j]=temp.charAt(j);
			}
		}
		int B_cnt=0;
		int W_cnt=0;
		int result = 64;
		for(int i=0;i<=N-8;i++)
		{
			for(int j=0;j<=M-8;j++)
			{
				B_cnt=0;
				W_cnt=0;
				for(int k=0;k<8;k++)
				{
					for(int n=0;n<8;n++)
					{
						if(map[k+i][n+j]!=B_start_map[k][n])
						{
							B_cnt++;
						}
						if(map[k+i][n+j]!=W_start_map[k][n])
						{
							W_cnt++;
						}
					}
				}
				result=Math.min(result, Math.min(B_cnt, W_cnt));
			}
		}
		System.out.println(result);
		
	}

}
