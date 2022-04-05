import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_동전_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		int[] comb = new int[k+1]; 
		
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(bf.readLine());
		}
		comb[0]=1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < k+1; j++) {
				if (j>=coin[i]) {
					comb[j]+=comb[j-coin[i]];
				}
			}
			for (int j = 0; j < comb.length; j++) {
				System.out.print(comb[j]+" ");
			} System.out.println();
		}
		
		System.out.println(comb[k]);
	}

}
