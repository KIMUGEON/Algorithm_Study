import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1182_부분수열의_합 {

	static int N,S,Cnt;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		Cnt = 0;
		arr = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		Partial(0, 0);
		System.out.println(Cnt);

	}
	
	public static void Partial(int s, int sum) {

		if(s>=N)
			return;
		
		sum += arr[s];
		
		if(sum == S) {
			Cnt++;
		}
		
		Partial(s+1, sum-arr[s]);
		Partial(s+1, sum);
	}

}
