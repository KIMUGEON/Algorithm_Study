import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17829_김세진 {
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map=new int[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		System.out.println(divide(0,0,N/2));

	}

	static int divide(int start, int end, int size)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(size==1)
		{
			list.add(map[start][end]);
			list.add(map[start+1][end]);
			list.add(map[start][end+1]);
			list.add(map[start+1][end+1]);
			Collections.sort(list);
			return list.get(2);
		}
		else
		{
			list.add(divide(start,end,size/2));
			list.add(divide(start +size,end,size/2));
			list.add(divide(start,end+size,size/2));
			list.add(divide(start+size,end+size,size/2));
			Collections.sort(list);
			return list.get(2);
		}
	}
}
