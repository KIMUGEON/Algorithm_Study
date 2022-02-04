import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_10814 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String input[][] = new String[N][2];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			input[i][0]=st.nextToken();
			input[i][1]=st.nextToken();
			
		}
		
		Arrays.sort(input, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
			}
		});
		
		for(int i=0;i<N;i++)
		{
			System.out.println(input[i][0] + " " + input[i][1]);
		}
	}

}
