import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_11399_김세진 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int input[] = new int[N];
		int result=0;
		for(int i=0;i<N;i++)
			input[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(input);
		
		for(int i=0;i<N;i++)
			for(int j=0;j<=i;j++)
			{
				result+=input[j];
			}
		System.out.println(result);
	}

}
