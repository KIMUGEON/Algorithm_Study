import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp=0;
		int input[][] = new int[N][3];
		
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<3;j++)
				input[i][j]=Integer.parseInt(st.nextToken());
		}
		int result=Integer.MAX_VALUE;
		int idx=0;
		if(N==1)
			System.out.println(Math.min(input[0][2], Math.min(input[0][1], input[0][0])));
		for(int i=1;i<N;i++)
		{
			input[i][0] += Math.min(input[i-1][1], input[i-1][2]);
			input[i][1] += Math.min(input[i-1][0], input[i-1][2]);
			input[i][2] += Math.min(input[i-1][0], input[i-1][1]);
		}
		System.out.println(Math.min(input[N-1][2], Math.min(input[N-1][1], input[N-1][0])));
	}

}
