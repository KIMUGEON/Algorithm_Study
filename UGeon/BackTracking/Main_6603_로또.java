import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_로또 {

	static int k;
	static int[] input,output;
	static boolean[] isCheck;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			k = Integer.parseInt(st.nextToken());
			
			input = new int[k];
			isCheck = new boolean[k];
			output = new int[6];
			
			if(k==0) break;
			
			for(int i = 0; i < k; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(input);
			selectNum(0, 0);
			System.out.println();
				
		}
		
	}
	
	public static void selectNum(int idx, int s) {
		if(idx==6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = s; i < k; i++) {
			output[idx] = input[i];
			selectNum(idx+1, i+1);	
		}
			
	}
	
}
