import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_±èÁØ¿ì {

	public static void main(String[] args) throws IOException  {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 int N = Integer.parseInt(br.readLine());
		 int[] arr = new int[N];
		 int sum = 0;
		 
		 st = new StringTokenizer(br.readLine()," ");
		 for(int i = 0;i<N;i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 Arrays.sort(arr);
		 for(int i = 0;i<N;i++) {
			 sum += arr[i]*(N-i);
		 }
		 System.out.println(sum);
	}

}
