package _0222_백트래킹;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_김준우 {
	static int N, S;
	static int[] arr;
	static int num = 0;
	
	public static void select(int cnt, int start, int sum) {
		if(sum == S && cnt>0) {
			num++;
		}
		if(cnt == N) {
			return;
		}
		for(int i = start;i<N;i++) {
			select(cnt+1, i+1, sum + arr[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		select(0,0,0);
		
		System.out.println(num);
		
	}

}
