import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_김세진 {
	static class fibo
	{
		int zeroCnt;
		int oneCnt;
		public fibo(int zeroCnt, int oneCnt) {
			super();
			this.zeroCnt = zeroCnt;
			this.oneCnt = oneCnt;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			int N = Integer.parseInt(br.readLine());
			fibo dp[] = new fibo[41];
			dp[0]=new fibo(1,0);
			dp[1]=new fibo(0,1);
			for(int i=2;i<=N;i++)
			{
				dp[i]=new fibo(dp[i-2].zeroCnt+dp[i-1].zeroCnt, dp[i-2].oneCnt+dp[i-1].oneCnt);
			}
			System.out.println(dp[N].zeroCnt +" "+dp[N].oneCnt);
		}
	}

}
