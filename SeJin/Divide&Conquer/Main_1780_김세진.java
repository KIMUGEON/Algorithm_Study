import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_김세진 {
	static int minus_cnt=0, zero_cnt=0,plus_cnt=0;
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		recur(0,0,N);
		System.out.println(minus_cnt);
		System.out.println(zero_cnt);
		System.out.println(plus_cnt);
	}
	
	static void recur(int start, int end, int size)
	{
		if(size==1)
		{
			if(map[start][end]==0)
				zero_cnt++;
			else if(map[start][end]<0)
				minus_cnt++;
			else
				plus_cnt++;
			return;
		}
		
		for(int i=start; i<start+size; i++)
		{
			for(int j=end; j<end+size; j++)
			{
				if(map[i][j]!=map[start][end])
				{
					recur(start,end,size/3);
					recur(start,end+(size/3),size/3);
					recur(start,end+(size/3)*2,size/3);
					
					recur(start+size/3,end,size/3);
					recur(start+size/3,end+(size/3),size/3);
					recur(start+size/3,end+(size/3)*2,size/3);
					
					recur(start+(size/3)*2,end,size/3);
					recur(start+(size/3)*2,end+(size/3),size/3);
					recur(start+(size/3)*2,end+(size/3)*2,size/3);
					return;
				}
			}
		}
		
		if(map[start][end]==0)
			zero_cnt++;
		else if(map[start][end]<0)
			minus_cnt++;
		else
			plus_cnt++;
	}

}
