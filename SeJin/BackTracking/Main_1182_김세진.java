import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_김세진 {
	static int result=0, N, S;
	static int[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
			input[i] = Integer.parseInt(st.nextToken());
		
		permutation(0,new boolean[N]);
		if(S==0)
			System.out.println(result-1);//공집합 하나 뺴주기
		else
			System.out.println(result);
	}
	
	public static void permutation(int cnt, boolean visited[])
	{
		if(cnt==N) // 모든 원소 다 방문 하고
		{
			int sum=0;
			for(int i=0;i<N;i++)
				if(visited[i]==true)
					sum+=input[i];
			
			if(sum==S)
				result++;
			return;
		}
		visited[cnt]=true; // 해당 원소 넣기
		permutation(cnt+1,visited);
		visited[cnt]=false;// 해당원소 빼기
		permutation(cnt+1,visited);
		
	}

}
