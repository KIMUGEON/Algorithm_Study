import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1463_1로_만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] Num = new int[N+1];
		
		Num[1] = 0;
		
		for (int i = 2; i < N+1; i++) {
			Num[i] = Num[i-1]+1;
			if (i%3 == 0) Num[i] = Math.min(Num[i], Num[i/3]+1);
			if (i%2 == 0) Num[i] = Math.min(Num[i], Num[i/2]+1);
		}
		System.out.println(Num[N]);
	}

}
