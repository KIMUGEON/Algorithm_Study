import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_김세진 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			int N = Integer.parseInt(br.readLine());
			int dp[] = new int[11];
			
			dp[0]=1;
			dp[1]=2;
			dp[2]=4;
			
			for(int j=3;j<N;j++)
				dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
			
			System.out.println(dp[N-1]);
		}
		

	}

}
